package com.example.my_first_jpa_app.controller;

import com.example.my_first_jpa_app.domain.Dancer;
import com.example.my_first_jpa_app.domain.DancerDTO;
import com.example.my_first_jpa_app.domain.DancerMapper;
import com.example.my_first_jpa_app.service.DancerService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping("/api/dancers")
public class DancerController {

    private final DancerService dancerService;

    private final DancerMapper dancerMapper;

    @PostMapping
    ResponseEntity<DancerDTO> createDancer(@RequestBody DancerDTO dancerDTO){
        Dancer toSave = dancerService.createDancer(dancerMapper.dancerDTOToDancer(dancerDTO));

        return new ResponseEntity<>(dancerMapper.dancerToDancerDTO(toSave), HttpStatus.valueOf(201));
    }

    @GetMapping("/{dancerID}")
    ResponseEntity <DancerDTO> getDancerById(@PathVariable("dancerID") Integer dancerID) {
        Dancer founded = dancerService.getDancer(dancerID);
        return new ResponseEntity<>(dancerMapper.dancerToDancerDTO(founded), HttpStatus.OK);
    }

    @GetMapping
    ResponseEntity <List<DancerDTO>> getAllDancers()  throws DancerNotFoundException {
        List<DancerDTO> dancersDTO = dancerService
                .getAllDancers()
                .stream()
                .map(dancerMapper::dancerToDancerDTO)
                .collect(Collectors.toList());
        return new ResponseEntity<>(dancersDTO, HttpStatus.OK);
    }
}

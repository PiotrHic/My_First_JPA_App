package com.example.my_first_jpa_app.controller;

import com.example.my_first_jpa_app.domain.Dancer;
import com.example.my_first_jpa_app.domain.DancerDTO;
import com.example.my_first_jpa_app.domain.DancerMapper;
import com.example.my_first_jpa_app.service.DancerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}

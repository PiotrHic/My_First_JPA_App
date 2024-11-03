package com.example.my_first_jpa_app.controller;

import com.example.my_first_jpa_app.domain.Dancer;
import com.example.my_first_jpa_app.domain.DancerDTO;
import com.example.my_first_jpa_app.domain.DancerMapper;
import com.example.my_first_jpa_app.service.DancerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping("/api/dancers")
public class DancerController {

    private static final Logger LOGGER
            = LoggerFactory.getLogger(DancerController.class);


    private final DancerService dancerService;

    private final DancerMapper dancerMapper;

    @Operation(summary = "It adds a new dancer to the database")
    @ApiResponse(responseCode = "201",
                description = "Add new Dancer to the database",
                content = {@Content(mediaType =  "application/json")})
    @PostMapping
    ResponseEntity<DancerDTO> createDancer(@RequestBody DancerDTO dancerDTO){
        Dancer toSave = dancerService.createDancer(dancerMapper.dancerDTOToDancer(dancerDTO));
        LOGGER.info("Dancer was saved in the DB : {}", toSave.getName());
        return new ResponseEntity<>(dancerMapper.dancerToDancerDTO(toSave), HttpStatus.valueOf(201));
    }
    @Operation(summary = "It updates dancer with the new data")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                        description = "Update dancer to the database",
                        content = {@Content(mediaType =  "application/json")}),
            @ApiResponse(responseCode = "404",
                    description = "Dancer was not found in database",
                    content = {@Content(mediaType =  "application/json")}),
    })
    @PutMapping("/{dancerID}")
    ResponseEntity <DancerDTO> updateDancerById(@PathVariable("dancerID") Integer dancerID, @RequestBody DancerDTO dancerDTO) {
        Dancer updated = dancerService.updateDancer(dancerID, dancerMapper.dancerDTOToDancer(dancerDTO));
        LOGGER.info("Dancer was updated in the DB : {}", updated.getName());
        return new ResponseEntity<>(dancerMapper.dancerToDancerDTO(updated), HttpStatus.OK);
    }

    @Operation(summary = "It brings one dancer from the database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Get one dancer from the database",
                    content = {@Content(mediaType =  "application/json")}),
            @ApiResponse(responseCode = "404",
                    description = "Dancer was not found in database",
                    content = {@Content(mediaType =  "application/json")}),
    })
    @GetMapping("/{dancerID}")
    ResponseEntity <DancerDTO> getDancerById(@PathVariable("dancerID") Integer dancerID) {
        Dancer founded = dancerService.getDancer(dancerID);
        LOGGER.info("Dancer was funded in the DB : {}", founded.getName());
        return new ResponseEntity<>(dancerMapper.dancerToDancerDTO(founded), HttpStatus.OK);
    }

    @Operation(summary = "Takes all dancers from the database")
    @ApiResponse(responseCode = "200",
            description = "Gives all dancers from the database",
            content = {@Content(mediaType =  "application/json")})
    @GetMapping
    ResponseEntity <List<DancerDTO>> getAllDancers()  throws DancerNotFoundException {
        List<DancerDTO> dancerDTOs = dancerService
                .getAllDancers()
                .stream()
                .map(dancerMapper::dancerToDancerDTO)
                .collect(Collectors.toList());
        LOGGER.info("All Dancers were found: size {}", dancerDTOs.size());
        return new ResponseEntity<>(dancerDTOs, HttpStatus.OK);
    }


    @Operation(summary = "It deletes one dancer from the database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Deletes one dancer from the database",
                    content = {@Content(mediaType =  "application/json")}),
            @ApiResponse(responseCode = "404",
                    description = "Dancer was not found in database",
                    content = {@Content(mediaType =  "application/json")}),
    })
    @DeleteMapping("/{dancerID}")
    ResponseEntity <DancerDTO> deleteDancerById(@PathVariable("dancerID") Integer dancerID) throws DancerNotFoundException {
        Dancer deleted = dancerService.deleteDancer(dancerID);
        LOGGER.info("Dancer was deleted from the  DB : id {}", dancerID);
        return new ResponseEntity<>(dancerMapper.dancerToDancerDTO(deleted), HttpStatus.OK);
    }

    @Operation(summary = "Deletes all dancers from the database")
    @ApiResponse(responseCode = "200",
            description = "Deletes all dancers from the database",
            content = {@Content(mediaType =  "application/json")})
    @DeleteMapping()
    ResponseEntity <String> deleteAllDancers(){
        dancerService.deleteAllDancers();
        LOGGER.info("Dancers were deleted from the DB");
        return new ResponseEntity<>("Database is empty", HttpStatus.OK);
    }
}

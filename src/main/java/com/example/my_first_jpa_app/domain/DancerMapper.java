package com.example.my_first_jpa_app.domain;

import org.springframework.stereotype.Component;

@Component
public class DancerMapper {

    public DancerDTO dancerToDancerDTO(Dancer dancer){
        return new DancerDTO(dancer.getId(), dancer.getName(), dancer.getDanceStyle());
    }

    public Dancer dancerDTOToDancer(DancerDTO dancerDTO){
        return new Dancer(dancerDTO.getId(), dancerDTO.getName(), dancerDTO.getDanceStyle());
    }
}

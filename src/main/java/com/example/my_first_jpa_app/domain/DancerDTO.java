package com.example.my_first_jpa_app.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DancerDTO {
    private Integer id;
    private String name;
    private String danceStyle;

    public DancerDTO(String name, String danceStyle) {
        this.name = name;
        this.danceStyle = danceStyle;
    }
}
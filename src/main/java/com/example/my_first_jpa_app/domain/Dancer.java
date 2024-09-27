package com.example.my_first_jpa_app.domain;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Dancer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Integer id;
    private String name;
    private String danceStyle;

    public Dancer(String name, String danceStyle) {
        this.name = name;
        this.danceStyle = danceStyle;
    }

}

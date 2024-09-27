package com.example.my_first_jpa_app.service;

import com.example.my_first_jpa_app.domain.Dancer;

import java.util.List;

public interface DancerService {

    Dancer createDancer(Dancer dancer);

    Dancer getDancer (Integer id);
    List<Dancer> getAllDancers();

    Dancer updateDancer (Integer id, Dancer dancer);

    Dancer deleteDancer (Integer id);
    void deleteAllDancers ();
}

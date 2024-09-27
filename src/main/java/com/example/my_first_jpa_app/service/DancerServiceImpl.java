package com.example.my_first_jpa_app.service;

import com.example.my_first_jpa_app.domain.Dancer;
import com.example.my_first_jpa_app.repository.DancerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DancerServiceImpl implements DancerService {

    private final DancerRepository dancerRepository;
    @Override
    public Dancer createDancer(Dancer dancer) {
        return dancerRepository.save(dancer);
    }

    @Override
    public Dancer getDancer(Integer id) {
        return dancerRepository.getReferenceById(id);
    }


    @Override
    public List<Dancer> getAllDancers(){
        return dancerRepository.findAll();
    }

    @Override
    public Dancer updateDancer(Integer id, Dancer dancer) {

        Dancer toUpdate = dancerRepository.getReferenceById(id);
        toUpdate.setName(dancer.getName());
        toUpdate.setDanceStyle(dancer.getDanceStyle());
        return dancerRepository.save(toUpdate);
    }

    @Override
    public Dancer deleteDancer(Integer id) {
        Dancer deleted = dancerRepository.getReferenceById(id);
        dancerRepository.deleteById(id);
        return deleted;
    }

    @Override
    public void deleteAllDancers() {
        dancerRepository.deleteAll();
    }

}
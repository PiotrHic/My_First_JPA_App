package com.example.my_first_jpa_app.repository;

import com.example.my_first_jpa_app.domain.Dancer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class DancerRepositoryTest {

    @Autowired
    DancerRepository dancerRepository;

    @BeforeEach
    void setUp(){
        dancerRepository.deleteAll();
    }


    @Test
    void createDancer(){
        long count = dancerRepository.count();

        assertThat(count).isEqualTo(0);

        dancerRepository.save(new Dancer("test", "rumba"));

        count = dancerRepository.count();

        assertThat(count).isEqualTo(1);
    }

    @Test
    void getAllDancers(){
        long count = dancerRepository.count();

        assertThat(count).isEqualTo(0);

        dancerRepository.save(new Dancer("test", "rumba"));
        dancerRepository.save(new Dancer("test1", "rumba"));

        count = dancerRepository.count();

    }

    @Test
    void getOneDancerById(){

        long count = dancerRepository.count();

        assertThat(count).isEqualTo(0);

        Dancer first = new Dancer("test", "rumba");

        dancerRepository.save(first);

        count = dancerRepository.count();

        assertThat(count).isEqualTo(1);

        Dancer founded = dancerRepository.getReferenceById(first.getId());

        assertThat(founded.getName()).isEqualTo("test");

    }

    @Test
    void deleteDancerById(){

        long count = dancerRepository.count();

        assertThat(count).isEqualTo(0);

        Dancer first = new Dancer("test","rumba");

        dancerRepository.save(first);

        count = dancerRepository.count();

        assertThat(count).isEqualTo(1);

        dancerRepository.deleteById(first.getId());

        count = dancerRepository.count();

        assertThat(count).isEqualTo(0);
    }


    @Test
    void deleteAllDancersId() {
        long count = dancerRepository.count();

        assertThat(count).isEqualTo(0);

        dancerRepository.save(new Dancer("test", "rumba"));
        dancerRepository.save(new Dancer("test1", "rumba"));

        count = dancerRepository.count();

        assertThat(count).isEqualTo(2);

        dancerRepository.deleteAll();

        count = dancerRepository.count();

        assertThat(count).isEqualTo(0);

    }
}
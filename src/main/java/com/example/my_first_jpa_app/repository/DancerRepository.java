package com.example.my_first_jpa_app.repository;

import com.example.my_first_jpa_app.domain.Dancer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DancerRepository extends JpaRepository<Dancer, Integer> {
}

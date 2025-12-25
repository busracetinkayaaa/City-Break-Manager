package com.example.CityBreakManager.repository;


import com.example.CityBreakManager.model.City;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CityRepository extends JpaRepository<City,Long> {
    boolean existsByName(String name);
    // CityRepository içine
    List<City> findByNameContaining(String name);

}

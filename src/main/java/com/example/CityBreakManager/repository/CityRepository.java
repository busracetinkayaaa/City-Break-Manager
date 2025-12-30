package com.example.CityBreakManager.repository;


import com.example.CityBreakManager.model.City;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CityRepository extends JpaRepository<City,Long> {
    boolean existsByNameIgnoreCase(String name);
    // CityRepository içine
    List<City> findByNameContaining(String name);

    Optional<City> findByNameIgnoreCase(String cityName);


}

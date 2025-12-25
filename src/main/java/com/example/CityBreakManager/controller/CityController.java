package com.example.CityBreakManager.controller;

import com.example.CityBreakManager.model.City;
import com.example.CityBreakManager.service.CityService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cities")
public class CityController {

    private final CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @PostMapping
    public City addCity(@RequestBody City city)
    {
        return cityService.addCity(city);
    }
    @GetMapping
    public List<City> getAllCities()
    {
        return cityService.getAllCities();
    }
    @GetMapping("/{id}")
    public City getCityById(@PathVariable("id") Long id)
    {
        return cityService.getCityById(id);
    }
    @PutMapping("/{id}")
    public City updateCity(@PathVariable("id") Long id, @RequestBody City city){
        return cityService.updateCity(id,city);
    }

    @DeleteMapping("/{id}")
    public void deleteCity(@PathVariable("id") Long id){
         cityService.deleteCity(id);

    }
}

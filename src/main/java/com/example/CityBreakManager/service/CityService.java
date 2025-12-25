package com.example.CityBreakManager.service;

import com.example.CityBreakManager.model.City;
import com.example.CityBreakManager.repository.CityRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {
    private final CityRepository cityRepository;

    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public City addCity(City city){
        if((city.getName() == null) || (city.getName().isBlank())){
            throw new IllegalArgumentException("Şehir ismi boş olamaz");
        }
        if(cityRepository.existsByName(city.getName())){

            throw new IllegalStateException("Şehir zaten var");
        }
        return cityRepository.save(city);
    }

    public List<City> getAllCities(){
        return cityRepository.findAll();
    }

    public City getCityById(Long id){
        return cityRepository.findById(id).orElseThrow(()->new RuntimeException("Bu id ile şehir bulunamadı."+id));
    }

    public City updateCity(Long id,City updatedCity) {
        City city=getCityById(id);

        city.setName(updatedCity.getName());
        city.setCountry(updatedCity.getCountry());
        city.setDetail(updatedCity.getDetail());

        return cityRepository.save(city);
    }
    public void deleteCity(Long id){
         cityRepository.deleteById(id);
    }
}

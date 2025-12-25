package com.example.CityBreakManager.service;

import com.example.CityBreakManager.model.City;
import com.example.CityBreakManager.repository.CityRepository;
import com.example.CityBreakManager.repository.TripRepository;
import com.example.CityBreakManager.model.Trip;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TripService {
    private final TripRepository tripRepository;
    private final CityRepository cityRepository;

    public TripService(TripRepository tripRepository, CityRepository cityRepository) {
        this.tripRepository = tripRepository;
        this.cityRepository = cityRepository;
    }
    public Trip addTrip(Long cityId, Trip trip){
        City city = cityRepository.findById(cityId).orElseThrow(()->new RuntimeException("Şehir bulunamadı."));
        trip.setCity(city);
        return tripRepository.save(trip);
    }

    public List<Trip> getAllTrips(){
        return tripRepository.findAll();
    }

    public Trip getTripById(Long id){
        return tripRepository.findById(id).orElseThrow(()->new RuntimeException("Gezi bulunamadı."));
    }

    public List<Trip> getTripsByCity(Long cityId){
        return (List<Trip>) tripRepository.findById(cityId).orElseThrow(()->new RuntimeException("Bu şehirde gezi bulunamadı."));
    }
    public Trip updateTrip(Long id, Trip updatedTrip){
        Trip trip=getTripById(id);

        trip.setCity(updatedTrip.getCity());
        trip.setNotes(updatedTrip.getNotes());
        trip.setNotes(updatedTrip.getNotes());
        trip.setStartDate(updatedTrip.getStartDate());
        trip.setEndDate(updatedTrip.getEndDate());
        trip.setRating(updatedTrip.getRating());

        return tripRepository.save(trip);

    }
    public void deleteTrip(Long id){
        tripRepository.deleteById(id);
    }

}

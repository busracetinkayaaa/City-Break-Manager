package com.example.CityBreakManager.controller;


import com.example.CityBreakManager.model.Trip;
import com.example.CityBreakManager.service.TripService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trips")
public class TripController {
    private final TripService tripService;

    public TripController(TripService tripService) {
        this.tripService = tripService;
    }

    @PostMapping("/city/{cityId}")
    public Trip addTrip( @PathVariable("cityId") Long cityId,@RequestBody Trip trip){
        return tripService.addTrip(cityId,trip);
    }

    @GetMapping()
    public List<Trip> getAllTrips(){
        return tripService.getAllTrips();
    }

    @GetMapping("/trip/{id}")
    public Trip getTripById(@PathVariable("id") Long id){
        return tripService.getTripById(id);
    }

    @GetMapping("/city/{cityId}")
    public List<Trip> getTripsByCity(@PathVariable("cityId") Long cityId){
        return tripService.getTripsByCity(cityId);
    }

    @PutMapping("/update/{id}")
    public Trip updateTrip(@PathVariable("id") Long id,@RequestBody Trip trip){
        return tripService.updateTrip(id,trip);
    }

    @DeleteMapping("/{id}")
    public void deleteTrip(@PathVariable("id") Long id){
        tripService.deleteTrip(id);
    }
}

package com.example.CityBreakManager.controller;


import com.example.CityBreakManager.model.Trip;
import com.example.CityBreakManager.service.TripService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/trips")

public class TripController {
    private final TripService tripService;

    public TripController(TripService tripService) {
        this.tripService = tripService;
    }

    @PostMapping("/city/{cityId}")
    public Trip addTrip( @PathVariable("cityId") Long cityId ,@RequestBody Trip trip){
        return tripService.addTrip(cityId,trip);
    }

    @GetMapping()
    public List<Trip> getAllTrips(){
        return tripService.getAllTrips();
    }

    @GetMapping("/city/{cityId}")
    public List<Trip> getTripsByCity(@PathVariable("cityId") Long cityId) {
        // Bu metodun service katmanında "o şehre ait tüm gezileri" dönmesi gerekir
        return tripService.getTripsByCityId(cityId);
    }
    @GetMapping("/search")
    public ResponseEntity<List<Trip>> searchTrips(@RequestParam("keyword") String keyword) {
        List<Trip> results = tripService.searchTrips(keyword);

        if (results.isEmpty()) {
            return ResponseEntity.noContent().build(); // 204 No Content (Opsiyonel)
        }

        return ResponseEntity.ok(results);
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

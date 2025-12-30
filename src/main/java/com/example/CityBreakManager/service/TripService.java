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
    public Trip addTrip(Long cityId, Trip trip) {
        City city = cityRepository.findById(cityId)
                .orElseThrow();

        trip.setCity(city);
        return tripRepository.save(trip);
    }

    public List<Trip> getAllTrips(){
        return tripRepository.findAll();
    }


    public List<Trip> getTripsByCityId(Long cityId) {
        // findById yerine findByCityId kullanıyoruz çünkü bir liste bekliyoruz
        List<Trip> trips = tripRepository.findByCityId(cityId);

        // Eğer liste boşsa hata fırlatmak yerine boş liste dönmek React tarafı için daha iyidir
        // Ama mutlaka hata fırlatmak istersen:
        if (trips.isEmpty()) {
            System.out.println(cityId + " ID'li şehir için gezi bulunamadı.");
        }

        return trips;
    }

    public List<Trip> searchTrips(String keyword){
        if (keyword == null || keyword.isBlank()) {
            return tripRepository.findAll();
        }
        return tripRepository.findByCity_NameContainingIgnoreCaseOrCity_CountryContainingIgnoreCase(keyword, keyword);
    }
    public Trip updateTrip(Long id, Trip updatedTrip){
        return tripRepository.findById(id).map(existingTrip -> {
            existingTrip.setStartDate(updatedTrip.getStartDate());
            existingTrip.setEndDate(updatedTrip.getEndDate());
            existingTrip.setRating(updatedTrip.getRating());
            existingTrip.setNotes(updatedTrip.getNotes());

            return tripRepository.save(existingTrip);
        }).orElseThrow(() -> new RuntimeException("Gezi bulunamadı."));

    }
    public void deleteTrip(Long id){
        tripRepository.deleteById(id);
    }


}

package com.example.CityBreakManager.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Trip {

    @Id
    @GeneratedValue()

    private Long id;
    @ManyToOne
    @JoinColumn(name = "cityId")
    private City city;
    private LocalDate endDate;
    private LocalDate startDate;
    private int rating;
    private String notes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}

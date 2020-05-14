package com.example.codeclan.course_bookings.controllers;

import com.example.codeclan.course_bookings.models.Booking;
import com.example.codeclan.course_bookings.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookingController {

    @Autowired
    BookingRepository bookingRepository;

    @GetMapping(value = "/bookings")
    public ResponseEntity<List<Booking>> getAllBookings() {
        List<Booking> foundBookings = bookingRepository.findAll();
        return new ResponseEntity<>(foundBookings, HttpStatus.OK);
    }

}

package com.example.codeclan.course_bookings.controllers;

import com.example.codeclan.course_bookings.models.Booking;
import com.example.codeclan.course_bookings.repositories.BookingRepository;
import com.sun.xml.bind.v2.runtime.reflect.opt.OptimizedAccessorFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookingController {

    @Autowired
    BookingRepository bookingRepository;

    @GetMapping(value = "/bookings")
    public ResponseEntity<List<Booking>> getAllBookings(
            @RequestParam(name = "date", required = false) String date
    ) {
        if (date != null) {
            List<Booking> foundBookings = bookingRepository.findByDate(date);
            return new ResponseEntity<>(foundBookings, HttpStatus.OK);
        }

        List<Booking> foundBookings = bookingRepository.findAll();
        return new ResponseEntity<>(foundBookings, HttpStatus.OK);
    }

    @GetMapping(value = "/bookings/{id}")
    public ResponseEntity getBooking(@PathVariable Long id){
        Optional<Booking> booking = bookingRepository.findById(id);
        return new ResponseEntity<>(booking, HttpStatus.OK);
    }

    @PostMapping(value = "/bookings")
    public ResponseEntity<Booking> postBooking(@RequestBody Booking booking){
        bookingRepository.save(booking);
        return new ResponseEntity<Booking>(booking, HttpStatus.CREATED);
    }

    @PutMapping(value = "/bookings/{id}")
    public ResponseEntity updateBooking(@RequestBody Booking booking, @PathVariable Long id){
        if (booking.getId().longValue() != id){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        bookingRepository.save(booking);
        return new ResponseEntity<>(booking, HttpStatus.OK);
    }

    @DeleteMapping(value = "/bookings/{id}")
    public ResponseEntity deleteBooking(@PathVariable Long id){
        bookingRepository.deleteById(id);
        
    }

}

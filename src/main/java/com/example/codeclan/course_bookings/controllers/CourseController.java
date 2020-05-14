package com.example.codeclan.course_bookings.controllers;

import com.example.codeclan.course_bookings.models.Booking;
import com.example.codeclan.course_bookings.models.Course;
import com.example.codeclan.course_bookings.repositories.BookingRepository;
import com.example.codeclan.course_bookings.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    CourseRepository courseRepository;

    @GetMapping(value = "/courses")
    public ResponseEntity<List<Course>> getAllCourses(
            @RequestParam(name = "star-rating", required = false) Integer starRating
    ) {

        if (starRating != null) {
            List<Course> foundCourses = courseRepository.findByStarRating(starRating);
            return new ResponseEntity<>(foundCourses, HttpStatus.OK);
        }

        List<Course> foundCourses = courseRepository.findAll();
        return new ResponseEntity<>(foundCourses, HttpStatus.OK);
    }

}

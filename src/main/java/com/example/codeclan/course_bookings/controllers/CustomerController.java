package com.example.codeclan.course_bookings.controllers;

import com.example.codeclan.course_bookings.models.Customer;
import com.example.codeclan.course_bookings.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping(value = "/customers")
    public ResponseEntity<List<Customer>> getAllCustomers(
            @RequestParam(name = "course-id", required = false) Long courseId
    ) {

        if (courseId != null) {
            List<Customer> foundCustomer = customerRepository.findByBookingsCourseId(courseId);
            return new ResponseEntity<>(foundCustomer, HttpStatus.OK);
        }

        List<Customer> foundCustomer = customerRepository.findAll();
        return new ResponseEntity<>(foundCustomer, HttpStatus.OK);
    }

}

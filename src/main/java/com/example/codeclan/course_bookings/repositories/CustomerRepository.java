package com.example.codeclan.course_bookings.repositories;

import com.example.codeclan.course_bookings.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    List<Customer> findByBookingsCourseId(Long courseId);
}

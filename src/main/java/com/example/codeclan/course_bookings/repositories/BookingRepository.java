package com.example.codeclan.course_bookings.repositories;

import com.example.codeclan.course_bookings.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
}

package com.example.codeclan.course_bookings.components;

import com.example.codeclan.course_bookings.models.Booking;
import com.example.codeclan.course_bookings.models.Course;
import com.example.codeclan.course_bookings.models.Customer;
import com.example.codeclan.course_bookings.repositories.BookingRepository;
import com.example.codeclan.course_bookings.repositories.CourseRepository;
import com.example.codeclan.course_bookings.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    CustomerRepository customerRepository;

    public void run(ApplicationArguments args) {

        bookingRepository.deleteAll();
        courseRepository.deleteAll();
        customerRepository.deleteAll();

        Course course1 = new Course("Learn to be a PRO CODER","Edinburgh",5);
        courseRepository.save(course1);

        Course course2 = new Course("Learn to Climb in Yosemite", "Yellowstone", 4);
        courseRepository.save(course2);

        Customer customer1 = new Customer("Matthew","Newcastle",22);
        customerRepository.save(customer1);

        Customer customer2 = new Customer("Mairi","Edinburgh",22);
        customerRepository.save(customer2);

        Customer customer3 = new Customer("Some","Brighton",23);
        customerRepository.save(customer3);

        Customer customer4 = new Customer("Body","Glasgow",18);
        customerRepository.save(customer4);

        Booking booking1 = new Booking("04-03-95", course1, customer1);
        bookingRepository.save(booking1);

        Booking booking2 = new Booking("08-11-03", course1, customer2);
        bookingRepository.save(booking2);

        Booking booking3 = new Booking("05-01-18", course2, customer1);
        bookingRepository.save(booking3);

        Booking booking4 = new Booking("05-01-18", course2, customer2);
        bookingRepository.save(booking4);

        Booking booking5 = new Booking("05-01-19", course1, customer3);
        bookingRepository.save(booking5);

        Booking booking6 = new Booking("05-01-18", course1, customer4);
        bookingRepository.save(booking6);

    }

}

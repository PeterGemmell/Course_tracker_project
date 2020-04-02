package com.example.codeclan.coursebooking.components;

import com.example.codeclan.coursebooking.models.Booking;
import com.example.codeclan.coursebooking.models.Course;
import com.example.codeclan.coursebooking.models.Customer;
import com.example.codeclan.coursebooking.respositories.BookingRepository;
import com.example.codeclan.coursebooking.respositories.CourseRepository;
import com.example.codeclan.coursebooking.respositories.CustomerRepository;
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

    public DataLoader(){

    }

    public void run(ApplicationArguments args){

        Course python = new Course("Python", "Edinburgh", 3);
        courseRepository.save(python);
        Course java = new Course("Java", "Glasgow", 5);
        courseRepository.save(java);

        Customer handsomePeter = new Customer("Peter", "Glasgow", 28);
        customerRepository.save(handsomePeter);
        Customer coolPeter = new Customer("Peter", "Antartica", 31);
        customerRepository.save(coolPeter);

        Booking booking1 = new Booking("Julemba", python, handsomePeter);
        bookingRepository.save(booking1);
        Booking booking2 = new Booking("Julemba", python, coolPeter);
        bookingRepository.save(booking2);
        Booking booking3 = new Booking("Julemba", java, handsomePeter);
        bookingRepository.save(booking3);
        Booking booking4 = new Booking("Julemba", java, coolPeter);
        bookingRepository.save(booking4);

    }
}

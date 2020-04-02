package com.example.codeclan.coursebooking.respositories;

import com.example.codeclan.coursebooking.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    List<Customer> findByBookingsCourseName(String name);

    List<Customer> findByAddressAndBookingsCourseName(String address, String name);

//    List<Customer> findByAddressAndBookingsCourseNameAndAgeGreaterThanEquals(String address,String name, int age);
}


    // Get all customers in a given town for a given course
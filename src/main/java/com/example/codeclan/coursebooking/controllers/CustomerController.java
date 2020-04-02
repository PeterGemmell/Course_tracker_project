package com.example.codeclan.coursebooking.controllers;

import com.example.codeclan.coursebooking.respositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/customers")
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping
    public ResponseEntity findAllCustomers(

            @RequestParam(name = "address", required = false) String address,
            @RequestParam(name = "courseName", required = false) String courseName

    ){
        if(address != null && courseName != null){
            return new ResponseEntity(customerRepository.findByAddressAndBookingsCourseName(address, courseName), HttpStatus.OK);
        }

        if(courseName != null){
            return new ResponseEntity(customerRepository.findByBookingsCourseName(courseName), HttpStatus.OK);
        }
        return new ResponseEntity((customerRepository.findAll()), HttpStatus.OK);
    }
}

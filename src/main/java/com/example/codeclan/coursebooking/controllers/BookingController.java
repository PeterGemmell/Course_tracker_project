package com.example.codeclan.coursebooking.controllers;

import com.example.codeclan.coursebooking.respositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/bookings")
public class BookingController {

    @Autowired
    BookingRepository bookingRepository;

    @GetMapping()
    public ResponseEntity findAllBookings(
            @RequestParam(name = "date", required = false) String date
    ){
        if(date != null){
            return new ResponseEntity(bookingRepository.findByDate(date), HttpStatus.OK);
        }



        return new ResponseEntity(bookingRepository.findAll(), HttpStatus.OK);
    }

}

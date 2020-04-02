package com.example.codeclan.coursebooking.controllers;

import com.example.codeclan.coursebooking.respositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/courses")
public class CourseController {

    @Autowired
    CourseRepository courseRepository;

    @GetMapping
    public ResponseEntity findAllCourses(
            @RequestParam(name = "rating", required = false) Integer rating,
            @RequestParam(name = "customerName", required = false) String customerName,
            @RequestParam(name = "age", required = false) Integer age


    ){
        if(age != null) {
            return new ResponseEntity(courseRepository.findByBookingsCustomerAgeLessThan(age), HttpStatus.OK);

        }

        if(customerName != null){
        return new ResponseEntity(courseRepository.findByBookingsCustomerName(customerName), HttpStatus.OK);
    }
        if(rating != null){
            return new ResponseEntity(courseRepository.findCourseByRating(rating), HttpStatus.OK);
        }






        return new ResponseEntity(courseRepository.findAll(), HttpStatus.OK);
    }


}

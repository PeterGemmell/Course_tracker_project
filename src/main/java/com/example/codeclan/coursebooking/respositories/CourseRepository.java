package com.example.codeclan.coursebooking.respositories;

import com.example.codeclan.coursebooking.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {

    List<Course> findCourseByRating( int rating);

    List<Course> findByBookingsCustomerName(String name);

    List<Course> findByBookingsCustomerAgeLessThan( int age);


}

// Get all courses that have customers below 30
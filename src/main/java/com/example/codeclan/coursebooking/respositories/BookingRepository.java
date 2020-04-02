package com.example.codeclan.coursebooking.respositories;

import com.example.codeclan.coursebooking.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {

    List<Booking> findByDate( String date);

}


    //Get all bookings for a given date
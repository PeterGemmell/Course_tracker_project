package com.example.codeclan.coursebooking;

import com.example.codeclan.coursebooking.models.Booking;
import com.example.codeclan.coursebooking.models.Course;
import com.example.codeclan.coursebooking.models.Customer;
import com.example.codeclan.coursebooking.respositories.BookingRepository;
import com.example.codeclan.coursebooking.respositories.CourseRepository;
import com.example.codeclan.coursebooking.respositories.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
class CoursebookingApplicationTests {

	@Autowired
	BookingRepository bookingRepository;

	@Autowired
	CourseRepository courseRepository;

	@Autowired
	CustomerRepository customerRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void canFindAllCourses() {
		List<Course> found = courseRepository.findAll();
		assertEquals(2, found.size());
	}

	@Test
	public void canGetCoursesForStarRating() {
		List<Course> found = courseRepository.findCourseByRating(5);
		assertEquals(1, found.size());
		assertEquals("Java", found.get(0).getName());

	}

}

//	@Test
//	public void canCreateCustomer(){
//		Customer handsomePeter = new Customer("Peter", "Glasgow", 28);
//		customerRepository.save(handsomePeter);
//
//		Course python = new Course("Python", "Edinburgh", 3);
//		courseRepository.save(python);
//
//		Booking booking1 = new Booking("Julemba", python, handsomePeter);
//		bookingRepository.save(booking1);
//	}



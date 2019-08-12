package io.Saba.springBootStarter.courses;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

	@Autowired
	private CourseRepository courseRepository ;
	
	public List<Course> getAllCourses(String topicId){
		List<Course> courses = new ArrayList<>();
		this.courseRepository.findByTopicId(topicId)
		.forEach(courses::add);
		//this.courseRepository.findAll().forEach(courses::add);
		return courses;
	}
	
	public Course getCourse(String id) {
		Course c = this.courseRepository.findById(id).get();
		return c ;
	}

	public void addCourse(Course course) {
		this.courseRepository.save(course);
	}

	public void updateCourse( Course course) {

		this.courseRepository.save(course);
		
	}

	public void deleteCourse(String id) {
		this.courseRepository.deleteById(id);
		
	}
	
	
}
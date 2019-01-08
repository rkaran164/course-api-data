package io.javabrains.spingbootstarter.course;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * business service for topic API  
 *
 */

@Service
public class CourseService {
	
	//@Service
	//@Component 
	//@Controller
	//@Repository
	
	@Autowired
	private CourseRepository mCourseRepository;
	
	
	//use for getting the all topic list 
	public List<Course> getAllCourse(String topic_id){
		List<Course> courses = new ArrayList<>();
		mCourseRepository.findByTopicId(topic_id).forEach(courses::add);
		return courses;
	}
	
	
	public Optional<Course> getCourse(String id) {
		return mCourseRepository.findById(id);
	}
	
	
	//here we adding the new topic into the topic list (i.e. topics)
	public void addCourse(Course course) {
		mCourseRepository.save(course);
	}

	
	//here we updating the topic by topic id
	public void updateCourse(Course course) {
		mCourseRepository.save(course);
	}

	
	//here we deleting the topic by it's topic id
	public void deleteCourse(String id) {
		mCourseRepository.deleteById(id);
	}
	
}

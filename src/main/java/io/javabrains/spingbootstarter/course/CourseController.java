package io.javabrains.spingbootstarter.course;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.javabrains.spingbootstarter.topic.Topic;


//controller handle incoming  request

@RestController
//@RequestMapping("/home")
public class CourseController {
	
	//AutoWired use for the purpose of dependency injection 
	
	@Autowired
	private CourseService mCourseService;
	
	//GET API for getting all the topic list
	@RequestMapping("/topics/{id}/courses")
	public List<Course> getAllCourses(@PathVariable("id") String topic_id) {
		return mCourseService.getAllCourse(topic_id);
	}
		
	
	//GET API for getting the topic by id
	@RequestMapping("/topics/{topic_id}/courses/{course_id}")
	public Optional<Course> getCourse(@PathVariable("course_id") String course_id) {
		return mCourseService.getCourse(course_id);
	}
	

	//POST API for adding the Topic in the topic list
	@RequestMapping(method=RequestMethod.POST,value="/topics/{topic_id}/courses")
	public void addCourse(@RequestBody Course course,@PathVariable("topic_id") String topic_id) {
		course.setTopic(new Topic(topic_id,"",""));
		mCourseService.addCourse(course);
	}
	
	
	//PUT API for updating Topic by id
	@RequestMapping(method=RequestMethod.PUT,value="/topics/{topic_id}/courses/{course_id}")
	public void updateCourse(@RequestBody Course course, @PathVariable("topic_id") String topic_id) {
		course.setTopic(new Topic(topic_id,"",""));
		mCourseService.updateCourse(course);
	}
	
	//DELETE API for deleting the Topic by id
	@RequestMapping(method=RequestMethod.DELETE,value="/topics/{topic_id}/courses/{course_id}")
	public void deleteCourse(@PathVariable("course_id") String course_id) {
		mCourseService.deleteCourse(course_id);
	}
}


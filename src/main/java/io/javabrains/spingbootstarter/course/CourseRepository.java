package io.javabrains.spingbootstarter.course;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course,String>  {
	
	
	
	//correct syntax to define the custom method in crud reporistory
	//public List<Course> findByName(String name);
	
	//return all courses by description 
	//public List<Course> findByDescription(String description);
	
	public List<Course> findByTopicId(String topic_id);
	
}

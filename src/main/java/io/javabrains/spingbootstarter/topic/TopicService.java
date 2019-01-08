package io.javabrains.spingbootstarter.topic;

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
public class TopicService {
	
	//@Service
	//@Component 
	//@Controller
	//@Repository
	
	@Autowired
	private TopicRepository mTopicRepository;
	
	
	//use for getting the all topic list 
	public List<Topic> getAllTopic(){
		List<Topic> topics = new ArrayList<>();
		mTopicRepository.findAll().forEach(topics::add);
		return topics;
	}
	
	
	public Optional<Topic> getTopic(String id) {
		return mTopicRepository.findById(id);
	}
	
	
	//here we adding the new topic into the topic list (i.e. topics)
	public void addTopic(Topic topic) {
		mTopicRepository.save(topic);
	}

	
	//here we updating the topic by topic id
	public void updateTopic(Topic topic,String id) {
		mTopicRepository.save(topic);
	}

	
	//here we deleting the topic by it's topic id
	public void deleteTopic(String id) {
		mTopicRepository.deleteById(id);
	}
	
}

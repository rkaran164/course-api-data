package io.javabrains.spingbootstarter.topic;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


//controller handle incoming  request

@RestController
//@RequestMapping("/home")
public class TopicController {
	
	//AutoWired use for the purpose of dependency injection 
	
	@Autowired
	private TopicService mTopicService;
	
	//GET API for getting all the topic list
	@RequestMapping("/topics")
	public List<Topic> getAllTopics() {
		return mTopicService.getAllTopic();
	}
		
	
	//GET API for getting the topic by id
	@RequestMapping("/topics/{id}")
	public Optional<Topic> getTopic(@PathVariable("id") String id) {
		return mTopicService.getTopic(id);
	}
	

	//POST API for adding the Topic in the topic list
	@RequestMapping(method=RequestMethod.POST,value="/topics")
	public void addTopic(@RequestBody Topic topic) {
		mTopicService.addTopic(topic);
	}
	
	
	//PUT API for updating Topic by id
	@RequestMapping(method=RequestMethod.PUT,value="/topics/{id}")
	public void updateTopic(@RequestBody Topic topic, @PathVariable("id") String id) {
		mTopicService.updateTopic(topic,id);
	}
	
	//DELETE API for deleting the Topic by id
	@RequestMapping(method=RequestMethod.DELETE,value="/topics/{id}")
	public void deleteTopic(@PathVariable("id") String id) {
		mTopicService.deleteTopic(id);
	}
	
	//JDBC connection in spring
}


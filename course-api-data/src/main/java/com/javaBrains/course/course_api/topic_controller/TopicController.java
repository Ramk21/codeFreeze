package com.javaBrains.course.course_api.topic_controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {
	
	@Autowired
	TopicService topicService;

	@RequestMapping("/topics")
	List<Topic> getTopics() {
		return topicService.getAllTopics();
	}
	
	@RequestMapping("/topics/{loo}")
  public Topic getTopicById(@PathVariable("loo") String id) { 
		//pathVariable("loo") with param needs only when params names are different with requestmapping & method. 
		return topicService.getTopic(id);
	}
		@RequestMapping(method=RequestMethod.POST,value="/topics")
		public void addTopics(@RequestBody Topic topic) {
			topicService.addTopic(topic);
		}
	
		@RequestMapping(method=RequestMethod.PUT,value="/topics/{id}")
		public void updateTopic(@RequestBody Topic topic, @PathVariable String id ) {
			topicService.updateTopic(id,topic);
		}
		
		@RequestMapping(method=RequestMethod.DELETE,value="/topics/{id}")
		public void deleteTopic(@PathVariable String id ) {
			topicService.deleteTopic(id);
		}
}

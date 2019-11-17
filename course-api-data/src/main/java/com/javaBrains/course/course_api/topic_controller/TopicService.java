package com.javaBrains.course.course_api.topic_controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
	@Autowired
	TopicRepository topicRepository;
	
	private List<Topic> tList= new ArrayList<>(Arrays.asList(new Topic("java","core java","java is a ocean"),

			new Topic("SQL","mySQL","mySQL is a DB"),
			new Topic("SQL","MS SQL","SQL is a DB"),
			new Topic("spring","Spring boot","Springboot is a framework")
			));
	
	public List<Topic> getAllTopics(){
//		return tList;
		
		List<Topic> topicsList = new ArrayList<>();
		 topicRepository.findAll().forEach(topicsList::add);
		 return topicsList;		 
	}
	
	public Topic getTopic(String id) {
		/*return tList.stream().filter(t->t.getId().equals(id))//.findAny().get();
				.findFirst().get();*/
		return topicRepository.findById(id).get();
//		return null;
	}

	public void addTopic(Topic topic) {
//		tList.add(topic);
		topicRepository.save(topic);
		
	}

	public void updateTopic(String id, Topic topic) {
		/*for(int i=0;i<tList.size();i++) {
			if(tList.get(i).getId().equals(id)) {
				tList.set(i, topic);
				return;
			}
		}*/
		topicRepository.save(topic);
		
	}

	public void deleteTopic(String id) {
//		tList.removeIf(t -> t.getId().equals(id));
		topicRepository.deleteById(id);
		
	}
	
}

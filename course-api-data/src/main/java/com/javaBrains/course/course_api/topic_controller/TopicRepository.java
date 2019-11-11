package com.javaBrains.course.course_api.topic_controller;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface TopicRepository extends CrudRepository<Topic, String>{
		//Topic findOne(String id);
}

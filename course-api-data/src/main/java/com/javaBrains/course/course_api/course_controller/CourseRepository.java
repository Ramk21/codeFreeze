package com.javaBrains.course.course_api.course_controller;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, String>{
		List<Course> findAllByTopicId(String topicId);
}

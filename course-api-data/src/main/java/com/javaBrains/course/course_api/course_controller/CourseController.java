package com.javaBrains.course.course_api.course_controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.javaBrains.course.course_api.topic_controller.Topic;

@RestController
public class CourseController {
	
	@Autowired
	CourseService courseService;
	
/*	@Autowired
	Course course;*/
	
	

	@RequestMapping("/topics/{topicId}/course")
	List<Course> getAllCourses(@PathVariable String topicId) {
		return courseService.getAllCourses(topicId);
	}
	
	@RequestMapping("/topics/{topicId}/course/{id}")
  public Course getCourseById(@PathVariable String id) { 
		//pathVariable("loo") with param needs only when params names are different with requestmapping & method.
		//course.setTopic(new Topic(topicId,"",""));
		return courseService.getCourse(id);
	}
		@RequestMapping(method=RequestMethod.POST,value="/topics/{topicId}/course")
		public void addCourse(@RequestBody Course course,@PathVariable String topicId ) {
			course.setTopic(new Topic(topicId,"",""));
			courseService.addCourse(course);
		}
	
		@RequestMapping(method=RequestMethod.PUT,value="/topics/{topicId}/course/{id}")
		public void updateTopic(@RequestBody Course course,@PathVariable String topicId, @PathVariable String id ) {
			course.setTopic(new Topic(topicId,"",""));
			courseService.updateCourse(course);
		}
		
		@RequestMapping(method=RequestMethod.DELETE,value="/topics/{topicId}/course/{id}")
		public void deleteTopic(@PathVariable String id ) {
			courseService.deleteCourse(id);
		}
}

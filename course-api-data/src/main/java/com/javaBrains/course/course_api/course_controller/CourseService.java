package com.javaBrains.course.course_api.course_controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
	
	@Autowired
	CourseRepository courseRepository;
	
	/*private List<Course> tList= new ArrayList<>(Arrays.asList(new Course("java","core java","java is a ocean"),

			new Course("SQL","mySQL","mySQL is a DB"),
			new Course("SQL","MS SQL","SQL is a DB"),
			new Course("spring","Spring boot","Springboot is a framework")
			));
*/	
	public List<Course> getAllCourses(String topicId){
//		return tList;
		
		List<Course> coursesList = new ArrayList<>();
		 courseRepository.findAllByTopicId(topicId)
		 .forEach(coursesList::add);
		 return coursesList;		 
	}
	
	public Course getCourse(String id) {
		/*return tList.stream().filter(t->t.getId().equals(id))//.findAny().get();
				.findFirst().get();*/
		return courseRepository.findById(id).get();
//		return null;
	}

	public void addCourse(Course course) {
//		tList.add(course);
		courseRepository.save(course);
		
	}

	public void updateCourse(Course course) {
		/*for(int i=0;i<tList.size();i++) {
			if(tList.get(i).getId().equals(id)) {
				tList.set(i, course);
				return;
			}
		}*/
		courseRepository.save(course);
		
	}

	public void deleteCourse(String id) {
//		tList.removeIf(t -> t.getId().equals(id));
		courseRepository.deleteById(id);
		
	}

	
	
}

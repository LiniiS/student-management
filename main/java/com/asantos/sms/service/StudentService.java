package com.asantos.sms.service;

import java.util.List;

import com.asantos.sms.entity.Student;

public interface StudentService {

	//find all students
	List<Student> getAllStudents();
	
	Student saveStudent(Student student);
	
	Student getStudentById(Long id);
	
	Student updateStudent(Student student);
	
	void deleteStudent(Long id);
}

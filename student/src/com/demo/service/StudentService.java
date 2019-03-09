package com.demo.service;

import java.util.List;

import com.demo.pojo.Student;

public interface StudentService {
		
	List<Student> queryAllUser();
	
	int addStudent(Student student);
	
	int updateStudent(Student student);
	
	Student findStudentById(int id);
	
	int deleteStudent(int id);
}

	
package com.demo.service.impl;

import java.util.List;

import com.demo.dao.StudentDao;
import com.demo.dao.impl.StudentDaoImpl;
import com.demo.pojo.Student;
import com.demo.service.StudentService;

public class StudentServiceImpl implements StudentService{
	
	private StudentDao sd=new StudentDaoImpl();
	
	public List<Student> queryAllUser(){
		return sd.queryAllUser();
	}
	
	public int addStudent(Student student) {
		return sd.addStudent(student);
	};
	
	public int updateStudent(Student student) {
		return sd.updateStudent(student);
	};
	
	public int deleteStudent(int id) {
		return sd.deleteStudent(id);
	}

	@Override
	public Student findStudentById(int id) {
		
			
		return sd.findStudentById(id);
			
	};

}

	
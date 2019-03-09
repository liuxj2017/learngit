
package com.demo.dao;

import java.util.List;

import com.demo.pojo.Student;

public interface StudentDao {
	
	List<Student> queryAllUser();
	
	int addStudent(Student student);
	
	int updateStudent(Student student) ;
	
	Student findStudentById(int id);
	
	int deleteStudent(int id);

}

	
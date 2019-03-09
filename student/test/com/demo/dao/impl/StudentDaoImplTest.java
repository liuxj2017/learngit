
package com.demo.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.demo.dao.StudentDao;
import com.demo.pojo.Student;

public class StudentDaoImplTest {
	
	private Logger logger = Logger.getLogger(StudentDaoImplTest.class);
	private StudentDao sd=new StudentDaoImpl();
	private List<Student> list =null;

	@Before
	public void setUp() throws Exception {
	
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public final void testQueryAllUser() {
		list=sd.queryAllUser();
		list.toString();
		logger.info(list);
	}

	@Test
	public final void testAddStudent() {
		Student s=new Student("lxj",18,0);
		int result=sd.addStudent(s);
		logger.info(result);
	}

	@Test
	public final void testUpdateStudent() {
		Student s=new Student(1,"老马",18,0);
		int result=sd.updateStudent(s);
		logger.info(result);
	}

	@Test
	public final void testDeleteStudent() {
		int result=sd.deleteStudent(1);
		logger.info(result);
		
	}

}

	
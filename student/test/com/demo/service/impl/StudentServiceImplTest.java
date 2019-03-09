
package com.demo.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.demo.pojo.Student;
import com.demo.service.StudentService;

public class StudentServiceImplTest {

	private Logger logger = Logger.getLogger(StudentServiceImplTest.class);
	private StudentService sd= new StudentServiceImpl();
	
	@Test
	public final void testQueryAllUser() {
		List<Student> list=	sd.queryAllUser();
		logger.info(list);
	}

	@Test
	public final void testAddStudent() {
	
	}

	@Test
	public final void testUpdateStudent() {
		
	}

	@Test
	public final void testDeleteStudent() {
		
	}

}

	
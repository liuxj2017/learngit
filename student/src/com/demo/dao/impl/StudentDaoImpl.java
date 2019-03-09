package com.demo.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.demo.dao.StudentDao;
import com.demo.pojo.Student;
import com.demo.util.DBUtil;

public class StudentDaoImpl  implements StudentDao{
	
	public StudentDaoImpl() {
		super();
	}

	@Override
	public List<Student> queryAllUser() {
		ResultSet rs=null;
		String s="select * from student";
		rs=new DBUtil().queryInfo(s, null);
		List<Student> list=new ArrayList<Student>();
		
		try {
			while(rs.next()){
					Student stu=new Student();
					stu.setId(rs.getInt("id"));
					stu.setName(rs.getString("name"));
					stu.setSex(rs.getInt("sex"));
					stu.setAge(rs.getInt("age"));
					list.add(stu);
				
			}
		} catch (SQLException e) {
			
				
					e.printStackTrace();
				
		} 
				return list;
			
	}

	@Override
	public int addStudent(Student student) {
		String s="insert into student values(?,?,?,?)";
		int result=0;
		Object param[]={ student.getId(),student.getName(),
				student.getAge(),student.getSex()
		};
		result =new DBUtil().saveInfo(s, param);

		return result;
			
	}

	@Override
	public int updateStudent(Student student) {
		String s="update student set name=?, age=?, sex=? where id=?";
		int result=0;
		Object param[]={student.getName(),
				student.getAge(),student.getSex(),student.getId()
		};
		result =new DBUtil().updateInfo(s, param);
			
		return result;
	}

	@Override
	public int deleteStudent(int id) {
		
		String s="delete from student where id=?";
		int result=0;
		Object param[]={id};
		result =new DBUtil().deleteInfo(s, param);
			
		return result;
			
	}

	@Override
	public Student findStudentById(int id) {
		ResultSet rs=null;
		String s="select * from student where id=?";
		Object param[]={id};
		rs=new DBUtil().queryInfo(s, param);
		Student stu=null;
		try {
			while(rs.next()){
					stu=new Student();
					stu.setId(rs.getInt("id"));
					stu.setName(rs.getString("name"));
					stu.setSex(rs.getInt("sex"));
					stu.setAge(rs.getInt("age"));					
			}
		} catch (SQLException e) {
			
				
					e.printStackTrace();
				
		} 
				return stu;
	}

	
	
}

	
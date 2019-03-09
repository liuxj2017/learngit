package com.demo.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.pojo.Student;
import com.demo.service.StudentService;
import com.demo.service.impl.StudentServiceImpl;

/**
 * Servlet implementation class StudnetServlet
 */
@WebServlet( urlPatterns = { "/queryAllStudent","/studentDel",
		"/studentAdd","/studentUpdate","/findStudentById"})
public class StudentServlet extends HttpServlet {

	private StudentService ss=new StudentServiceImpl();
	private static final long serialVersionUID = 301785335721481739L;
	
	public StudentServlet() {
			super();
			
	}
				
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		String uri = req.getRequestURI();
		 if(uri.endsWith("/studentDel")){
			
			studentDel(req,resp);
		} else if(uri.endsWith("/findStudentById")){
			
			findStudentById(req,resp);
		}
				
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		String uri = req.getRequestURI();
	        if(uri.endsWith("/studentAdd")){
				
				studentAdd(req,resp);
			}else if(uri.endsWith("/studentUpdate")){
				
				studentUpdate(req,resp);
			}else if(uri.endsWith("/queryAllStudent")){
				
				queryAllStudent(req,resp);
			}
	}

	private void findStudentById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		String id=request.getParameter("id");
		int i=Integer.parseInt(id);
		Student stu=ss.findStudentById(i);
		request.setAttribute("student", stu);
		request.getRequestDispatcher("jsp/studentUpdate.jsp").forward(request, response);
			
	}

		
	private void queryAllStudent(HttpServletRequest request, HttpServletResponse response) throws IOException,
	ServletException {
		
		List<Student> list=ss.queryAllUser();
		request.setAttribute("list", list);
		request.getRequestDispatcher("index.jsp").forward(request, response);
			
	}

	
		
	private void studentDel(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
		String id=request.getParameter("id");
		int i=Integer.parseInt(id);
		int result=ss.deleteStudent(i);
		if(result==1) {
			request.setAttribute("messageDel", "删除成功");
		}else {
			request.setAttribute("messageDel", "删除成功");
		}
		request.getRequestDispatcher("index.jsp").forward(request, response); 	
	}

	
		
	private void studentAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		 String age=request.getParameter("age");
		 String sex=request.getParameter("sex");
		 if(name!=null&& !name.equals("")
				 &&age!=null&&!age.equals("")&&sex!=null) {
			 Student stu=new Student(name,Integer.parseInt(age),Integer.parseInt(sex));
			
			 int result=ss.addStudent(stu);
			 if(result==1) {
				 
				 request.setAttribute("messageAdd", "添加成功");
			 }else {
				 request.setAttribute("messageAdd", "添加失败");
			 }
		}else {
		
			 request.setAttribute("messageAdd", "添加失败");
		}
		
		 request.getRequestDispatcher("index.jsp").forward(request, response);
	}
	
	private void studentUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id=request.getParameter("id");
		 String name=request.getParameter("name");
		 String age=request.getParameter("age");
		 String sex=request.getParameter("sex");
		 if(id!= null&& !id.equals("") &&name!=null&& !name.equals("")
				 &&age!=null&&!age.equals("")&&sex!=null) {
			 Student stu=new Student(Integer.parseInt(id),name,Integer.parseInt(age),Integer.parseInt(sex));
			 int result=ss.updateStudent(stu);
			 if(result==1) {
				 request.setAttribute("messageUpdate", "修改成功");
			 }else {
				 request.setAttribute("messageUpdate", "修改失败");
			 }
		 }else {
			 request.setAttribute("messageUpdate", "修改失败");
		 }
		
		 request.getRequestDispatcher("index.jsp").forward(request, response);		
	
	}
}

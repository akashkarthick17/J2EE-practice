package io.zilker.rest.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import io.zilker.rest.bean.Student;
import io.zilker.rest.bean.StudentList;
import io.zilker.rest.delegate.RestDelegate;

public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Servlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");

		
		/*if(request.getParameter("fetch")!=null) {
			
			RestDelegate restDelegate = new RestDelegate();

			StudentList studentList = restDelegate.retrieveStudentList();

			request.setAttribute("studentList", studentList);

			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/display.jsp");
			requestDispatcher.forward(request, response);
			
		}
		else if(request.getParameter("add")!=null) {
			
			String name = request.getParameter("name");
			int age = Integer.parseInt(request.getParameter("age"));
			double CGPA = Double.parseDouble(request.getParameter("cgpa"));
			long id = System.currentTimeMillis();

			Student student = new Student();
			student.setStudentAge(age);
			student.setStudentCGPA(CGPA);
			student.setStudentName(name);
			student.setStudentId(id);
			
			
			RestDelegate restDelegate = new RestDelegate();

			 Student student1 = restDelegate.insertStudentDetail(student);
			
			 request.setAttribute("student", student1);
			 
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/display1.jsp");
			requestDispatcher.forward(request, response);
			
		}*/

		System.out.println("in servlet");
		

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);

	}

}

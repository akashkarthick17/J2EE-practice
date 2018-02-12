<%@page import="io.zilker.rest.bean.Student"%>
<%@page import="java.util.List"%>
<%@page import="io.zilker.rest.bean.StudentList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%
	
      StudentList studentList = (StudentList)	request.getAttribute("studentList");
	
	List<Student> students = studentList.getStudentsList();
	
	for(Student student : students) {
		
		%>
		
		<h4>Name: <%= student.getStudentName() %></h4>
		<h4>Id: <%= student.getStudentId() %></h4>
		<h4>Age: <%= student.getStudentAge() %></h4>
		<h4>CGPA: <%= student.getStudentCGPA() %></h4>
		
		
		------------------------------------------------------------------------------

		
		<%
	}
	
	
	
	
	%>

</body>
</html>
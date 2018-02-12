package io.zilker.rest.demo.RestAPI;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import io.zilker.rest.bean.Student;
import io.zilker.rest.bean.StudentList;
import io.zilker.rest.repository.StudentRepository;

@Path("/students")
public class MyResource {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public StudentList getStudentList() {

		StudentRepository studentRepository = new StudentRepository();
		return studentRepository.fetchStudentRecords();

	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Student insertStudent(Student student) {

		StudentRepository studentRepository = new StudentRepository();

		studentRepository.insertStudent(student);

		return student;

	}
}

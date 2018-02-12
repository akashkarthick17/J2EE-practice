package io.zilker.rest.repository;

import java.util.ArrayList;
import java.util.List;

import io.zilker.rest.bean.StudentList;
import io.zilker.rest.bean.Student;

public class StudentRepository {

	List<Student> studentList = new ArrayList<>();

	StudentList studentsList = new StudentList();

	public StudentRepository() {
		Student student1 = new Student(1, "akash", 21, 8.3);
		Student student2 = new Student(2, "karthick", 21, 8.2);
		Student student3 = new Student(3, "lokesh", 21, 9.6);
		Student student4 = new Student(4, "naveen", 21, 9.3);
		Student student5 = new Student(5, "nithya", 21, 9.9);

		studentList.add(student1);
		studentList.add(student2);
		studentList.add(student3);
		studentList.add(student4);
		studentList.add(student5);
	}

	public List<Student> getStudentRecords() {
		return studentList;
	}

	public StudentList fetchStudentRecords() {

		studentsList.setStudentsList(getStudentRecords());
		return studentsList;

	}
	
	public void insertStudent(Student student) {
		
		studentList.add(student);
	}

}

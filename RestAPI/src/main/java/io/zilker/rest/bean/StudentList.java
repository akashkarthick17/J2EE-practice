package io.zilker.rest.bean;

import java.util.List;

public class StudentList implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	List<Student> studentsList;

	public StudentList() {
		super();
	}

	public StudentList(List<Student> studentsList) {
		super();

		this.studentsList = studentsList;
	}

	public List<Student> getStudentsList() {
		return studentsList;
	}

	public void setStudentsList(List<Student> studentsList) {
		this.studentsList = studentsList;
	}

	public String toString() {
		
		return studentsList.get(0).getStudentName();
		
	}
	

}

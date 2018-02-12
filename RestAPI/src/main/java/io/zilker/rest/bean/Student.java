package io.zilker.rest.bean;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Student implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private long studentId;
	private String studentName;
	private int studentAge;
	private double studentCGPA;

	public Student() {
		super();
	}

	public Student(long studentId, String studentName, int studentAge, double studentCGPA) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentAge = studentAge;
		this.studentCGPA = studentCGPA;
	}

	public long getStudentId() {
		return studentId;
	}

	public void setStudentId(long studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public int getStudentAge() {
		return studentAge;
	}

	public void setStudentAge(int studentAge) {
		this.studentAge = studentAge;
	}

	public double getStudentCGPA() {
		return studentCGPA;
	}

	public void setStudentCGPA(double studentCGPA) {
		this.studentCGPA = studentCGPA;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}

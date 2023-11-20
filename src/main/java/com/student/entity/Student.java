package com.student.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "students")
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long StudentId;
	
	private String StudentName;
	
	private String StudentDept;
	
	private String StudentEmail;
	
	private String StudentNumber;

	public Long getStudentId() {
		return StudentId;
	}

	public void setStudentId(Long studentId) {
		StudentId = studentId;
	}

	public String getStudentName() {
		return StudentName;
	}

	public void setStudentName(String studentName) {
		StudentName = studentName;
	}

	public String getStudentDept() {
		return StudentDept;
	}

	public void setStudentDept(String studentDept) {
		StudentDept = studentDept;
	}

	public String getStudentEmail() {
		return StudentEmail;
	}

	public void setStudentEmail(String studentEmail) {
		StudentEmail = studentEmail;
	}

	public String getStudentNumber() {
		return StudentNumber;
	}

	public void setStudentNumber(String studentNumber) {
		StudentNumber = studentNumber;
	}

	@Override
	public String toString() {
		return "Student [StudentId=" + StudentId + ", StudentName=" + StudentName + ", StudentDept=" + StudentDept
				+ ", StudentEmail=" + StudentEmail + ", StudentNumber=" + StudentNumber + "]";
	}
	
	

}

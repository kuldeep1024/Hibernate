package com.mapping.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class Student {
	private int student_id;
	private String student_name;
	private Set<Phone> studentPhoneNumbers = new HashSet<Phone>(0);

	public Student(String student_name, Set<Phone> studentPhoneNumbers) {
		super();
		this.student_name = student_name;
		this.studentPhoneNumbers = studentPhoneNumbers;
	}

	public Student() {
		super();
	}

	@Id
	@GeneratedValue
	public int getStudent_id() {
		return student_id;
	}

	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}

	public String getStudent_name() {
		return student_name;
	}

	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="student_id",referencedColumnName="student_id")
	
/*	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(	name = "STUDENT_PHONE", 
				joinColumns = { @JoinColumn(name = "STUDENT_ID") }, 
				inverseJoinColumns = { @JoinColumn(name = "PHONE_ID") })*/
	public Set<Phone> getStudentPhoneNumbers() {
		return studentPhoneNumbers;
	}

	public void setStudentPhoneNumbers(Set<Phone> studentPhoneNumbers) {
		this.studentPhoneNumbers = studentPhoneNumbers;
	}

}

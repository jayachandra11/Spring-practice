package com.njc.practice.spring.boot.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.njc.practice.spring.boot.enums.Gender;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer studentId;
	
	public Student() {
		super();
	}

	private String name;
	
	public Student(Integer studentId, String name, Gender gender, ClassStudying classStudying) {
		super();
		this.studentId = studentId;
		this.name = name;
		this.gender = gender;
		this.classStudying = classStudying;
	}
	

	@Enumerated(EnumType.STRING)
	private Gender gender;
	
	@ManyToOne
	@JoinColumn(name = "class_id")
	private ClassStudying classStudying;

	@Column(name = "created_date")
	@CreatedDate
	private LocalDate createdDate;

	public LocalDate getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public ClassStudying getClassStudying() {
		return classStudying;
	}

	public void setClassStudying(ClassStudying classStudying) {
		this.classStudying = classStudying;
	}
	
	

}

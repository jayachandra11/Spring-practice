package com.njc.practice.spring.boot.dto;

import javax.validation.constraints.NotBlank;

import com.njc.practice.spring.boot.enums.Gender;
import com.njc.practice.spring.boot.model.ClassStudying;
import com.njc.practice.spring.boot.model.Student;

public class StudentDTO {
	public StudentDTO() {
		super();
	}
	private Integer studentId;
	@NotBlank(message = "name should not be empty")
	private String name;
	private Gender gender;
	public StudentDTO(Integer studentId, String name, Gender gender, ClassStudying classStudying) {
		super();
		this.studentId = studentId;
		this.name = name;
		this.gender = gender;
		this.classStudying = classStudying;
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
	private ClassStudying classStudying;
	
	public static StudentDTO getStudentDTOFromStudent(final Student student) {
		StudentDTO studentDTO = new StudentDTO(student.getStudentId(), student.getName(), student.getGender(), student.getClassStudying());
		return studentDTO;
	}
	public static Student getStudentFromStudentDTO(final StudentDTO studentDTO) {
		Student student  = new Student(studentDTO.getStudentId(), studentDTO.getName(), studentDTO.gender, studentDTO.getClassStudying());
		return student;
	}

}

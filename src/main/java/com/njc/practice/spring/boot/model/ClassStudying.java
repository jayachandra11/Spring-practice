package com.njc.practice.spring.boot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.njc.practice.spring.boot.enums.ClassType;

@Entity
public class ClassStudying {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long classId;

	private String section;

	private Integer standard;

	@Enumerated(EnumType.STRING)
	@Column(name = "class_type")
	private ClassType classType;

	public ClassStudying(Long classId, String section, Integer standard, ClassType classType) {
		super();
		this.classId = classId;
		this.section = section;
		this.standard = standard;
		this.classType = classType;
	}
	public ClassStudying() {
		
	}
	public ClassType getClassType() {
		return classType;
	}
	public void setClassType(ClassType classType) {
		this.classType = classType;
	}
	public Long getClassId() {
		return classId;
	}
	public void setClassId(Long classId) {
		this.classId = classId;
	}
	public String getSection() {
		return section;
	}
	public void setSection(String section) {
		this.section = section;
	}
	public Integer getStandard() {
		return standard;
	}
	public void setStandard(Integer standard) {
		this.standard = standard;
	}
	

}

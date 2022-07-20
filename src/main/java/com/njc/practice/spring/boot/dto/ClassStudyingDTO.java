package com.njc.practice.spring.boot.dto;

import com.njc.practice.spring.boot.enums.ClassType;
import com.njc.practice.spring.boot.model.ClassStudying;

public class ClassStudyingDTO {

	private Long classId;

	private String section;

	private Integer standard;
	
	private ClassType classType;

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

	public ClassType getClassType() {
		return classType;
	}

	public void setClassType(ClassType classType) {
		this.classType = classType;
	}

	public ClassStudyingDTO(Long classId, String section, Integer standard, ClassType classType) {
		super();
		this.classId = classId;
		this.section = section;
		this.standard = standard;
		this.classType = classType;
	}

	public static ClassStudyingDTO getClassStudyingDTOFromClassStudying(final ClassStudying classStudying) {
		ClassStudyingDTO classStudyingDTO = new ClassStudyingDTO(classStudying.getClassId(), 
				classStudying.getSection(), classStudying.getStandard(), classStudying.getClassType());
		return classStudyingDTO;
	}
	public static ClassStudying getClassStudyingFromClassStudyingDTO(final ClassStudyingDTO classStudyingDTO) {
		ClassStudying  classStudying = new ClassStudying(classStudyingDTO.getClassId(), 
					classStudyingDTO.getSection(), classStudyingDTO.getStandard(), classStudyingDTO.getClassType());
		return classStudying;
	}
}

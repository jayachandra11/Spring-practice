package com.njc.practice.spring.boot.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.njc.practice.spring.boot.dto.StudentDTO;
import com.njc.practice.spring.boot.exception.LowIdException;
import com.njc.practice.spring.boot.exception.StudentNotFoundException;
import com.njc.practice.spring.boot.model.Student;
import com.njc.practice.spring.boot.repository.StudentRepository;


@Service
@Transactional
public class StudentService {
	@Autowired
	ClassService classService;
	
	@Autowired
	private StudentRepository studentRepository;

	public StudentDTO getStudentById(final Integer id) throws StudentNotFoundException {
		Student student = studentRepository.findById(id)
				.orElseThrow(() -> new StudentNotFoundException("Student is not found for Student Id "+ id));
		return StudentDTO.getStudentDTOFromStudent(student);
	}
	public StudentDTO addStudent(StudentDTO std) throws LowIdException {
		Student student = StudentDTO.getStudentFromStudentDTO(std);
		Student studentSaved = studentRepository.save(student);
		return StudentDTO.getStudentDTOFromStudent(studentSaved);
	}
	public List<StudentDTO> getAllStudents() {
		List<StudentDTO> sl = new ArrayList<>();
		Sort sort = Sort.by("name");
		Pageable pageable = PageRequest.of(0, 2, sort);
		for(Student s: studentRepository.findAll(pageable)) {
			sl.add(StudentDTO.getStudentDTOFromStudent(s));
		}
		return sl;
	}
	public StudentDTO changeStudentName(final StudentDTO student) {
		Student std = studentRepository.findById(student.getStudentId()).get();
		std.setName(student.getName());
		studentRepository.save(std);
		return StudentDTO.getStudentDTOFromStudent(std);
	}
	public List<StudentDTO> getAllStudentsByName(final String name) {
		List<StudentDTO> sl = new ArrayList<>();
		List<Student> res = studentRepository.findStudentByNameAndOrderThem(name);

		for(Student s: res) {
			sl.add(StudentDTO.getStudentDTOFromStudent(s));
		}

		return sl;
	}
}

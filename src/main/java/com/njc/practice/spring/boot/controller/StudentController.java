package com.njc.practice.spring.boot.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.njc.practice.spring.boot.dto.StudentDTO;
import com.njc.practice.spring.boot.exception.LowIdException;
import com.njc.practice.spring.boot.exception.StudentNotFoundException;
import com.njc.practice.spring.boot.service.StudentService;


@RestController
@RequestMapping("/njc")
@Validated
public class StudentController {

	@Autowired
	private StudentService studentService;

	@Value("${spring.datasource.username}")
	private String userName;

//	@Value("${spring.user.name}")
//	private String externalUserName;


	@GetMapping("/students")
	public List<StudentDTO> getAllStudents() {
		return studentService.getAllStudents();
	}
	
	@GetMapping("/student/{id}")
	  public StudentDTO getStudentById(@PathVariable @Min(value = 1, message = "id must be greater than or equal to 1") Integer id) throws StudentNotFoundException {
	    return studentService.getStudentById(id);
	  }
	@GetMapping("/student/name/{name}")
	  public ResponseEntity<List<StudentDTO>> getStudentByName(@PathVariable String name) {
		return  ResponseEntity.ok(studentService.getAllStudentsByName(name));
		
	  }
	@PostMapping("/student")
	public ResponseEntity<StudentDTO> addStudent(  @RequestBody @Valid StudentDTO student) throws LowIdException {
		
		return ResponseEntity.status(HttpStatus.CREATED).body(studentService.addStudent(student));
		}
	@PostMapping("/student/save")
	public ResponseEntity<StudentDTO> saveStudent(  @RequestBody @Valid  StudentDTO student) throws LowIdException {
		
		return new ResponseEntity<>(studentService.addStudent(student), HttpStatus.CREATED);
		}
	
	@PutMapping("/student")
	public StudentDTO modifyStudent(@RequestBody @Valid StudentDTO student) {
		return studentService.changeStudentName(student);
	}
	@GetMapping("/student")
	  public ResponseEntity<List<StudentDTO>> getStudentByStudentName(@RequestParam(name = "name", required = true, defaultValue = "Arjun") 
	  												 String name) {
		List<StudentDTO> res = studentService.getAllStudentsByName(name);	
		return ResponseEntity.ok().body(res);
	  }
	@DeleteMapping("/student")
	public String deleteStudent(@RequestParam(name = "id") @Max(value = 123, message = "abcd") Long id, @RequestParam("name") @Pattern( regexp = "") String name) {
		return "Success";
	}
	
	@GetMapping("/student/prac")
	public String getPracStudent(@RequestParam("ids") List<Long> ids) {
		return "Success";
	}
	@GetMapping("/student/pra")
	public ResponseEntity<String> getPraStudent(@RequestParam Map<String, String> map) {
			return ResponseEntity.ok().build();
	}
	@GetMapping("/user")
	public String getUser() {
		return "Success";
	}

	@GetMapping("/admin")
	public String getAdmin() {
		return "Success";
	}

	@GetMapping("/username")
	public String getUserName() {
		return userName;
	}
}


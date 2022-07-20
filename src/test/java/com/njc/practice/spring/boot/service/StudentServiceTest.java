//package com.njc.practice.spring.boot.service;
//
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
////@RunWith(SpringRunner.class)
//@SpringBootTest
//public class StudentServiceTest {
//	@Mock
//	private ClassService classService;
//	@InjectMocks
//	private StudentService studentService;
//	
//
//	@Test
//	public void studentServiceTest() {
//		Mockito.when(classService.sendClassNumber()).thenReturn(11);
//		Assertions.assertEquals(studentService.getAllStudents().size(), 0);
//	}
//
//}

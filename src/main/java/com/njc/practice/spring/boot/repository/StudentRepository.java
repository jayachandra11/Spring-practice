package com.njc.practice.spring.boot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.njc.practice.spring.boot.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{
	
	@Query(value = "select s from Student s where s.name = :names")
	List<Student> findByStudentNames(@Param("names") String name);
	
	@Query(nativeQuery = true)
	List<Student> findStudentByNameAndOrderThem(@Param("name") String name);
}

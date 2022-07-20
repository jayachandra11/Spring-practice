package com.njc.practice.spring.boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.njc.practice.spring.boot.model.ClassStudying;

@Repository
public interface ClassStudyingRepository extends JpaRepository<ClassStudying, Integer> {

	

}

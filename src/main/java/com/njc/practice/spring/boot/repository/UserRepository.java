package com.njc.practice.spring.boot.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.njc.practice.spring.boot.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

	Optional<User> findByUserName(String userName);
}

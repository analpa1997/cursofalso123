package com.example.demo.user;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.course.Course;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByUserID(long id);
	User findByUsername(String name);
	User findByInternalName(String name);
	User findByUserMail(String userMail);
	List<User> findByIsStudent(boolean isStudend);
}
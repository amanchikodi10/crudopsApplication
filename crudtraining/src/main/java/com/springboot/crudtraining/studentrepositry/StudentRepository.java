package com.springboot.crudtraining.studentrepositry;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.crudtraining.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
	
	

}

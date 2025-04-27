package com.springboot.crudtraining.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.crudtraining.entity.Student;
import com.springboot.crudtraining.studentrepositry.StudentRepository;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
public class StudentController {
	
	@Autowired
	StudentRepository studrep;
	
	//getAllStudent
	@GetMapping("/getAllstudent")
	public List<Student> getAllstudents(){
		List<Student> respone=studrep.findAll();
		return respone;
	}
	
	//getstudentBasedonRollno
	@GetMapping("/getStudentByrollno/{rollno}")
	public Student getMethodName(@PathVariable int rollno) {
		Student stud= studrep.findById(rollno).get();
		return stud;
	}
	@PostMapping("/createStudent")
	@ResponseStatus(code=HttpStatus.CREATED)
	public String createUser(@RequestBody Student student) {
		String msg=null;
		Student stud=studrep.save(student);
		if(stud!=null) {
			msg="Student data Saved Succesfully";
		}
		else {
			msg="Student data not created";
		}
		return msg;
	}
	@PutMapping("/updateStudent/{id}")
	public Student updateStudent(@PathVariable int id, @RequestBody Student student) {
		Student stud=studrep.findById(id).get();
		stud.setName(student.getName());
		stud.setBranch(student.getBranch());
		stud.setPercentage(student.getPercentage());
		studrep.save(stud);
		
		return stud;
	}
	@DeleteMapping("/deleteStudent/{id}")
	public String delete(@PathVariable int id) {
		String msg=null;
		Student stud=studrep.findById(id).get();
		if(stud!=null) {
			studrep.delete(stud);
			msg="DELETED SUCCESSFULLY";
		}else {
		msg="Record not found";
		}
		return msg;
	}
	

}

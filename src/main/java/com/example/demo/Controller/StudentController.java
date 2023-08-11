package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Models.Student;
import com.example.demo.Services.StudentService;
import com.fasterxml.jackson.annotation.JacksonInject.Value;

import lombok.val;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@PostMapping("/add")
	public Mono<Student> AddStudent(@RequestBody Student s) {
		
		return studentService.addStudent(s);
	}
	@GetMapping( value = "/all",produces = "text/event-stream")
	public Flux<Student> getAll(){
		
		return studentService.getAllStudents();
	}
	
	@GetMapping(value = "/{id}",produces = "text/event-stream")
	public Mono<Student> getById(@PathVariable String id){
		
		return studentService.getById(id);
	}
	
	@PutMapping("/update")
	public Mono<Student> update(@RequestBody Student s){
		
		return studentService.update(s);
	}

	@DeleteMapping("/delete/{id}")
	public Mono<Void> deleteStudent(@PathVariable String id) {
		return studentService.delete(id);
	}

}




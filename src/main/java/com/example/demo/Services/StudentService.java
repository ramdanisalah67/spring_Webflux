package com.example.demo.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.Models.Student;
import com.example.demo.Repositories.StudentRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class StudentService {

	@Autowired
	private  StudentRepository studentRepository;
	
	public Mono<Student> addStudent(Student s) {
		
		return studentRepository.insert(s);
	}
	
	public Flux<Student> getAllStudents() {
		
		return studentRepository.findAll();
	}
	
	
	public Mono<Student> getById( String id)
	{
		return studentRepository.findById(id);
	}
	
	public Mono<Student> update(Student s){
		
		return studentRepository.save(s);
	}
	
	public Mono<Void> delete(String id) {
		
		return studentRepository.deleteById(id);
	}
	
	
}

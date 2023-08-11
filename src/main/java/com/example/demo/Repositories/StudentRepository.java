package com.example.demo.Repositories;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Models.Student;

@Repository
public interface StudentRepository extends ReactiveMongoRepository<Student, String>{

}

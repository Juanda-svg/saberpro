package com.saberpro.app.repositorios;


import org.springframework.data.mongodb.repository.MongoRepository;

import com.saberpro.app.entidades.Student;

import java.util.List;

public interface StudentRepository extends MongoRepository<Student, String> {
    List<Student> findAllByOrderByOverallScoreDesc();
    Student findByDocumentNumber(String documentNumber);
}
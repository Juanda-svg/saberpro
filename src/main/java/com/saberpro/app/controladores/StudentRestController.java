package com.saberpro.app.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saberpro.app.entidades.Student;
import com.saberpro.app.entidades.User;
import com.saberpro.app.repositorios.StudentRepository;
import com.saberpro.app.repositorios.UserRepository;

import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentRestController {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/unique-result")
    public Student getUniqueResult(Authentication authentication) {
        User user = userRepository.findByEmail(authentication.getName());
        return studentRepository.findByDocumentNumber(user.getDocumentNumber());
    }

    @GetMapping("/total-results")
    public Student getTotalResults(Authentication authentication) {
        User user = userRepository.findByEmail(authentication.getName());
        return studentRepository.findByDocumentNumber(user.getDocumentNumber());
    }

    @GetMapping("/ranking")
    public List<Student> getRanking() {
        return studentRepository.findAllByOrderByOverallScoreDesc();
    }
}
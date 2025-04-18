package com.saberpro.app.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.saberpro.app.entidades.Student;
import com.saberpro.app.entidades.User;
import com.saberpro.app.repositorios.StudentRepository;
import com.saberpro.app.repositorios.UserRepository;

import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/dashboard")
    public String dashboard() {
        return "student/dashboard";
    }

    @GetMapping("/unique-result")
    public String uniqueResult(Authentication authentication, Model model) {
        User user = userRepository.findByEmail(authentication.getName());
        Student student = studentRepository.findByDocumentNumber(user.getDocumentNumber());
        model.addAttribute("student", student);
        return "student/unique_result";
    }

    @GetMapping("/total-results")
    public String totalResults(Authentication authentication, Model model) {
        User user = userRepository.findByEmail(authentication.getName());
        Student student = studentRepository.findByDocumentNumber(user.getDocumentNumber());
        model.addAttribute("student", student);
        return "student/total_results";
    }

    @GetMapping("/ranking")
    public String ranking(Model model) {
        List<Student> students = studentRepository.findAllByOrderByOverallScoreDesc();
        model.addAttribute("students", students);
        return "student/ranking";
    }
}
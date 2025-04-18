package com.saberpro.app.controladores;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import com.saberpro.app.entidades.Role;
import com.saberpro.app.entidades.Student;
import com.saberpro.app.entidades.User;
import com.saberpro.app.repositorios.StudentRepository;
import com.saberpro.app.repositorios.UserRepository;

import java.util.List;

@RestController
@RequestMapping("/api/coordination")
public class CoordinationRestController {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return studentRepository.findAllByOrderByOverallScoreDesc();
    }

    @PostMapping("/students")
    public Student createStudent(@RequestBody Student student, @RequestParam String email, @RequestParam String password) {
        
        if (userRepository.findByEmail(email) != null) {
            throw new IllegalArgumentException("El correo ya está registrado");
        }

        
        studentRepository.save(student);

       
        User user = new User();
        user.setEmail(email);
        user.setPassword(password); 
        user.setRole(Role.STUDENT);
        user.setDocumentNumber(student.getDocumentNumber());
        userRepository.save(user);

        return student;
    }

    @GetMapping("/students/{id}")
    public Student getStudentReport(@PathVariable String id) {
        return studentRepository.findById(id).orElseThrow();
    }

    @PutMapping("/students/{id}")
    public Student updateStudent(@PathVariable String id, @RequestBody Student updatedStudent) {
        Student student = studentRepository.findById(id).orElseThrow();
        student.setDocumentType(updatedStudent.getDocumentType());
        student.setDocumentNumber(updatedStudent.getDocumentNumber());
        student.setFirstSurname(updatedStudent.getFirstSurname());
        student.setSecondSurname(updatedStudent.getSecondSurname());
        student.setFirstName(updatedStudent.getFirstName());
        student.setSecondName(updatedStudent.getSecondName());
        student.setEmail(updatedStudent.getEmail());
        student.setPhoneNumber(updatedStudent.getPhoneNumber());
        student.setRegistrationNumber(updatedStudent.getRegistrationNumber());
        student.setOverallScore(updatedStudent.getOverallScore());
        student.setScoreLevel(updatedStudent.getScoreLevel());
        student.setWrittenCommunicationScore(updatedStudent.getWrittenCommunicationScore());
        student.setWrittenCommunicationLevel(updatedStudent.getWrittenCommunicationLevel());
        student.setQuantitativeReasoningScore(updatedStudent.getQuantitativeReasoningScore());
        student.setQuantitativeReasoningLevel(updatedStudent.getQuantitativeReasoningLevel());
        student.setCriticalReadingScore(updatedStudent.getCriticalReadingScore());
        student.setCriticalReadingLevel(updatedStudent.getCriticalReadingLevel());
        student.setCitizenshipCompetenciesScore(updatedStudent.getCitizenshipCompetenciesScore());
        student.setCitizenshipCompetenciesLevel(updatedStudent.getCitizenshipCompetenciesLevel());
        student.setEnglishScore(updatedStudent.getEnglishScore());
        student.setEnglishLevel(updatedStudent.getEnglishLevel());
        student.setEngineeringProjectFormulationScore(updatedStudent.getEngineeringProjectFormulationScore());
        student.setEngineeringProjectFormulationLevel(updatedStudent.getEngineeringProjectFormulationLevel());
        student.setScientificThinkingMathStatsScore(updatedStudent.getScientificThinkingMathStatsScore());
        student.setScientificThinkingMathStatsLevel(updatedStudent.getScientificThinkingMathStatsLevel());
        student.setSoftwareDesignScore(updatedStudent.getSoftwareDesignScore());
        student.setSoftwareDesignLevel(updatedStudent.getSoftwareDesignLevel());
        student.setEnglishLevelCategory(updatedStudent.getEnglishLevelCategory());
        return studentRepository.save(student);
    }

    @DeleteMapping("/students/{id}")
    public void deleteStudent(@PathVariable String id) {
        studentRepository.deleteById(id);
    }
}
package com.saberpro.app.controladores;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.saberpro.app.entidades.Role;
import com.saberpro.app.entidades.Student;
import com.saberpro.app.entidades.User;
import com.saberpro.app.repositorios.StudentRepository;
import com.saberpro.app.repositorios.UserRepository;

import java.util.List;

@Controller
@RequestMapping("/coordination")
public class CoordinationController {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/dashboard")
    public String dashboard() {
        return "coordination/dashboard";
    }

    @GetMapping("/students")
    public String listStudents(Model model) {
        List<Student> students = studentRepository.findAllByOrderByOverallScoreDesc();
        model.addAttribute("students", students);
        return "coordination/student_list";
    }

    @GetMapping("/students/new")
    public String showStudentForm(Model model) {
        model.addAttribute("student", new Student());
        return "coordination/student_form";
    }

    @PostMapping("/students")
    public String saveStudent(Student student, @RequestParam("password") String password, Model model) {
       
        System.out.println("Estudiante recibido: " + student);
        System.out.println("Contraseña recibida: " + password);

        //
        if (userRepository.findByEmail(student.getEmail()) != null) {
            model.addAttribute("error", "El correo ya está registrado");
            model.addAttribute("student", student);
            return "coordination/student_form";
        }

       
        if (password == null || password.trim().isEmpty()) {
            model.addAttribute("error", "La contraseña es requerida");
            model.addAttribute("student", student);
            return "coordination/student_form";
        }

       
        studentRepository.save(student);

        
        User user = new User();
        user.setEmail(student.getEmail());
        user.setDocumentNumber(student.getDocumentNumber());
        user.setRole(Role.STUDENT);
        user.setPassword(password); 
        userRepository.save(user);

        return "redirect:/coordination/students";
    }

    @GetMapping("/students/edit/{id}")
    public String showEditStudentForm(@PathVariable String id, Model model) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Estudiante no encontrado"));
        User user = userRepository.findByEmail(student.getEmail());
        model.addAttribute("student", student);
        model.addAttribute("user", user);
        return "coordination/student_edit_form";
    }

    @PostMapping("/students/update/{id}")
    public String updateStudent(@PathVariable String id, Student updatedStudent, @RequestParam("password") String password, Model model) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Estudiante no encontrado"));
        User user = userRepository.findByEmail(student.getEmail());

        
        if (!student.getEmail().equals(updatedStudent.getEmail()) && userRepository.findByEmail(updatedStudent.getEmail()) != null) {
            model.addAttribute("error", "El correo ya está registrado");
            model.addAttribute("student", updatedStudent);
            model.addAttribute("user", user);
            return "coordination/student_edit_form";
        }

        
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

        
        user.setEmail(updatedStudent.getEmail());
        user.setDocumentNumber(updatedStudent.getDocumentNumber());
        if (password != null && !password.trim().isEmpty()) {
            user.setPassword(password);
        }

       
        studentRepository.save(student);
        userRepository.save(user);

        return "redirect:/coordination/students";
    }

    @GetMapping("/students/delete/{id}")
    public String deleteStudent(@PathVariable String id) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Estudiante no encontrado"));
        User user = userRepository.findByEmail(student.getEmail());
        if (user != null) {
            userRepository.delete(user); 
        }
        studentRepository.delete(student); 
        return "redirect:/coordination/students";
    }

    @GetMapping("/students/report/{id}")
    public String showStudentReport(@PathVariable String id, Model model) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Estudiante no encontrado"));
        model.addAttribute("student", student);
        return "coordination/student_report";
    }
}
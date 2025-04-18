package com.saberpro.app.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import org.springframework.stereotype.Component;

import com.saberpro.app.entidades.Role;
import com.saberpro.app.entidades.User;
import com.saberpro.app.repositorios.UserRepository;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        if (userRepository.findByEmail("coordinator@university.com") == null) {
            User coordinator = new User();
            coordinator.setEmail("coordinator@university.com");
            coordinator.setPassword("admin123"); 
            coordinator.setRole(Role.COORDINATOR);
            userRepository.save(coordinator);
        }
    }
}
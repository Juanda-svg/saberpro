package com.saberpro.app.repositorios;


import org.springframework.data.mongodb.repository.MongoRepository;

import com.saberpro.app.entidades.User;

public interface UserRepository extends MongoRepository<User, String> {
    User findByEmail(String email);
    User findByDocumentNumber(String documentNumber);
}
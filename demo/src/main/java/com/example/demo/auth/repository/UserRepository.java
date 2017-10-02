package com.example.demo.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.auth.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}

//https://www.codebyamir.com/blog/user-account-registration-with-spring-boot
//http://www.baeldung.com/registration-verify-user-by-email
//https://hellokoding.com/registration-and-login-example-with-spring-security-spring-boot-spring-data-jpa-hsql-jsp/
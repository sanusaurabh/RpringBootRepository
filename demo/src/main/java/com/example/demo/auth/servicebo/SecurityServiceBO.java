package com.example.demo.auth.servicebo;

public interface SecurityServiceBO {
    String findLoggedInUsername();

    void autologin(String username, String password);
}
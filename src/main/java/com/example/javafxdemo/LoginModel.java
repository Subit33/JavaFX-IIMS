package com.example.javafxdemo;

public class LoginModel {
    static final String EMAIL = "subit@iimscollege.edu.np";
    static final String PASSWORD = "Subit@123";
    public static boolean loginAuthentication(String email, String password){
        return email.equals(EMAIL) && password.equals(PASSWORD);
    }
}

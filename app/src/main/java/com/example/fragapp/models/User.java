package com.example.fragapp.models;

public class User {
    private String email;

    private String pas;

    public User()
    {

    }
    public User(String email, String pas) {
        this.email = email;
        this.pas = pas;
    }

    public String getEmail() {
        return email;
    }

    public String getPas() {
        return pas;
    }
}

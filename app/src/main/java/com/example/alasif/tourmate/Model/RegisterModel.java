package com.example.alasif.tourmate.Model;

public class RegisterModel {
    private int id;
    private String email, password, userName;

    public RegisterModel(int id, String email, String password, String userName) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.userName = userName;
    }

    public RegisterModel(String email, String password, String userName) {
        this.email = email;
        this.password = password;
        this.userName = userName;
    }

    public RegisterModel() {
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getUserName() {
        return userName;
    }
}


package com.linelect.model;

public class User extends NamedEntity {
    private String email;

    public User() {
    }

    protected User(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

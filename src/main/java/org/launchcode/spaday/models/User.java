package org.launchcode.spaday.models;

import java.util.Date;

public class User {

    private int id;
    private static int nextId = 1;

    private String username;
    private String email;
    private String password;
    private Date createdOn;


    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.createdOn = new Date();
        this.id = nextId;
        nextId++;
    }
    //overrides

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                '}';
    }


    //getters and setters


    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }
}

package org.launchcode.spaday.models;

import javax.validation.constraints.*;
import java.sql.SQLOutput;

public class User {

    @NotBlank
    @Size(min = 5, max = 15)
    private String username;

    @Email
    private String email;

    @Size(min = 6, message = "Must have at least 6 characters" )
    @NotBlank(message="Password Required")
    private String password;

    @NotNull(message="Passwords do not match")
    private String verifyPassword;

    public User() {

    }

    public User(String username, String email, String password, String verifyPassword) {
        this();
        this.username = username;
        this.email = email;
        this.password = password;
        this.verifyPassword = verifyPassword;
    }

    private void checkPassword() {
        setVerifyPassword("123456");
        if(password != verifyPassword && password != null && verifyPassword != null) {
            System.out.println(password + verifyPassword);
            System.out.println(getPassword().equals(getVerifyPassword()));
            System.out.println(password != null);
            verifyPassword = null;

        }

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
        checkPassword();
    }

    public String getVerifyPassword() {
        return verifyPassword;
    }

    public void setVerifyPassword(String verifyPassword) {
        this.verifyPassword = verifyPassword;
        checkPassword();
    }
}

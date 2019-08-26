package com.blog.dto;

public class UserDTO {
    private String username;
    private String password;

    public String getUsername() {
        return this.username;
    }

    public void setUsername(final String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserDTO [username=" + this.username + ", password=" + this.password + "]";
    }

}

package com.codeup.adlister.dao;

public class Config {
    private String url = "jdbc:mysql://localhost/adlister_db";
    private String username = "adlister_user";
    private String password = "password";


    public String getUrl() {
        return url;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }



}

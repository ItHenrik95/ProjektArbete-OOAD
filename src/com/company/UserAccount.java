package com.company;

public class UserAccount {

    private String address;
    private String contactEmail;
    private Long contactPhone;
    private Boolean verifiedEmail;
    private Byte rating;
    private String password;
    private String username;
    private String workfield;
    private String status;

    public UserAccount(String username, String status) {
        this.status = status;
        this.username = username;
    }


    public String getStatus() {
        return status;
    }

    public String getUsername() {
        return username;
    }
    }

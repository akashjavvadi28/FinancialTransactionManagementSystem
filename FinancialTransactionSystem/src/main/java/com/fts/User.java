package com.fts;

public class User {
    private int userId;
    private String userName;
    private String userEmail;
    private double balance;  // Add an additional field for the 4th argument

    // Updated constructor to accept 4 parameters
    public User(int userId, String userName, String userEmail, double balance) {
        this.userId = userId;
        this.userName = userName;
        this.userEmail = userEmail;
        this.balance = balance;  // Assign the new field
    }

    // Getters and setters for the new field
    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    // Other getters and setters
    public int getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserEmail() {
        return userEmail;
    }
}


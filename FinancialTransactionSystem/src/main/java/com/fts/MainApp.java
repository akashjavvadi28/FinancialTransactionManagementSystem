package com.fts;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        UserService userService = new UserService();
        TransactionService transactionService = new TransactionService();

        System.out.println("1. Register");
        System.out.println("2. Login");
        int choice = sc.nextInt();

        if (choice == 1) {
            System.out.print("Enter username: ");
            String username = sc.next();
            System.out.print("Enter password: ");
            String password = sc.next();
            userService.registerUser(username, password);
            System.out.println("User Registered Successfully!");
        } else if (choice == 2) {
            System.out.print("Enter username: ");
            String username = sc.next();
            System.out.print("Enter password: ");
            String password = sc.next();
            User user = userService.loginUser(username, password);
            if (user != null) {
                System.out.println("Login Successful!");
                System.out.println("Your balance: " + userService.getUserBalance(user.getUserId()));

                System.out.println("1. Deposit");
                System.out.println("2. Withdraw");
                int transChoice = sc.nextInt();

                System.out.print("Enter amount: ");
                double amount = sc.nextDouble();
                String transType = transChoice == 1 ? "DEPOSIT" : "WITHDRAWAL";
                transactionService.performTransaction(user.getUserId(), amount, transType);
                System.out.println(transType + " Successful!");
            } else {
                System.out.println("Invalid credentials.");
            }
        }
    }
}


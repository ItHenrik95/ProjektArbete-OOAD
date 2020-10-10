package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class UserLogin {

    public static ArrayList<UserAccount> userlist = new ArrayList<>();

    //Menu for login or registering
    public static void userLogin() {
        System.out.println("Welcome to this app. Do you wanna login or register an account");
        Scanner input = new Scanner(System.in);
        String choice = input.next();

            if (choice.equals("login".toLowerCase())) {
                 login();
            } else if (choice.equals("register".toLowerCase())) {
                register();
                login();
            } else {
                System.out.println("Please enter either login or register");
            }

        }

    //Login to the system, currently checks an ArrayList but is supposed to check with a database.
    public static void login(){
        System.out.println("Hello! Please enter you username to login");
        Scanner input = new Scanner(System.in);
        String enteredUsername = input.nextLine();

        for (UserAccount account : userlist) {
            if (account.getUsername().equals(enteredUsername)){
                System.out.println("Welcome " + account.getUsername());
                System.out.println(account);
                AdFlow.showFlow(account);
            }
        }
        System.out.println("Can not find your name");

    }


    //Register a new user
    public static void register(){

        System.out.println("Are you an employer or a worker");
        Scanner input = new Scanner(System.in);
        String accountStatus = input.nextLine();


        if(accountStatus.equalsIgnoreCase("employer"))  {
            System.out.println("Enter your username to create an account");
            Scanner i = new Scanner(System.in);
            String enteredUsername = i.nextLine();

            UserCompany newUser = new UserCompany(enteredUsername,"employer");
            userlist.add(newUser);

        } else if (accountStatus.equalsIgnoreCase("worker")) {
            System.out.println("Enter your username to create an account");
            Scanner i = new Scanner(System.in);
            String enteredUsername = i.nextLine();
            UserWorker newUser = new UserWorker(enteredUsername,"worker");
            userlist.add(newUser);

        } else {
            System.out.println("Your selection did not match any of the alternatives.");
        }
    }
}

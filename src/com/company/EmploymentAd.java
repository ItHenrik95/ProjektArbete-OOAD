package com.company;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class EmploymentAd {

    private Date dateStart;
    private Date dateEnd;
    private Double hourlyPay;
    private Double totalPay;
    private String description;
    private String employer;

    private ArrayList<UserAccount> appliedWorkers = new ArrayList<>();

    private ArrayList<UserAccount> hiredWorkers = new ArrayList<>();

    public ArrayList<UserAccount> getAppliedWorkers() {
        return appliedWorkers;
    }

    public EmploymentAd(){ }

    // A Stringbuilder to create a string to list all the Applied and/or hired workers
    public StringBuilder appliedWorkersToString() {
        StringBuilder allAppliedWorkers = new StringBuilder("");

        if(!appliedWorkers.isEmpty()) {
            allAppliedWorkers.append("Applied workers: ");
            for (UserAccount workers : appliedWorkers) {
                allAppliedWorkers.append(workers.getUsername() + ", ");
            }
            if(!hiredWorkers.isEmpty()) {
                allAppliedWorkers.append("\n" + "Hired workers: " );
                for (UserAccount hired : hiredWorkers) {
                    allAppliedWorkers.append(hired.getUsername() + ", ");
                }
            }
            return allAppliedWorkers;
        } else {
            allAppliedWorkers.append("No appliances yet");
            return allAppliedWorkers;
        }
    }


    public String getEmployer() {
        return employer;
    }

    public EmploymentAd(String description,Double totalPay, String employer){
        this.description = description;
        this.totalPay = totalPay;
        this.employer = employer;
    }

    // constructor made for testing purposes(Pre-applied)
    public EmploymentAd(String description,Double totalPay, String employer, UserAccount apply){
        this.description = description;
        this.totalPay = totalPay;
        this.employer = employer;
        this.appliedWorkers.add(apply);
    }


    // Method to create an ad
    public void createAd(UserAccount account){

        if (account.getStatus().equals("employer".toLowerCase())){
            System.out.println("Lets create and ad!");
            System.out.println("Describe your job");

            Scanner input = new Scanner(System.in);
            String userIn = input.nextLine();
            description = userIn;
            System.out.println("What is the total pay");
            input = new Scanner(System.in);
            userIn = input.nextLine();
            totalPay = Double.parseDouble(userIn);
            System.out.println("And who is the employer");
            input = new Scanner(System.in);
            userIn = input.nextLine();
            employer = userIn;


        }else
            System.out.println("You do not have the status to create an ad");

    }

    // Checks if an applyer is a worker and adds it to the appliance ArrayList
    public void addWorker(UserAccount account) {
        if (account.getStatus().equals("worker".toLowerCase())){
            appliedWorkers.add(account);

        }
    }

    //Hire worker from the appliance list
    public void hireWorker(UserAccount account){
        hiredWorkers.add(account);
    }

    //Overwrite toString() method
    public String toString() {
        return "Employer: " + employer + "\n" +
                "Description: " + description + "\n" +
                "hourly pay: " + hourlyPay + "\n" +
                "total Pay: " + totalPay + "\n" +
                "Start date: " + dateStart + "\n" +
                "End date: " + dateEnd + "\n" +
                appliedWorkersToString();
    }
}


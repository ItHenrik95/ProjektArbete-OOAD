package com.company;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class AdFlow {

    // Lists all ads
    public static ArrayList<EmploymentAd> adList = new ArrayList<>();

    // This method is the controller of the ad flow.
    public static void showFlow(UserAccount username) throws NullPointerException {

        while (true) {

            for (EmploymentAd ad : adList) {
                System.out.println(ad.toString());
                System.out.println(" ");
            }
            System.out.println("Do you want to 'create' an ad,'apply' or 'hire' for a job?");
            Scanner input = new Scanner(System.in);
            String enteredOption = input.nextLine();

            if (enteredOption.equals("create".toLowerCase())) {
                EmploymentAd newAd = new EmploymentAd();
                newAd.createAd(username);
                adList.add(newAd);

            } else if (enteredOption.equals("apply".toLowerCase())) {
                System.out.println("What ad do you want to apply to? please enter that Employer of that ad.");
                Scanner i = new Scanner(System.in);
                String outcome = i.nextLine();
                for (EmploymentAd l : adList) {
                    if (l.getEmployer().equalsIgnoreCase(outcome)) {
                        l.addWorker(username);
                        System.out.println("You have applyed to " + l.getEmployer());
                    }

                }
            } else if (enteredOption.equals("hire".toLowerCase())){

                    ArrayList<EmploymentAd> ownedAds = new ArrayList<>();

                    for(EmploymentAd l: adList) {

                        if(l.getEmployer().equals(username.getUsername())) {
                            System.out.println(l.toString());
                            ownedAds.add(l);
                        }

                    }
                    System.out.println("Who do you wanna hire?");
                    Scanner hireInput = new Scanner(System.in);
                    String outcome = hireInput.nextLine();

                    for(EmploymentAd j : ownedAds) {
                        for (UserAccount usr : j.getAppliedWorkers()) {
                            if (usr.getUsername().equals(outcome)) {
                                j.hireWorker(usr);
                            }

                        }
                    }
            } else if(enteredOption.equals("exit".toLowerCase())) {
                System.out.println("System shuting down, user login out");
                break;
            }
            else {
                System.out.println("Please enter 'create', 'apply', 'hire' or 'exit' to exit");
            }
        }
    }

    // Adds an ad to the ArrayList
    public static void addAd(EmploymentAd ad) {
        adList.add(ad);
    }
}

package com.company;

public class Main {

    public static void main(String[] args) {

        UserAccount worker = new UserWorker("Bengt","worker");
        UserAccount company = new UserCompany("quickfix","employer");
        EmploymentAd ad = new EmploymentAd("Hard working job that requires some IT knowledge", 1500.0, "quickfix", worker);
        EmploymentAd ad2 = new EmploymentAd("Soft job that will make you less money but wont take much from you", 500.0, "lookup");
        EmploymentAd ad3 = new EmploymentAd("Do you wanna take out some trash and make money from it? This is the work for you!", 600.0, "getright");

        AdFlow.addAd(ad);
        AdFlow.addAd(ad2);
        AdFlow.addAd(ad3);
        UserLogin.userlist.add(company);
        UserLogin.userlist.add(worker);
        UserLogin.userLogin();

    }
}

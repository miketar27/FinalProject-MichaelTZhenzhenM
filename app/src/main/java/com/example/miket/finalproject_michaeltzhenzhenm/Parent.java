package com.example.miket.finalproject_michaeltzhenzhenm;

/**
 * Created by miket on 4/16/2017.
 */

public class Parent extends Person {
    private String title;
    private String phoneNumber;

    public Parent(String title, String firstName, String lastName, String emailAddress, String phoneNumber) {
        super(firstName, lastName, emailAddress);
        this.title = title;
        this.phoneNumber = phoneNumber;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
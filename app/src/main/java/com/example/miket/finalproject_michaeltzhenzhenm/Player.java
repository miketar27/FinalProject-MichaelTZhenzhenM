package com.example.miket.finalproject_michaeltzhenzhenm;

/**
 * Created by miket on 4/16/2017.
 */

public class Player extends Person {
    private String birthMonth;
    private String birthDay;
    private String birthYear;
    private String jerseyNumber;
    private String gender;
    private String groupLevel;

    public Player(String firstName, String lastName, String emailAddress, String jerseyNumber,
                  String birthMonth, String birthDay, String birthYear, String gender, String groupLevel) {
        super(firstName, lastName, emailAddress);
        this.jerseyNumber = jerseyNumber;
        this.gender = gender;
        this.groupLevel = groupLevel;
        this.birthMonth = birthMonth;
        this.birthDay = birthDay;
        this.birthYear = birthYear;
    }


    public String getJerseyNumber() {
        return jerseyNumber;
    }

    public void setJerseyNumber(String jerseyNumber) {
        this.jerseyNumber = jerseyNumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGroupLevel() {
        return groupLevel;
    }

    public void setGroupLevel(String groupLevel) {
        this.groupLevel = groupLevel;
    }


    public String getBirthMonth() {
        return birthMonth;
    }

    public void setBirthMonth(String birthMonth) {
        this.birthMonth = birthMonth;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(String birthYear) {
        this.birthYear = birthYear;
    }
}

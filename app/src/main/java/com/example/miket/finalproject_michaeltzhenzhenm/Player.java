package com.example.miket.finalproject_michaeltzhenzhenm;

import java.io.Serializable;

/**
 * Created by miket on 4/16/2017.
 */

public class Player extends Person implements Serializable {
    private String birthMonth;
    private String birthDay;
    private String birthYear;
    private String jerseyNumber = "N/A";
    private String gender = "N/A";
    private String groupLevel;
    private String fileName;
    private String uniqueParent1ID;
    private String uniqueParent2ID;

    public Player() {

    }

    public Player(String firstName, String lastName, String emailAddress, String jerseyNumber,
                  String birthMonth, String birthDay, String birthYear, String gender, String groupLevel,
                  String fileName, String uniqueParent1ID, String uniqueParent2ID) {
        super(firstName, lastName, emailAddress);
        this.jerseyNumber = jerseyNumber;
        this.gender = gender;
        this.groupLevel = groupLevel;
        this.birthMonth = birthMonth;
        this.birthDay = birthDay;
        this.birthYear = birthYear;
        this.fileName = fileName;
        this.uniqueParent1ID = uniqueParent1ID;
        this.uniqueParent2ID = uniqueParent2ID;
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

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getUniqueParent1ID() {
        return uniqueParent1ID;
    }

    public void setUniqueParent1ID(String uniqueParent1ID) {
        this.uniqueParent1ID = uniqueParent1ID;
    }

    public String getUniqueParent2ID() {
        return uniqueParent2ID;
    }

    public void setUniqueParent2ID(String uniqueParent2ID) {
        this.uniqueParent2ID = uniqueParent2ID;
    }
}

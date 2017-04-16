package com.example.miket.finalproject_michaeltzhenzhenm;

import android.media.Image;

/**
 * Created by miket on 4/16/2017.
 */

public class Player extends Person {
    private int birthMonth;
    private int birthDay;
    private int birthYear;
    private int jerseyNumber;
    private String gender;
    private String groupLevel;
    private Image playerPicture;

    public Player(String firstName, String lastName, String emailAddress, int jerseyNumber,
                  int birthMonth, int birthDay, int birthYear, String gender, String groupLevel,
                  Image playerPicture) {
        super(firstName, lastName, emailAddress);
        this.jerseyNumber = jerseyNumber;
        this.gender = gender;
        this.groupLevel = groupLevel;
        this.birthMonth = birthMonth;
        this.birthDay = birthDay;
        this.birthYear = birthYear;
    }

    public int getJerseyNumber() {
        return jerseyNumber;
    }

    public void setJerseyNumber(int jerseyNumber) {
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

    public Image getPlayerPicture() {
        return playerPicture;
    }

    public void setPlayerPicture(Image playerPicture) {
        this.playerPicture = playerPicture;
    }
}

package com.stlang.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class NormalStudent extends Student {

    private int englishScore;
    private double entryTestScore;

    public NormalStudent() {}

    public NormalStudent(String fullName, Date doB, boolean sex, String phoneNumber, String universityName, String gradeLevel, int englishScore, double entryTestScore) {
        super(fullName, doB, sex, phoneNumber, universityName, gradeLevel);
        this.englishScore = englishScore;
        this.entryTestScore = entryTestScore;
    }

    public int getEnglishScore() {
        return englishScore;
    }

    public void setEnglishScore(int englishScore) {
        this.englishScore = englishScore;
    }

    public double getEntryTestScore() {
        return entryTestScore;
    }

    public void setEntryTestScore(double entryTestScore) {
        this.entryTestScore = entryTestScore;
    }

    @Override
    public void ShowMyInfo() {
        super.ShowMyInfo();
        System.out.println("English Score: " + getEnglishScore());
        System.out.println("Entry Test Score: " + getEntryTestScore());
    }
}

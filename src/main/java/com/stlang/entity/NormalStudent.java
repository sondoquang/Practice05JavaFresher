package com.stlang.entity;

import java.util.Date;

public class NormalStudent extends Student implements Comparable<NormalStudent> {

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

    @Override
    public int compareTo(NormalStudent other) {
        // So sánh TOEIC trước nè //
        int gpaComparison = other.getEnglishScore() - this.getEnglishScore();
        if ( gpaComparison > 0 ) {
            return 1;
        }else if ( gpaComparison < 0 ) {
            return -1;
        }
        // Nếu TOEIC bằng nhau thì so sánh theo tên đầy đủ (tăng dần)
        return this.getFullName().compareTo(other.getFullName());
    }
}

package com.stlang.entity;

import java.util.Date;

public class GoodStudent extends Student implements Comparable<GoodStudent> {

    private double gpa;
    private String bestRewardName;

    public GoodStudent() {
    }

    public GoodStudent(String fullName, Date doB, boolean sex, String phoneNumber, String universityName, String gradeLevel, double gpa, String bestRewardName) {
        super(fullName, doB, sex, phoneNumber, universityName, gradeLevel);
        this.gpa = gpa;
        this.bestRewardName = bestRewardName;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public String getBestRewardName() {
        return bestRewardName;
    }

    public void setBestRewardName(String bestRewardName) {
        this.bestRewardName = bestRewardName;
    }


    @Override
    public void ShowMyInfo() {
        super.ShowMyInfo();
        System.out.println("GPA: " + gpa);
        System.out.println("Best reward name: " + bestRewardName);
    }

    @Override
    public int compareTo(GoodStudent other) {
        // So sánh GPA trước nè //
        double gpaComparison = other.getGpa() - this.getGpa();
        if(gpaComparison > 0)
            return 1;
        else if(gpaComparison < 0)
            return -1;
        // Nếu GPA bằng nhau thì so sánh theo tên đầy đủ (tăng dần)
        return this.getFullName().compareTo(other.getFullName());
    }
}

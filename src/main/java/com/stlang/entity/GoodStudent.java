package com.stlang.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GoodStudent extends Student {

    private double gpa;
    private String bestRewardName;

    public GoodStudent() {
    }

    public GoodStudent(String fullName, Date doB, boolean sex, String phoneNumber, String universityName, GradeLevel gradeLevel, double gpa, String bestRewardName) {
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


    @Override // Thêm @Override để đánh dấu rằng đây là phương thức được kế thừa (nếu có lớp cha)
    public void ShowMyInfo() {
        super.ShowMyInfo();
        System.out.println("GPA: " + gpa);
        System.out.println("Best reward name: " + bestRewardName);
    }
}

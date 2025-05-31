package com.stlang.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Student {

    private String fullName;
    private Date doB;
    private Boolean sex;
    private String phoneNumber;
    private String universityName;
    private String gradeLevel;

    public Student() {
    }

    public Student(String fullName, Date doB, Boolean sex, String phoneNumber, String universityName, String gradeLevel) {
        this.fullName = fullName;
        this.doB = doB;
        this.sex = sex;
        this.phoneNumber = phoneNumber;
        this.universityName = universityName;
        this.gradeLevel = gradeLevel;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getDoB() {
        return doB;
    }

    public void setDoB(Date doB) {
        this.doB = doB;
    }

    public Boolean getSex() {
        return this.sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    public String getGradeLevel() {
        return gradeLevel;
    }

    public void setGradeLevel(String gradeLevel) {
        this.gradeLevel = gradeLevel;
    }

    public void ShowMyInfo() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("--- Thông tin sinh viên ---");
        System.out.println(" Họ và tên: " + this.getFullName());
        System.out.println(" Ngày sinh: " + (this.getDoB() != null ? dateFormat.format(this.getDoB()) : "Chưa có"));
        System.out.println(" Giới tính: " + (this.getSex() ? "Nam" : "Nữ"));
        System.out.println(" Số điện thoại: " + this.getPhoneNumber());
        System.out.println(" Trường đại học: " + this.getUniversityName());
        System.out.println(" Cấp độ: " + (this.getGradeLevel() != null ? this.getGradeLevel() : "Chưa xác định"));
    };
}

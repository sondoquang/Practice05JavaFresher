package com.stlang.controller;

import com.stlang.entity.GoodStudent;
import com.stlang.entity.NormalStudent;
import com.stlang.entity.Student;
import com.stlang.exception.PrintOtherException;
import com.stlang.utils.XReadData;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Request05 {

    public static void main(String[] args) throws PrintOtherException, IOException {
        List<GoodStudent> goodStudents =
                XReadData.readDataGoodStudent("C:\\tmp\\goodStudent.csv");
        List<NormalStudent> normalStudents =
                XReadData.readDataNormalStudent("C:\\tmp\\normalStudent.csv");

        List<Student> totalCandidates = new ArrayList<>();
        if ( goodStudents != null || !goodStudents.isEmpty()) {
            totalCandidates.addAll(goodStudents);
        }
        if ( normalStudents != null || !normalStudents.isEmpty()) {
            totalCandidates.addAll(normalStudents);
        }

        // Sắp xếp giảm dần theo tên //
        Collections.sort(totalCandidates, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o2.getFullName().compareTo(o1.getFullName());
            }
        });

        // Sắp xếp tăng dần theo số điện thoại //
        Collections.sort(totalCandidates, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getFullName().compareTo(o2.getFullName());
            }
        });
        System.out.println("Danh sách các ứng viên:");
        for(Student student : totalCandidates) {
            System.out.println("FullName: "+ student.getFullName());
            System.out.println("PhoneNumber: "+ student.getPhoneNumber());
        }

    }

}

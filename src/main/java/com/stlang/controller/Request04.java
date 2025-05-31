package com.stlang.controller;

import com.stlang.entity.GoodStudent;
import com.stlang.entity.NormalStudent;
import com.stlang.entity.Student;
import com.stlang.exception.PrintOtherException;
import com.stlang.utils.XReadData;

import java.io.IOException;
import java.util.*;

public class Request04 {
    public static void main(String[] args) throws PrintOtherException, IOException {
        Scanner sc = new Scanner(System.in);
        int numberOfCandidates = -1;

        do {
            System.out.print(" Nhập vào số lượng sinh viên cần tuyển dụng: ( tối thiểu là 11 và tối đa là 15 ):  ");
            try {
                numberOfCandidates = sc.nextInt();
            } catch (Exception e) {
                System.out.print("Sai định dạng !\n");
                sc.nextLine();
            }
        }while (numberOfCandidates <= 5 || numberOfCandidates > 15 );

        List<GoodStudent> goodStudents =
                XReadData.readDataGoodStudent("C:\\tmp\\goodStudent.csv");
        List<NormalStudent> normalStudents =
                XReadData.readDataNormalStudent("C:\\tmp\\normalStudent.csv");
        // Kết quả //
        List<Student> results = new ArrayList<>();

        if(goodStudents != null && !goodStudents.isEmpty()){
            Collections.sort(goodStudents);
            if(goodStudents.size() >= numberOfCandidates) {
                // Lấy ra số ứng viên khá giỏi: từ 0 - numberOfCandidates //
                for(int i = 0; i < numberOfCandidates; i++){
                    results.add(goodStudents.get(i));
                }
            }else if( normalStudents != null){
                results.addAll(goodStudents);
                for(int j = 0; j < numberOfCandidates - goodStudents.size(); j++){
                    results.add(normalStudents.get(j));
                }
            }
        } else if ( normalStudents != null || !normalStudents.isEmpty()){
            // Trường hợp chỉ có sinh viên trung bình không có giỏi //
            Collections.sort(normalStudents);
            int tempSelect = Math.min(normalStudents.size(), numberOfCandidates);
            for (int i = 0; i < tempSelect; i++) {
                results.add(normalStudents.get(i));
            }
        }

        for(Student student : results){
            System.out.println(student.getFullName() + " || GPA: " + ((NormalStudent)student).getEnglishScore());
        }

    }
}

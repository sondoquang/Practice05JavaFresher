package com.stlang.controller;

import com.stlang.entity.GoodStudent;
import com.stlang.entity.NormalStudent;
import com.stlang.exception.PrintOtherException;
import com.stlang.utils.XReadData;

import java.io.IOException;
import java.util.List;

public class Request01 {

    public static void main(String[] args) throws PrintOtherException, IOException {
        List<GoodStudent> goodStudents =
                XReadData.readDataGoodStudent("C:\\tmp\\goodStudent.csv");
        List<NormalStudent> normalStudents =
                XReadData.readDataNormalStudent("C:\\tmp\\normalStudent.csv");

        if(goodStudents != null){
            System.out.println("Show information of good students");
            for(GoodStudent goodStudent : goodStudents){
                goodStudent.ShowMyInfo();
            }
        }
        System.out.println("====================================================");
        if(normalStudents != null){
            System.out.println("Show information of normal students");
            for(NormalStudent normalStudent : normalStudents){
                normalStudent.ShowMyInfo();
            }
        }

    }

}

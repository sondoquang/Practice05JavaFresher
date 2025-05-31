package com.stlang.utils;

import com.stlang.entity.GoodStudent;
import com.stlang.entity.NormalStudent;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class XReadData {

    private static File getFile(String path){
        File file = new File(path);
        if(!file.exists()){
            return null;
        }
        return file;
    }

    public static ArrayList<GoodStudent> readDataGoodStudent(String path){
        ArrayList<GoodStudent> listStudent = new ArrayList<>();
        try {
            File file = getFile(path);
            if(file == null){
                System.out.println("File không tồn tại!");
                return null;
            }
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = reader.readLine();
            GoodStudent student = null;
            while (line != null) {
                String [] strings = line.split(";");
                student = new GoodStudent();
                student.setFullName(strings[0]);
                student.setDoB(XDate.toDate(strings[1], "dd/MM/YYYY"));
                student.setSex(strings[2].equals("Nam"));
                student.setPhoneNumber(strings[3]);
                student.setUniversityName(strings[4]);
                student.setGradeLevel(strings[5]);
                student.setGpa(Double.parseDouble(strings[6]));
                student.setBestRewardName(strings[7]);
                listStudent.add(student);
                line = reader.readLine();
            }
            reader.close();
            return listStudent;
        }catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static ArrayList<NormalStudent> readDataNormalStudent(String path){
        ArrayList<NormalStudent> listStudent = new ArrayList<>();
        try {
            File file = getFile(path);
            if(file == null){
                System.out.println("File không tồn tại!");
                return null;
            }
            BufferedReader reader = new BufferedReader(new FileReader(getFile(path)));
            String line = reader.readLine();
            NormalStudent student = null;
            while (line != null) {
                String [] strings = line.split(";");
                student = new NormalStudent();
                student.setFullName(strings[0]);
                student.setDoB(XDate.toDate(strings[1], "dd/MM/YYYY"));
                student.setSex(strings[2].equals("Nam"));
                student.setPhoneNumber(strings[3]);
                student.setUniversityName(strings[4]);
                student.setGradeLevel(strings[5]);
                student.setEnglishScore(Integer.parseInt(strings[6]));
                student.setEntryTestScore(Double.parseDouble(strings[7]));
                listStudent.add(student);
                line = reader.readLine();
            }
            reader.close();
            return listStudent;
        }catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        XReadData.readDataNormalStudent("C:\\tmp\\normalStudent.csv");
    }
    
}

package com.stlang.utils;

import com.stlang.entity.GoodStudent;
import com.stlang.entity.NormalStudent;
import com.stlang.exception.InvalidDOBException;
import com.stlang.exception.InvalidFullNameException;
import com.stlang.exception.InvalidPhoneNumberException;
import com.stlang.exception.PrintOtherException;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class XReadData {

    private static File getFile(String path){
        File file = new File(path);
        if(!file.exists()){
            return null;
        }
        return file;
    }

    public static ArrayList<GoodStudent> readDataGoodStudent(String path) throws PrintOtherException, IOException {
        ArrayList<GoodStudent> listStudent = new ArrayList<>();
        BufferedReader reader = null;
        try {
            File file = getFile(path);
            if(file == null){
                System.out.println("File không tồn tại!");
                return null;
            }
            reader = new BufferedReader(new FileReader(file));
            String line = reader.readLine();
            GoodStudent student = null;
            while (line != null) {
                String [] strings = line.split(";");
                student = new GoodStudent();
                student.setFullName(XValidate.isValidFullName(strings[0]) ? strings[0] : "");
                student.setDoB(!XValidate.isValidDOB(strings[1]) ? null : XDate.toDate(strings[1], "dd/MM/YYYY"));
                student.setSex(strings[2].equals("Nam"));
                student.setPhoneNumber(XValidate.isValidPhoneNumber(strings[3])? strings[3] : "");
                student.setUniversityName(strings[4]);
                student.setGradeLevel(strings[5]);
                student.setGpa(Double.parseDouble(strings[6]));
                student.setBestRewardName(strings[7]);
                listStudent.add(student);
                line = reader.readLine();
            }
            return listStudent;
        }catch (InvalidFullNameException | InvalidDOBException| InvalidPhoneNumberException e) {
            throw new RuntimeException(e);
        }catch(Exception e) {
            throw new PrintOtherException();
        } finally {
            if(reader != null){
                reader.close();
            }
        }
    }

    public static ArrayList<NormalStudent> readDataNormalStudent(String path) throws IOException, PrintOtherException {
        ArrayList<NormalStudent> listStudent = new ArrayList<>();
        BufferedReader reader = null;
        try {
            File file = getFile(path);
            if(file == null){
                System.out.println("File không tồn tại!");
                return null;
            }
            reader = new BufferedReader(new FileReader(file));
            String line = reader.readLine();
            NormalStudent student = null;
            while (line != null) {
                String [] strings = line.split(";");
                student = new NormalStudent();
                student.setFullName(XValidate.isValidFullName(strings[0]) ? strings[0] : "");
                student.setDoB(!XValidate.isValidDOB(strings[1]) ? null : XDate.toDate(strings[1], "dd/MM/YYYY"));
                student.setSex(strings[2].equals("Nam"));
                student.setPhoneNumber(XValidate.isValidPhoneNumber(strings[3])? strings[3] : "");
                student.setUniversityName(strings[4]);
                student.setGradeLevel(strings[5]);
                student.setEnglishScore(Integer.parseInt(strings[6]));
                student.setEntryTestScore(Double.parseDouble(strings[7]));
                listStudent.add(student);
                line = reader.readLine();
            }
            reader.close();
            return listStudent;
        } catch (InvalidFullNameException | InvalidDOBException| InvalidPhoneNumberException e){
            throw new RuntimeException(e);
        }catch(Exception e) {
            throw new PrintOtherException();
        }finally {
            if(reader != null){
                reader.close();
            }
        }
    }


    public static void main(String[] args) throws PrintOtherException, IOException {
        XReadData.readDataNormalStudent("C:\\tmp\\normalStudent.csv");
    }
    
}

package com.stlang.utils;

import com.stlang.exception.InvalidDOBException;
import com.stlang.exception.InvalidFullNameException;
import com.stlang.exception.InvalidPhoneNumberException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class XValidate {

    private static final String PHONE_NUMBER_REGEX = "^(090|098|091|031|035|038)\\d{7}$";

    public static boolean isValidFullName(String fullName) {
        if(fullName != null && fullName.length() >= 10 && fullName.length() <= 50)
            return true;
        else {
            throw new InvalidFullNameException("Invalid fullName");
        }
    }

    public static boolean isValidDOB(String dateString) {
        String dateFormat = "dd/MM/yyyy";
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        sdf.setLenient(false);
        try {
            Date date = sdf.parse(dateString);
            return true;
        } catch (ParseException e) {
            throw new InvalidDOBException(e.getMessage());
        }
    }

    public static boolean isValidPhoneNumber(String phoneNumber) throws InvalidPhoneNumberException {
        if (phoneNumber == null) {
            return false;
        }
        Pattern pattern = Pattern.compile(PHONE_NUMBER_REGEX);
        Matcher matcher = pattern.matcher(phoneNumber);
        if(matcher.matches()) {
            return true;
        }else {
            throw new InvalidPhoneNumberException("Invalid phone number");
        }
    }

    public static void main(String[] args) {

    }

}

package com.stlang.exception;

public class InvalidFullNameException extends RuntimeException{
    public InvalidFullNameException(String message){
        super(message);
    }
}

package com.stlang.exception;

import java.text.ParseException;

public class InvalidDOBException extends RuntimeException  {
    public InvalidDOBException(String message) {
        super(message);
    }
}

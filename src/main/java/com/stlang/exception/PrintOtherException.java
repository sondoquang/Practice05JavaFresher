package com.stlang.exception;

public class PrintOtherException extends Exception {
    public PrintOtherException() {
        System.out.println("Input files have unknow errors!");
    }
}

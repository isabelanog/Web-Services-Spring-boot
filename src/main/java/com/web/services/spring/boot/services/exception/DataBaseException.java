package com.web.services.spring.boot.services.exception;


public class DataBaseException extends RuntimeException {
    private static final long seriaLVersionUID = 1L;
    public DataBaseException(String msg) {
        super(msg);
    }
}

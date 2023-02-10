package com.web.services.spring.boot.services.exception;

public class NotFoundException extends RuntimeException {
    private static final long seriaLVersionUID = 1L;
    public NotFoundException(String msg) {
        super(msg);
    }
}

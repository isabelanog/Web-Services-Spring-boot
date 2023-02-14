package com.web.services.spring.boot.services.exception;

public class NotFoundException extends RuntimeException {
    private static final long seriaLVersionUID = 1L;
    public NotFoundException(Object id) {
        super("Resource not found. Id " + id);
    }
}

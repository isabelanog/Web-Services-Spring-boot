package com.web.services.spring.boot.resources.exception;

import java.io.Serializable;

public class StandardError implements Serializable {
    private static final long seriaLVersionUID = 1L;
    private Long timeStamp;
    private int status;
    private String error;
    private String path;
    public StandardError() {

    }
    public StandardError(Long timeStamp, int status, String error, String path) {
        this.timeStamp = timeStamp;
        this.status = status;
        this.error = error;
        this.path = path;
    }
    public Long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}

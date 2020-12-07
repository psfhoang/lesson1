package com.dto;

import java.sql.Timestamp;

public class DataResponse<T> {
    private int status;
    private Timestamp time;
    private String message;
    private Object data;

    public DataResponse(int status, String message, Object data) {
        this.status = status;
        this.message = message;
        this.data = data;
        this.time= new Timestamp(System.currentTimeMillis());
    }

    @Override
    public String toString() {
        return "DataResponse{" +
                "status=" + status +
                ", time=" + time +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}

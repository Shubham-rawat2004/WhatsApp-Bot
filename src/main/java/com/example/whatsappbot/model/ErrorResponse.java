package com.example.whatsappbot.model;

import java.time.LocalDateTime;

public class ErrorResponse {

    private boolean success;
    private String message;
    private Object data;
    private LocalDateTime timestamp;

    public ErrorResponse() {
    }

    public ErrorResponse(boolean success, String message, Object data, LocalDateTime timestamp) {
        this.success = success;
        this.message = message;
        this.data = data;
        this.timestamp = timestamp;
    }

    public static ErrorResponse badRequest(String message) {
        return new ErrorResponse(false, message, null, LocalDateTime.now());
    }

    public static ErrorResponse notFound(String message) {
        return new ErrorResponse(false, message, null, LocalDateTime.now());
    }

    public static ErrorResponse internalServerError(String message) {
        return new ErrorResponse(false, message, null, LocalDateTime.now());
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
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

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}

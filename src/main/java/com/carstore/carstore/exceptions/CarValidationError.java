package com.carstore.carstore.exceptions;

public class CarValidationError extends RuntimeException{
    private String errorMessage;

    public CarValidationError(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}

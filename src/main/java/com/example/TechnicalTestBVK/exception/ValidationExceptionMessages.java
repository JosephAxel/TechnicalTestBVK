package com.example.TechnicalTestBVK.exception;

public enum ValidationExceptionMessages {
    VALIDATION_NULL("%s must not be null"),
    VALIDATION_NUMBER_NEGATIVE("%s must not be negative"),
    VALIDATION_OVER_LENGTH("length of %s must not be greater than %d"),
    VALIDATION_LESS_LENGTH("length of %s must not be smaller than %d"),
    VALIDATION_VALUE_INVALID("Invalid value of %s"),
    VALIDATION_VALUE_LESS_THAN("%s must not less than %d"),
    VALIDATION_VALUE_MORE_THAN("%s must not greater than %d"),
    VALIDATION_NOT_FOUND("%s not found");


    private final String message;

    ValidationExceptionMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}


package com.rgrd.house_market.exceptions.response;

import lombok.Getter;

@Getter
public enum ErrorCodes {

    PROPERTY_NOT_FOUND(101, ErrorType.RESOURCE_NOT_FOUND, "Property not found", null),
    USER_NOT_FOUND(102, ErrorType.RESOURCE_NOT_FOUND, "User not found", null);
    
    private final int code;
    private final ErrorType type;
    private final String message;
    private Object developer_message;

    private ErrorCodes(int code, ErrorType type, String message, Object developer_message) {
        this.code = code;
        this.type = type;
        this.message = message;
        this.developer_message = developer_message;
    }
   
    public void setDeveloper_message(Object developer_message) {
        this.developer_message = developer_message;
    }
    
    public Error getError() {
        Error error = new Error();
        error.setCode(this.getCode());
        error.setMessage(this.getMessage());
        error.setType(this.getType());
        error.setDeveloper_message(this.getDeveloper_message());
        return error;
    }
}

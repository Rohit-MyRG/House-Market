package com.rgrd.house_market.exceptions.response;

import lombok.Data;

@Data
public class Error {
    private String message;
    private ErrorType type;
    private int code;
    private Object developer_message;
}

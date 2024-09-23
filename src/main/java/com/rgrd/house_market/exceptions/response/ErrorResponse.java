package com.rgrd.house_market.exceptions.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorResponse {
    
    private int status;
    private Error error;

    public ErrorResponse(int status, Error error) {
        this.status = status;
        this.error = error;
    }
}

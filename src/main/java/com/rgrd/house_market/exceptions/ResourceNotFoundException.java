package com.rgrd.house_market.exceptions;

import com.rgrd.house_market.exceptions.response.Error;
import com.rgrd.house_market.exceptions.response.ErrorCodes;

public class ResourceNotFoundException extends RuntimeException {
    
    private final ErrorCodes errorStatus;

    /**
     * @param errorStatus
     * @param reasonPhrase A reason phrase of error or a developer message.
     */
    public ResourceNotFoundException(ErrorCodes errorStatus, String reasonPhrase) {
        super(errorStatus.getMessage());
        errorStatus.setDeveloper_message(reasonPhrase);
        this.errorStatus = errorStatus;
    }

    public ResourceNotFoundException(ErrorCodes errorStatus) {
        super(errorStatus.getMessage());
        this.errorStatus = errorStatus;
    }

    public Error getErrorResponse() {
        return errorStatus.getError();
    }
}

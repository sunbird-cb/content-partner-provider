package com.org.entity.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContentPartnerCustomException extends RuntimeException {
    private String code;
    private String message;
    private int httpStatusCode;

    public ContentPartnerCustomException(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public ContentPartnerCustomException(String code, String message, int httpStatusCode) {
        this.code = code;
        this.message = message;
        this.httpStatusCode = httpStatusCode;
    }

    public ContentPartnerCustomException() {

    }
}


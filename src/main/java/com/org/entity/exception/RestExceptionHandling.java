package com.org.entity.exception;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class RestExceptionHandling {

    @ExceptionHandler(Exception.class)
    public ResponseEntity handleException(Exception ex) {
        log.debug("RestExceptionHandler::handleException::" + ex);
        int status = HttpStatus.INTERNAL_SERVER_ERROR.value();
        ErrorResponse errorResponse = null;
        if (ex instanceof ContentPartnerCustomException) {
            ContentPartnerCustomException entityCustomException = (ContentPartnerCustomException) ex;
            status = HttpStatus.BAD_REQUEST.value();
            if (entityCustomException.getHttpStatusCode() > 0) {
                try {
                    status = entityCustomException.getHttpStatusCode();
                } catch (IllegalArgumentException e) {
                    log.warn("Invalid HTTP status code provided in EntityCustomException: " + entityCustomException.getHttpStatusCode());
                }
            }
            errorResponse = ErrorResponse.builder()
                    .code(entityCustomException.getCode())
                    .message(entityCustomException.getMessage())
                    .httpStatusCode(entityCustomException.getHttpStatusCode() > 0
                            ? entityCustomException.getHttpStatusCode()
                            : status)
                    .build();
            if (StringUtils.isNotBlank(entityCustomException.getMessage())) {
                log.error(entityCustomException.getMessage());
            }

            return new ResponseEntity<>(errorResponse, HttpStatus.valueOf(status));
        }
        errorResponse = ErrorResponse.builder()
                .code(ex.getMessage()).build();
        return new ResponseEntity<>(errorResponse, HttpStatus.valueOf(status));
    }

}

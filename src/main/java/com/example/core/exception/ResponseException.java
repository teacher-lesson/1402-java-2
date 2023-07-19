package com.example.core.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class ResponseException extends RuntimeException {

    private HttpStatus status;

    public ResponseException(HttpStatus status) {
        this.status = status;
    }

    public ResponseException(int status) {
        this.status = HttpStatus.resolve(status);
    }

    public ResponseException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }
}

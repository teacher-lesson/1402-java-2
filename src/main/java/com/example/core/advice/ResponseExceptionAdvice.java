package com.example.core.advice;


import com.example.core.exception.ResponseException;
import com.example.dto.message.ResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResponseExceptionAdvice {

    @ExceptionHandler
    public ResponseEntity<ResponseDto> resolutionExceptionResponseEntity(ResponseException e) {
        if (e.getMessage() != null) {
            return ResponseEntity.status(e.getStatus())
                    .body(new ResponseDto(
                            true,
                            e.getStatus().value(),
                            e.getMessage()
                    ));
        }

        return ResponseEntity.status(e.getStatus()).body(
                new ResponseDto(true, e.getStatus().value())
        );
    }
}

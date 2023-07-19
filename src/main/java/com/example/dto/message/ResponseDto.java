package com.example.dto.message;

import com.example.dto.IDto;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDto implements IDto {
    private boolean error;
    private int status;
    private String message;

    public ResponseDto(boolean error, int status) {
        this.error = error;
        this.status = status;
    }
}

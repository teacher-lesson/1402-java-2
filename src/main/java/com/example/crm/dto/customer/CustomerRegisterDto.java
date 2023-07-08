package com.example.crm.dto.customer;

import com.example.crm.dto.BaseDto;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@EqualsAndHashCode
public class CustomerRegisterDto {
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    private String number;
}

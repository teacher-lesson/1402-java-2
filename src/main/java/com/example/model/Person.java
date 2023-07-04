package com.example.model;

import com.example.core.PersianText;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    @PersianText
    private String firstName;

    @NotBlank
    @Size(min = 5, max = 20, message = "This must between 5 and 20")
    private String lastName;

    @Range(min = 10, max = 100)
    private int age;
}

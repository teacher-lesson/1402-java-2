package com.example.model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    @Pattern(regexp = "^[\\u0622\\u0627\\u0628\\u067E\\u062A-\\u062C\\u0686\\u062D-\\u0632\\u0698\\u0633-\\u063A\\u0641\\u0642\\u06A9\\u06AF\\u0644-\\u0648\\u06CC]+$")
    private String firstName;

    @NotBlank
    @Size(min = 5, max = 20, message = "This must between 5 and 20")
    private String lastName;

    @Range(min = 10, max = 100)
    private int age;
}

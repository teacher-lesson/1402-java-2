package com.example.core;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@NotBlank
@Pattern(regexp = "^[\\u0622\\u0627\\u0628\\u067E\\u062A-\\u062C\\u0686\\u062D-\\u0632\\u0698\\u0633-\\u063A\\u0641\\u0642\\u06A9\\u06AF\\u0644-\\u0648\\u06CC]+$")

public @interface PersianText {
}

package org.example.couch;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FootballCouch implements Couch {
    private String name;
}

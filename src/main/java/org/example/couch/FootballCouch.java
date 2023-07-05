package org.example.couch;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class FootballCouch implements Couch {
    private String name;
}

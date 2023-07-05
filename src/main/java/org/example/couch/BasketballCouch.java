package org.example.couch;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class BasketballCouch implements Couch {
    private String name = "Hamed";
}

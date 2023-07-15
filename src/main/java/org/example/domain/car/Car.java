package org.example.domain.car;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.domain.person.Person;

import java.io.Serializable;

import static jakarta.persistence.GenerationType.IDENTITY;

@Data
@NoArgsConstructor


@Entity
@Table(name = "cars")
public class Car implements Serializable {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;

    private String name;

    private String model;

    private int year;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person owner;

    public Car(String name, String model, int year, Person owner) {
        this.name = name;
        this.model = model;
        this.year = year;
        this.owner = owner;
    }
}

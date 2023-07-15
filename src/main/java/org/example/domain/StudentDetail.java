package org.example.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Objects;

@Data
@NoArgsConstructor
//@ToString(exclude = "student")


@Entity
@Table(name = "student_details")
public class StudentDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "parent_name")
    private String parentName;

    @ToString.Exclude
    @OneToOne(mappedBy = "detail")
    private Student student;

    public StudentDetail(String phoneNumber, String parentName) {
        this.phoneNumber = phoneNumber;
        this.parentName = parentName;
    }
}

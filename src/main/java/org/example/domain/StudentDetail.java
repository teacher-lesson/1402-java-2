package org.example.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor


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

    public StudentDetail(String phoneNumber, String parentName) {
        this.phoneNumber = phoneNumber;
        this.parentName = parentName;
    }
}

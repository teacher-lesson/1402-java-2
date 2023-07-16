package com.example.domain.book;

import com.example.domain.IEntity;
import com.example.domain.user.User;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

import static jakarta.persistence.GenerationType.IDENTITY;

@Data
@ToString(exclude = "writer")
@EqualsAndHashCode(exclude = "writer")
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "books")
public class Book implements IEntity<Integer> {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;

    @Column(unique = true, nullable = false)
    private String title;

    @Column(nullable = false)
    private String isbn;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "writer_id")
    private User writer;

    @Column(nullable = false)
    private double price;

    @Column
    private Date publication;
}

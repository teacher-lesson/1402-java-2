package com.example.dto.book;

import com.example.domain.book.Book;
import com.example.dto.IDomainDto;
import lombok.Data;

import java.util.Date;

@Data
public class BookDto implements IDomainDto<Integer> {
    private Integer id;
    private String title;
    private String isbn;
    private double price;
    private Date publication;

    public BookDto(Book book) {
        this.id = book.getId();
        //FIXME
    }

    @Override
    public Book toEntity() {
        //FIXME
        return null;
    }
}

package com.microlending.microlendingapp.controllers;


import com.microlending.microlendingapp.api.BookService;
import com.microlending.microlendingapp.entities.Book;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookApi {

    private final BookService bookService;

    public BookApi(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books")
    List<Book> all() {
        return bookService.list();
    }

}

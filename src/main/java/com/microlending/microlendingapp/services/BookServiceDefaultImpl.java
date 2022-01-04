package com.microlending.microlendingapp.services;

import com.microlending.microlendingapp.api.BookService;
import com.microlending.microlendingapp.entities.Book;
import com.microlending.microlendingapp.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class BookServiceDefaultImpl implements BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookServiceDefaultImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    @Override
    public List<Book> list() {
        return bookRepository.findAll();
    }
}

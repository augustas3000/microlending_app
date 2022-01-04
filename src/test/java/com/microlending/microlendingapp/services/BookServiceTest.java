package com.microlending.microlendingapp.services;

import com.microlending.microlendingapp.api.BookService;
import com.microlending.microlendingapp.entities.Book;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class BookServiceTest {

    @Autowired
    private BookService bookService; //TODO use a mock and switch to unit test, separate tests to be written for persistence

    @Test
    public void whenApplicationStarts_thenHibernateCreatesInitialRecords() {
        List<Book> books = bookService.list();

        assertEquals(books.size(), 3);
    }

}

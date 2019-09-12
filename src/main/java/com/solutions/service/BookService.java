package com.solutions.service;

import com.solutions.entity.Book;
import org.springframework.stereotype.Service;

import java.util.List;

public interface BookService {
    List<Book> findAll();
    Book findById(int idBook);
    void save(Book book);
    void remove(Book book);
    Book findByName(String nameBook);
}

package com.solutions.service.impl;

import com.solutions.entity.Book;
import com.solutions.repository.BookRepository;
import com.solutions.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookRepository bookRepository;

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book findById(int idBook) {
        return bookRepository.findById(idBook).get();
    }

    @Override
    public void save(Book book) {
        bookRepository.save(book);
    }

    @Override
    public void remove(Book book) {
        bookRepository.delete(book);
    }

    @Override
    public Book findByName(String nameBook) {
        return bookRepository.findByBookName(nameBook);
    }
}

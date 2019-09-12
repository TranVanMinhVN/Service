package com.solutions.controller;

import com.solutions.entity.Book;
import com.solutions.request.BookForm;
import com.solutions.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BookController {

    @Autowired
    BookService bookService;

    @PostMapping
    public String test() {
        return "Hello";
    }

    @GetMapping("/book")
    public ResponseEntity<List<Book>> fillAll(){
        List<Book> list = bookService.findAll();
        return new ResponseEntity<List<Book>>(list, HttpStatus.OK);
    }


    @GetMapping("/book/{idBook}")
    public ResponseEntity<?> findById(@PathVariable(("idBook")) int idBook){
        return new ResponseEntity<>(bookService.findById(idBook),HttpStatus.OK);
    }

    @GetMapping("/book/{nameBook}")
    public ResponseEntity<?> findByName(@PathVariable("nameBook") String nameBook){
        return new ResponseEntity<>(bookService.findByName(nameBook),HttpStatus.OK);
    }

    @PostMapping("/book")
    public ResponseEntity<?> creaate(@RequestBody Book Book){
        bookService.save(Book);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/book/{idBook}")
    public ResponseEntity<?> uptate(@PathVariable("idBook") int idBook, @RequestBody BookForm b){
        Book Book = bookService.findById(idBook);
        Book.setBookName(b.getBookName());
        Book.setState(b.getState());
        bookService.save(Book);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/book/{idBook}")
    public ResponseEntity<?> remove(@PathVariable(("idBook")) int idBook){
        Book Book = bookService.findById((idBook));
        bookService.remove(Book);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

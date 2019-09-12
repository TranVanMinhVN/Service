package com.solutions.controller;

import com.solutions.entity.Person;
import com.solutions.request.PersonForm;
import com.solutions.service.BookService;
import com.solutions.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PersonController {

    @Autowired
    PersonService personService;
    @Autowired
    BookService bookService;

    @GetMapping("/person")
    public ResponseEntity<List<Person>> findAll() {
        List<Person> list = personService.findAll();
        return new ResponseEntity<List<Person>>(list, HttpStatus.OK);
    }

    @GetMapping("/person/{id}")
    public ResponseEntity<?> findById(@PathVariable int id) {
        return new ResponseEntity<>(personService.findById(id), HttpStatus.OK);
    }

    @GetMapping("/book/{name}")
    public ResponseEntity<?> findByName(@PathVariable("name") String name) {
        return new ResponseEntity<>(personService.findByName(name), HttpStatus.OK);
    }

    @PostMapping("/person")
    public ResponseEntity<?> create(@RequestBody PersonForm personForm) {
        Person person = new Person();
        person.setName(personForm.getName());
        personService.save(person);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/person/{id}")
    public ResponseEntity<?> remove(@PathVariable int id) {
        Person person = personService.findById(id);
        personService.remove(person);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/person/{id}")
    public ResponseEntity<?> update(@PathVariable int id, @RequestBody PersonForm personForm) throws InterruptedException {
        Person person = personService.findById(id);
        person.setName(personForm.getName());
        personService.save(person);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}

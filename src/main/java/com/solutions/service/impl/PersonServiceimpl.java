package com.solutions.service.impl;

import com.solutions.entity.Person;
import com.solutions.repository.PersonRepository;
import com.solutions.service.BookService;
import com.solutions.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceimpl implements PersonService {

    @Autowired
    PersonRepository personRepository;

    @Override
    public List<Person> findAll() {
        return personRepository.findAll();
    }

    @Override
    public Person findById(int id) {
        return personRepository.findById(id).get();
    }

    @Override
    public Person findByName(String name) {
        return personRepository.findByName(name);
    }

    @Override
    public void save(Person person) {
        personRepository.save(person);
    }

    @Override
    public void remove(Person person) {
        personRepository.delete(person);
    }

}

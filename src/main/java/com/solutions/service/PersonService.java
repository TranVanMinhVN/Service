package com.solutions.service;

import com.solutions.entity.Person;
import org.springframework.stereotype.Service;

import java.util.List;

public interface PersonService {
    List<Person> findAll();
    Person findById(int id);
    Person findByName(String name);
    void save(Person person);
    void remove(Person person);
}

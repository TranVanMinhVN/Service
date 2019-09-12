package com.solutions.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idBook")
    private int idBook;

    @Column(name="bookName")
    @NotNull
    private String bookName;

    @Column(name="state")
    private boolean state;

    public boolean getState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public void setIdBook(int idBook) {
        this.idBook = idBook;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getIdBook() {
        return idBook;
    }

    public String getBookName() {
        return bookName;
    }

    @Override
    public String toString() {
        return "idBook='"+idBook+'\''+
                ",bookName='"+bookName+'\''+
                ",state='"+state+ '\'';
    }
}

package com.thoughtworks.lgl.service;

import com.thoughtworks.lgl.model.Book;

public interface BookService {

    Iterable<Book> findAll();

    Book findByIsbn(String isbn);

    void addBook(Book newBook);

    void deleteBook(String isbn);

}

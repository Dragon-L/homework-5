package com.thoughtworks.lgl.service;

import com.thoughtworks.lgl.model.Book;
import com.thoughtworks.lgl.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Iterable<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book findByIsbn(String isbn) {
        return bookRepository.findOne(isbn);
    }

    @Override
    public void addBook(Book newBook) { bookRepository.addBook(newBook); }

    @Override
    public void deleteBook(String isbn) { bookRepository.deleteBook(isbn); }
}

package com.example.library.service;

import com.example.library.repository.BookRepository;

public class BookService {
    private BookRepository bookRepository;

    // Spring uses this setter to inject BookRepository
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void addBook(String title) {
        bookRepository.save(title);
    }
}

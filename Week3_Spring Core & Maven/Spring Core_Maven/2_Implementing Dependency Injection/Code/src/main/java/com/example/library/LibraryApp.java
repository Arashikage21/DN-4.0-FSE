package com.example.library;

import com.example.library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LibraryApp {
    public static void main(String[] args) {
        ApplicationContext ctx =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        BookService service =
                (BookService) ctx.getBean("bookService");

        // Test DI: this should invoke BookRepository.save(...)
        service.addBook("Dependency Injection");
    }
}

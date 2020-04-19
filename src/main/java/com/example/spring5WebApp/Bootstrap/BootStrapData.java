package com.example.spring5WebApp.Bootstrap;

import com.example.spring5WebApp.Models.Author;
import com.example.spring5WebApp.Models.Book;
import com.example.spring5WebApp.Repositories.AuthorRepository;
import com.example.spring5WebApp.Repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;


    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }


    @Override
    public void run(String... args) throws Exception {
        Author tolkien = new Author("J.R.R", "Tolkien");
        Book lotr = new Book("Lord of the Rings", "1234");
        tolkien.getBooks().add(lotr);
        lotr.getAuthors().add(tolkien);

        authorRepository.save(tolkien);
        bookRepository.save(lotr);
        
        Author jack = new Author("Jack", "Johnson");
        Author sam = new Author("Sam", "Smith");
        Book math = new Book("Math Book", "314");

        authorRepository.save(jack);
        authorRepository.save(sam);
        bookRepository.save(math);

        System.out.println("Number of Books: " + bookRepository.count());
    }

}
package com.example.spring5WebApp.Bootstrap;

import com.example.spring5WebApp.Models.Author;
import com.example.spring5WebApp.Models.Book;
import com.example.spring5WebApp.Models.Publisher;
import com.example.spring5WebApp.Repositories.AuthorRepository;
import com.example.spring5WebApp.Repositories.BookRepository;
import com.example.spring5WebApp.Repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;


    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository){
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Publisher publisher = new Publisher();
        publisher.setName("SomePublisher");
        publisher.setCity("Milwaukee");
        publisher.setState("Wisconsin");

        publisherRepository.save(publisher);

        Author tolkien = new Author("J.R.R", "Tolkien");
        Book lotr = new Book("Lord of the Rings", "1234");
        tolkien.getBooks().add(lotr);
        lotr.getAuthors().add(tolkien);
        lotr.setPublisher(publisher);
        publisher.getBooks().add(lotr);

        authorRepository.save(tolkien);
        bookRepository.save(lotr);
        publisherRepository.save(publisher);
        
        Author jack = new Author("Jack", "Johnson");
        Author sam = new Author("Sam", "Smith");
        Book math = new Book("Math Book", "314");
        math.setPublisher(publisher);
        math.getAuthors().add(jack);
        publisher.getBooks().add(math);

        authorRepository.save(jack);
        authorRepository.save(sam);
        bookRepository.save(math);

        System.out.println("Number of Publishers: " + publisherRepository.count());
        System.out.println(publisher.getName() + "'s" + " number of books: " + publisher.getBooks().size());
        System.out.println("Number of Books: " + bookRepository.count());
        System.out.println("Number of Authors: " + authorRepository.count());
    }

}
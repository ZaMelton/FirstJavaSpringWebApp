package com.example.spring5WebApp.Controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.spring5WebApp.Models.Book;
import com.example.spring5WebApp.Models.Publisher;
import com.example.spring5WebApp.Repositories.BookRepository;
import com.example.spring5WebApp.Repositories.PublisherRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {

    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BookController(BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @RequestMapping("/books")
    public String getBooks(Model model){
        model.addAttribute("books", bookRepository.findAll());
        return "books";
    }

    @RequestMapping("/add")
    public String add(HttpServletRequest request, HttpServletResponse response){
        Book newBook = new Book();
        newBook.setTitle(request.getParameter("title"));
        newBook.setIsbn(request.getParameter("isbn"));
        bookRepository.save(newBook);

        Publisher publisher = new Publisher();
        publisher.setName("SomePublisher");
        publisher.setCity("Milwaukee");
        publisher.setState("Wisconsin");
        publisherRepository.save(publisher);

        newBook.setPublisher(publisher);
        bookRepository.save(newBook);

        return "index";
    }
}
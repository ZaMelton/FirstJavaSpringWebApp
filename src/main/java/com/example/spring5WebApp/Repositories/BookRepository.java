package com.example.spring5WebApp.Repositories;

import com.example.spring5WebApp.Models.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {

}
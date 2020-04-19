package com.example.spring5WebApp.Repositories;

import com.example.spring5WebApp.Models.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long>{

}
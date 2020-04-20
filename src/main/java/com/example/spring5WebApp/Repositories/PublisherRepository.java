package com.example.spring5WebApp.Repositories;

import com.example.spring5WebApp.Models.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {

}
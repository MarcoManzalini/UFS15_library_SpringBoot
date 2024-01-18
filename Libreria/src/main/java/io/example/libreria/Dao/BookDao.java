package io.example.libreria.Dao;

import io.example.libreria.Model.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookDao extends CrudRepository<Book, Long> {
    Book findById(long id);

    Book findByTitle(String title);

}

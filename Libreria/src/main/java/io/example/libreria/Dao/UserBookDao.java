package io.example.libreria.Dao;

import io.example.libreria.Model.Book;
import io.example.libreria.Model.User;
import io.example.libreria.Model.UserBook;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserBookDao extends CrudRepository<UserBook, Long> {
    UserBook findById(long id);

    List<UserBook> findByUserId(long id);
}

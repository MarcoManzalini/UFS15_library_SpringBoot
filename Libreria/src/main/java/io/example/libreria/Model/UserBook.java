package io.example.libreria.Model;

import jakarta.persistence.*;

@Entity
public class UserBook {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    @ManyToOne
    @JoinColumn
    private User user;

    @ManyToOne
    @JoinColumn
    private Book book;

    public UserBook(){}

    public UserBook(User user, Book book) {
        this.user = user;
        this.book = book;
    }


    public long getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}

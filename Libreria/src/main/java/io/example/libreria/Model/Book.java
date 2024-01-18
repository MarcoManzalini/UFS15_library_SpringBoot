package io.example.libreria.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Books")
public class Book implements Serializable {

    @Id
    @PrimaryKeyJoinColumn
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @NotNull(message = "This field can't be empty")
    String author, title, pubblicationYear;
    @NotNull(message = "This field can't be empty")
    Double price;

    @Transient
    @OneToMany(mappedBy = "book", fetch = FetchType.EAGER)
    public Set<UserBook> userBooks = new HashSet<>();

    public Book(){}

    public Book(String author, String title, String publicationYear, Double price) {
        this.author = author;
        this.title = title;
        this.pubblicationYear = publicationYear;
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPubblicationYear() {
        return pubblicationYear;
    }

    public void setPubblicationYear(String pubblicationYear) {
        this.pubblicationYear = pubblicationYear;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", pubblicationYear='" + pubblicationYear + '\'' +
                ", price=" + price +
                '}';
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}

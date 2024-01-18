package io.example.libreria.Controller;

import io.example.libreria.Dao.BookDao;
import io.example.libreria.Model.Book;
import io.example.libreria.Model.BookAPI.Item;
import io.example.libreria.Model.BookAPI.Root;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/*
Considerando il progetto della Libreria, richiesta nelle esercitazioni passate, di definire dei metodi
Restful che mi consentano di:

• restituire l’elenco di tutti i libri in formato Json

• un altro metodo che mi consente di ottenere il dettaglio di un singolo libro, fornendo il titolo (in
formato Json)

• Si richiede di definire un endpoint (ad esempio “/sincronizza”) che va a prendere dei libri dalla
fonte di GoogleApis e li memorizza nel proprio DB per poi effettuare le operazioni sopra richieste
(studiare la documentazione GoogleApi “https://developers.google.com/books/docs/v1/
using#st_params”). Si consiglia di utilizzare RestTemplate
 */

@RestController
public class RestBookController {

    @Autowired
    private BookDao bookRepository;



    @GetMapping("/jsonBooks")
    public ArrayList<Book> jsonBooks(){
        return (ArrayList<Book>) bookRepository.findAll();
    }

    @GetMapping("/jsonBookByTitle")
    public Book jsonBook(@RequestParam(value = "title", defaultValue = "CG4L")String title){
        return  bookRepository.findByTitle(title);
    }

    @GetMapping("/synchronize")
    public void googleBooks(){
        RestTemplate restTemplate = new RestTemplate();
        String booksApi  = "https://www.googleapis.com/books/v1/volumes?q=\"\"&maxResults=40";
        Root root = restTemplate.getForObject(booksApi, Root.class);
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

        for(Item item: root.items){
            Book tempBook = new Book(item.volumeInfo.authors.get(0), item.volumeInfo.title,
                    df.format(item.volumeInfo.publishedDate.getTime()),
                    item.saleInfo.listPrice == null ?
                            0 : item.saleInfo.listPrice.amount
            );
            bookRepository.save(tempBook);
        }
    }
}

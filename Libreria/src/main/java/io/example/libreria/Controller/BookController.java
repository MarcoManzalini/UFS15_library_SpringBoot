package io.example.libreria.Controller;

import io.example.libreria.Dao.BookDao;
import io.example.libreria.Dao.UserBookDao;
import io.example.libreria.Dao.UserDao;
import io.example.libreria.Model.Book;
import io.example.libreria.Model.UserBook;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import io.example.libreria.Model.User;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Controller
public class BookController {

    @Autowired
    private BookDao bookRepository;
    @Autowired
    private UserDao userRepository;

    @Autowired
    private UserBookDao userBookRepository;

    @GetMapping(value = "controlPanel")
    public String controlPanel(HttpSession session){
        if (session.getAttribute("loggedUser") == null) return "redirect:/login";
        return "controlPanel";
    }


    @GetMapping(value = "/addBook")
    public String addBookPage(Book book,HttpSession session) {;
        if (session.getAttribute("loggedUser") == null) return "redirect:/login";

        return "addBook";
    }

    @PostMapping(value = "/addBookAction")
    public String addBookAction(@Valid Book book, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) return "addBook";

        for(Book b : bookRepository.findAll()){
            if(Objects.equals(b.getTitle().toLowerCase(), book.getTitle().toLowerCase()) &&
                    b.getAuthor().toLowerCase().equals(book.getAuthor().toLowerCase()))
                return "redirect:/bookInfo";
        }

        bookRepository.save(book);

        return "redirect:/controlPanel";
    }


    @GetMapping(value = "/bookInfo")
    public String bookInfo(Model model,HttpSession session) {
        if (session.getAttribute("loggedUser") == null) return "redirect:/login";

        model.addAttribute("books", bookRepository.findAll());
        return "bookInfo";
    }

    @GetMapping(value = "/yourBooks")
    public String yourBooks(HttpSession session, Model model){
        if (session.getAttribute("loggedUser") == null) return "redirect:/login";

        User loggedUser = (User) session.getAttribute("loggedUser");
        Optional<User> u = userRepository.findById(loggedUser.getId());

        List<Book> userBooks = new ArrayList<>();
        for (UserBook b :  u.get().getUserBooks()){
            userBooks.add(b.getBook());
        }

        model.addAttribute("books", userBooks);

        return "yourBooks";
    }

    @GetMapping(value="/addFavouriteBook")
    public String addFavouriteBook(HttpSession session, @RequestParam("favourite_book_id") long id){
        User loggedUser = (User) session.getAttribute("loggedUser");

        for (UserBook userBook : loggedUser.getUserBooks()){
            if(userBook.getBook().getId() == id) return "redirect:/yourBooks";
        }

        Book book = bookRepository.findById(id);
        UserBook userBook = new UserBook(loggedUser,book);
        userBookRepository.save(userBook);
        return "redirect:/yourBooks";
    }

    @GetMapping(value = "/removeFromFavourites")
    public String removeFromFavourites(HttpSession session, @RequestParam("favourite_book_id") long id){
        User loggedUser = (User) session.getAttribute("loggedUser");

        for(UserBook userBook : userBookRepository.findByUserId(loggedUser.getId())){
           if(userBook.getBook().getId() == id) userBookRepository.deleteById(userBook.getId());
        }

        return "redirect:/yourBooks";
    }

}

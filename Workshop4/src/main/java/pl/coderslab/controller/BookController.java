package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.Book;
import pl.coderslab.service.BookService;
import pl.coderslab.service.JpaBookService;
import pl.coderslab.service.MockBookService;

import javax.validation.Valid;
import java.util.List;
//import pl.coderslab.service.JpaBookService;


@Controller
@RequestMapping("/books")
public class BookController {
    private final BookService jpaBookService;

    @Autowired
    MockBookService mockBookService;

    public BookController(BookService jpaBookService) {
        this.jpaBookService = jpaBookService;
    }

    @RequestMapping("/helloBook")
    public Book helloBook() {
        return new Book(1L, "9788324631766", "Thinking in Java",
                "Bruce Eckel", "Helion", "programming");
    }

    @RequestMapping("save")
    public String saveBooks() {
        List<Book> books = mockBookService.getBooks();
        for (Book book : books) {
            jpaBookService.add(book);
        }
        return "redirect: /books";
    }

    @RequestMapping(path = "/form")
    public String displayForm(@RequestParam Long id, Model model) throws Exception {
        Book book;
        if (id == null) {
            book = new Book();
        } else {
            book = jpaBookService.get(id);
        }
        model.addAttribute("book", book);
        return "book/form";
    }

    @PostMapping("/form")
    public String processForm(@Valid Book book, BindingResult result) {
        if (result.hasErrors()) {
            return "book/form";
        }
        Long bookId = book.getId();
        if (bookId == null) {
            jpaBookService.add(book);
        } else {
            jpaBookService.update(book);
        }
        return "redirect: /books";
    }

    @RequestMapping("")
    public String getBooks(Model model) {
        List<Book> books = jpaBookService.getBooks();
        model.addAttribute("books", books);
        return "book/allBooks";
    }

    @RequestMapping("/{id}")
    public String get(@PathVariable long id, Model model) throws Exception {
        Book book = jpaBookService.get(id);
        model.addAttribute("books",  List.of(book));
        return "book/allBooks";
    }

    @RequestMapping("/update")
    public void update(@RequestBody Book book) {
        jpaBookService.add(book);
    }

    @RequestMapping(path = "/delete")
    public String delete(@RequestParam long id) {
        jpaBookService.delete(id);
        return "redirect: /books";
    }
}

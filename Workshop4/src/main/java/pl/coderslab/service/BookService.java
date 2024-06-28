package pl.coderslab.service;

import pl.coderslab.model.Book;


import java.util.List;
import java.util.Optional;

public interface BookService {

    List<Book> getBooks();

    Book get(Long id) throws Exception;

    void add(Book book);

    void delete(Long id);

    void update(Book book);
}


package pl.coderslab.service;

import org.springframework.stereotype.Service;
import pl.coderslab.model.Book;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MockBookService implements BookService {
    private List<Book> list;

    private static Long nextId = 4L;

    public MockBookService() {
        list = new ArrayList<>();
        list.add(new Book(1L, "9788324631766", "Thinking in Java", "Bruce	Eckel", "Helion", "programming"));
        list.add(new Book(2L, "9788324627738", "Rusz	glowa	Java.", "Sierra	Kathy,	Bates	Bert", "Helion",
                "programming"));
        list.add(new Book(3L, "9780130819338", "Java	2.	Podstawy", "Cay	Horstmann,	Gary	Cornell", "Helion",
                "programming"));
    }

    public Long getNextId() {
        return nextId;
    }


    @Override
    public List<Book> getBooks() {
        return list;
    }

    @Override
    public Book get(Long id) {
        Optional<Book> first = list.stream()
                .filter(book -> book.getId().equals(id))
                .findFirst();
        return first.orElseThrow(null);
    }

    @Override
    public void add(Book book) {
        list.add(book);
        nextId += 1L;
    }

    @Override
    public void delete(Long id) {
        if (get(id) != null) {
            this.list = list.stream()
                    .filter(book -> !book.getId().equals(id))
                    .collect(Collectors.toList());
        }
    }

    @Override
    public void update(Book book) {
        Book bookToUpdate = get(book.getId());
        if (bookToUpdate != null) {
            int i = list.indexOf(bookToUpdate);
            list.set(i, book);
        }
    }
}


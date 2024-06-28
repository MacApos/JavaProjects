package pl.coderslab.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import pl.coderslab.model.Book;
import pl.coderslab.repository.BookRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Component
@Primary
@Transactional
public class JpaBookService implements BookService {
    private final BookRepository bookRepository;

    public JpaBookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book get(Long id) throws Exception {
        return bookRepository.findById(id).orElseThrow(()
                -> new Exception("Book not found"));
    }

    @Override
    public void add(Book book) {
        bookRepository.save(book);
    }

    @Override
    public void delete(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public void update(Book book) {
        bookRepository.updateBookById(book.getAuthor(), book.getIsbn(), book.getPublisher(),
                book.getTitle(), book.getType(), book.getId());
    }
}

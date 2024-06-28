package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.coderslab.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    @Modifying
    @Query("UPDATE Book b SET b.author = :author, b.isbn = :isbn, b.publisher=:publisher, " +
            "b.title=:title, b.type=:type WHERE b.id = :id")
    void updateBookById(@Param("author") String author, @Param("isbn") String isbn,
                        @Param("publisher") String publisher, @Param("title") String title,
                        @Param("type") String type, @Param("id") Long id);
}

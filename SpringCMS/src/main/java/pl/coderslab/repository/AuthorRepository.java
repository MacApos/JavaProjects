package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.model.Article;
import pl.coderslab.model.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {

}

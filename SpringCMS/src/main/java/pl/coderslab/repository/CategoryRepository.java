package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.model.Article;

public interface CategoryRepository extends JpaRepository<Article, Long> {

}

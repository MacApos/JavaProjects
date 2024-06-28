package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.coderslab.model.Article;
import pl.coderslab.model.Author;
import pl.coderslab.model.Category;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
@Transactional
public interface ArticleRepository extends JpaRepository<Article, Long> {
    @Modifying
    @Query("update Article a set a.title = ?1,a.author = ?2, a.content= ?3, a.categories=?4 where a.id = ?5")
    void updateArticleById(String title, Author author, String content, List<Category> categories, Long id);
}

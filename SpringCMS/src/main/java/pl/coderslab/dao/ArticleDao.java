package pl.coderslab.dao;

import pl.coderslab.model.Article;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class ArticleDao {
    @PersistenceContext
    EntityManager entityManager;

    public void save(Article entity) {
        entityManager.persist(entity);
    }

    public void update(Article entity) {
        entityManager.merge(entity);
    }

    public Article getById(long id) {
        return entityManager.find(Article.class, id);
    }

    public void delete(Article article) {
        entityManager.remove(entityManager.contains(article) ? article : entityManager.merge(article));
    }

    public void deleteById(long id) {
        Article entity = getById(id);
        if (entity != null) {
            entityManager.remove(entity);
        }
    }

    public List<Article> findAllArticles(){
        Query query = entityManager.createQuery("SELECT a FROM Article a");
        return query.getResultList();
    }
}
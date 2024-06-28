package pl.coderslab.dao;

import pl.coderslab.model.Author;
import org.springframework.stereotype.Repository;
import pl.coderslab.model.Category;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class AuthorDao {
    @PersistenceContext
    EntityManager entityManager;

    public void save(Author entity) {
        entityManager.persist(entity);
    }

    public void update(Author entity) {
        entityManager.merge(entity);
    }

    public Author getById(long id) {
        return entityManager.find(Author.class, id);
    }

    public void delete(Author author) {
        entityManager.remove(entityManager.contains(author) ? author : entityManager.merge(author));
    }

    public void deleteById(long id) {
        Author entity = getById(id);
        if (entity != null) {
            entityManager.remove(entity);
        }
    }

    public List<Author> findAllAuthors(){
        Query query = entityManager.createQuery("SELECT a FROM Author a");
        return query.getResultList();
    }

}
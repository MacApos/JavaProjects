package pl.coderslab.dao;

import pl.coderslab.model.Article;
import pl.coderslab.model.Category;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class CategoryDao {
    @PersistenceContext
    EntityManager entityManager;

    public void save(Category entity) {
        entityManager.persist(entity);
    }

    public void update(Category entity) {
        entityManager.merge(entity);
    }

    public Category getById(long id) {
        return entityManager.find(Category.class, id);
    }

    public void delete(Category category) {
        entityManager.remove(entityManager.contains(category) ? category : entityManager.merge(category));
    }

    public void deleteById(long id) {
        Category entity = getById(id);
        if (entity != null) {
            entityManager.remove(entity);
        }
    }

    public List<Category> findAllCategories(){
        Query query = entityManager.createQuery("SELECT c FROM Category c");
        return query.getResultList();
    }

}
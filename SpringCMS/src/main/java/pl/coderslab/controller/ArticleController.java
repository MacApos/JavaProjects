package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dao.ArticleDao;
import pl.coderslab.dao.AuthorDao;
import pl.coderslab.dao.CategoryDao;
import pl.coderslab.model.Article;
import pl.coderslab.model.Author;
import pl.coderslab.model.Category;
import pl.coderslab.repository.ArticleRepository;

import javax.validation.Valid;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path = "/article")
public class ArticleController {
    @Autowired
    ArticleDao articleDao;

    @Autowired
    AuthorDao authorDao;

    @Autowired
    CategoryDao categoryDao;

    ArticleRepository articleRepository;

    public ArticleController(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @RequestMapping(path = "/save")
    @ResponseBody
    public String saveArticle() {
        Article article1 = new Article();
        article1.setTitle("Title1");
        Author author = authorDao.getById(1L);
        if (author != null) {
            article1.setAuthor(author);
        }
        article1.setContent("Content1");
        articleDao.save(article1);

        Article article2 = new Article();
        article2.setTitle("Title2");
        Author author2 = authorDao.getById(2L);
        if (author2 != null) {
            article2.setAuthor(author2);
        }
        article2.setContent("Content2");
        articleDao.save(article2);

        Category category1 = categoryDao.getById(1L);
        Category category2 = categoryDao.getById(2L);
        if (category1 != null) {
            article1.getCategories().add(category1);
            article2.getCategories().add(category1);
        }
        if (category2 != null) {
            article1.getCategories().add(category2);
//            article2.getCategories().add(category2);
        }
        articleDao.update(article1);
        articleDao.update(article2);

        categoryDao.update(category1);
        categoryDao.update(category2);

        return article1 + "<br>" + article2;
    }

    @RequestMapping(path = "/form")
    public String displayForm(@RequestParam Long id, Model model) {
        Article article;
        if (id == null) {
            article = new Article();
        } else {
            article = get(id);
        }
        model.addAttribute("article", article);
        return "article/form";
    }

    @PostMapping("/form")
    public String processForm(@Valid Article article, BindingResult result) {
        if (result.hasErrors()) {
            return "article/form";
        }
//        save(article);
        Long articleId = article.getId();
        if (articleId == null) {
            save(article);
        } else {
            System.out.println(article.toString());
        }
        return "redirect: all";
    }

    @RequestMapping(path = "/{id}")
    public Article get(@PathVariable long id) {
        return articleRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("Article not found"));
    }

    @ModelAttribute("articles")
    public List<Article> getArticles() {
        return articleRepository.findAll();
    }

    @ModelAttribute("authors")
    public List<Author> getAuthors() {
        return authorDao.findAllAuthors();
    }

    @ModelAttribute("categories")
    public List<Category> getCategories() {
        return categoryDao.findAllCategories();
    }

    @GetMapping("/all")
    public String allArticles() {
        return "article/all";
    }

    public void save(Article article) {
        articleRepository.save(article);
    }

    public void update(Article article, Long id) {
        articleRepository.updateArticleById(article.getTitle(), article.getAuthor(),
                article.getContent(), article.getCategories(), id);
    }

    @RequestMapping(path = "/delete")
    public String delete(@RequestParam long id) {
        articleRepository.deleteById(id);
        return "redirect: all";
    }
}
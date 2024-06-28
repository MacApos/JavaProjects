package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.coderslab.model.Article;
import pl.coderslab.model.Author;
import pl.coderslab.model.Category;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.awt.print.Book;
import java.util.List;
import java.util.Set;

@Controller
public class ValidationController {
    @Autowired
    private Validator validator;

    @GetMapping("/validateArticle")
    public String validateArticle(Model model) {
        Article article = new Article();
        article.setTitle("Title5");
        article.setContent("Content5");
        article.setCategories(List.of(new Category()));
        Set<ConstraintViolation<Article>> violations = validator.validate(article);
        model.addAttribute("violations", violations);
        return "validation/validate";
    }

    @GetMapping("/validateAuthor")
    public String validateAuthor(Model model) {
        Author author = new Author();
        author.setFirstName("firstName");
        author.setLastName("lastName");
        Set<ConstraintViolation<Author>> violations = validator.validate(author);
        model.addAttribute("violations", violations);
        return "validation/validate";
    }
    
    @GetMapping("/validateCategory")
    public String validateCategory(Model model) {
        Category category = new Category();
        category.setName("Category3");
        Set<ConstraintViolation<Category>> violations = validator.validate(category);
        model.addAttribute("violations", violations);
        return "validation/validate";
    }

    
}

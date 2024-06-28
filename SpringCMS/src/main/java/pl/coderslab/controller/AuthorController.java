package pl.coderslab.controller;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.Author;
import org.springframework.stereotype.Controller;
import pl.coderslab.repository.AuthorRepository;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(path = "/author")
public class AuthorController {
    private final AuthorRepository authorRepository;

    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @RequestMapping(path = "/save")
    @ResponseBody
    public String saveAuthor() {
        Author author1 = new Author();
        author1.setFirstName("Adam");
        author1.setLastName("Mickiewicz");
        save(author1);

        Author author2 = new Author();
        author2.setFirstName("Juliusz");
        author2.setLastName("Słowacki");
        save(author2);

        Author author3 = new Author();
        author3.setFirstName("Jan");
        author3.setLastName("Kochanowski");
        save(author3);

        return author1 + "<br>" + author2 + "<br>" + author3;
    }

    @GetMapping("/form")
    public String displayForm(@RequestParam Long id, Model model) {
        Author author;
        if (id == null) {
            author = new Author();
        } else {
            author = get(id);
        }
        model.addAttribute("author", author);
        return "author/form";
    }

    @PostMapping("/form")
    public String processForm(@Valid Author author, BindingResult result) {
        if (result.hasErrors()) {
            return "author/form";
        }
        save(author);
        return "redirect: all";
    }

    @RequestMapping(path = "/{id}")
    public Author get(@PathVariable long id) {
        return authorRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("Article not found"));
    }

    @ModelAttribute("authors")
    public List<Author> getAuthors() {
        return authorRepository.findAll();
    }

    @GetMapping("/all")
    public String allAuthors() {
        return "author/all";
    }

    public void save(Author author) {
        authorRepository.save(author);
    }

    @RequestMapping(path = "/delete")
    public String delete(@RequestParam long id) {
        authorRepository.deleteById(id);
        return "redirect: all";
    }
}
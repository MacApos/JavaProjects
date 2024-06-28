package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dao.CategoryDao;
import pl.coderslab.model.Category;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(path = "/category")
public class CategoryController {
    @Autowired
    CategoryDao categoryDao;

    @RequestMapping(path = "/save")
    @ResponseBody
    public String saveCategory() {
        Category category1 = new Category();
        category1.setName("Category1");
        category1.setDescription("Description1");
        categoryDao.save(category1);

        Category category2 = new Category();
        category2.setName("Category2");
        category2.setDescription("Description2");
        categoryDao.save(category2);

        Category category3 = new Category();
        category3.setName("Category3");
        category3.setDescription("Description3");
        categoryDao.save(category3);

        return category1 + "<br>" + category2 + "<br>" + category3;
    }

    @RequestMapping(path = "/form")
    public String displayForm(@RequestParam Long id, Model model) {
        Category category;
        if (id == null) {
            category = new Category();
        } else {
            category = categoryDao.getById(id);
            category.setDescription(category.getDescription());
            category.setName(category.getName());
        }
        model.addAttribute("category", category);
        return "category/form";
    }

    @PostMapping("/form")
    public String processForm(@Valid Category category, BindingResult result) {
        if (result.hasErrors()) {
            return "category/form";
        }
        if (category.getId() == null) {
            categoryDao.save(category);
        } else {
            categoryDao.update(category);
        }
        return "redirect: all";
    }

    @ModelAttribute("categories")
    public List<Category> getCategories() {
        return categoryDao.findAllCategories();
    }

    @GetMapping("/all")
    public String allCategories() {
        return "category/all";
    }

    @RequestMapping(path = "/update")
    @ResponseBody
    public String updateCategory(@RequestParam long id, @RequestParam String name, @RequestParam String description) {
        Category category = categoryDao.getById(id);
        category.setName(name);
        category.setDescription(description);
        categoryDao.update(category);
        return category.toString();
    }

    @RequestMapping(path = "/delete")
    public String deleteCategory(@RequestParam long id) {
        categoryDao.deleteById(id);
        return "redirect: all";
    }

    @RequestMapping(path = "/get")
    @ResponseBody
    public String getCategory(@RequestParam long id) {
        return categoryDao.getById(id).toString();
    }
}
package com.neuer.demo.controller;

import com.neuer.demo.model.entity.Category;
import com.neuer.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import static com.neuer.demo.util.constants.Constants.CATEGORY_ROOT_PATH;

@RestController
@RequestMapping(CATEGORY_ROOT_PATH)
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public List<Category> list() {
        return categoryService.list();
    }

    @PostMapping
    public Category save(Category category) {
        return categoryService.saveCategory(category);
    }

    @DeleteMapping
    public void delete(Category category) {
         categoryService.deleteCategory(category);
    }
}

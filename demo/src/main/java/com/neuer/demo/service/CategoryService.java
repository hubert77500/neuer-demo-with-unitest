package com.neuer.demo.service;

import com.neuer.demo.dao.CategoryDao;
import com.neuer.demo.model.entity.Category;
import com.neuer.demo.model.entity.Data;
import com.neuer.demo.model.exception.CategoryNotFoundException;
import com.neuer.demo.model.exception.InvalidInputException;
import com.neuer.demo.model.exception.NoDataFoundException;
import com.neuer.demo.model.exception.UnableToSaveException;
import com.neuer.demo.model.pojo.SavedCategoryCount;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    private static Logger log = LoggerFactory.getLogger(CategoryService.class.getName());
    @Autowired
    private CategoryDao categoryDao;

    // Lists all valid Categories
    public List<Category> list() {
        List<Category> categoriesFound = categoryDao.findAll();
        if(categoriesFound == null){
            log.error("Error found in List<Category> list()");
            throw new NoDataFoundException("Unable to create a list to show, there is no data found");
        }
        return categoriesFound;
    }

    public Long findIdByCategoryName(String categoryName) {
        if (categoryName == null || categoryName == "") {
            log.error("Error found in findIdByCategoryName(String categoryName)");
            throw new InvalidInputException("Invalid Category name input!");
        }
        Long idFound = categoryDao.findIdByCategoryName(categoryName);
        if(idFound == null || idFound == 0L){
            log.error("Error found in findIdByCategoryName(String categoryName)");
            throw new CategoryNotFoundException("Category not found!");
        }
        return idFound;
    }

    public Category saveCategory(Category category) {
        if (category == null) {
            log.error("Error found in saveCategory(Category category)");
            throw new InvalidInputException("Invalid Category input!");
        }
        Category categorySaved = categoryDao.save(category);
        if(categorySaved == null ){
            log.error("Error found in saveCategory(Category category");
            throw new UnableToSaveException("Unable to save category!");
        }
        return categorySaved;
    }

    //Deletes Category
    public void deleteCategory(Category category) {
        // Validation of the existence of the Data
        if (category == null) {
            log.error("Error found in Category Service.delete(Category category)");
            throw new InvalidInputException("Unable to find the requested Data Register to be deleted!");
        }
        categoryDao.delete(category);
    }

    public List<Data> validateCategories(List<Data> multipleDataRegisters) {
        if (multipleDataRegisters == null) {
            log.error("Error found in validateCategories(List<Data> multipleDataRegisters)");
            throw new InvalidInputException("Unable to validate a null list");
        }
        List<Data> validatedList = new ArrayList<>();
        // Filter existing valid categories only:
        for(Data data : multipleDataRegisters){
            Long categoryId = findIdByCategoryName(data.getCategory().getCategoryName());
            if(categoryId != null){
                validatedList.add(data);
            }
        }

        //removing from the List the duplicated sub-categories (see equals override for Data and Category) and this lambda expression:
        List<Data> listWithoutDuplicates = validatedList.stream()
                .distinct()
                .collect(Collectors.toList());
        return  listWithoutDuplicates;
    }

    public List<SavedCategoryCount> calculateOcurrencies(List<Data> validList){
        List<String> categories = new ArrayList<>();
        validList.forEach((data) -> categories.add(data.getCategory().getCategoryName()));
        List<SavedCategoryCount> reportObject = new ArrayList<>();
        Set<String> unique = new HashSet<String>(categories);
        unique.forEach((key)-> reportObject.add(new SavedCategoryCount(key, Collections.frequency(categories, key))));
        return reportObject;
    }
}

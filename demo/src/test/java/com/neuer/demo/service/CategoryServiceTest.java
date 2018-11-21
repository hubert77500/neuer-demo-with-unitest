package com.neuer.demo.service;

import com.neuer.demo.dao.CategoryDao;
import com.neuer.demo.model.entity.Category;
import com.neuer.demo.model.entity.Data;
import com.neuer.demo.model.exception.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceTest {

    @Autowired
    private CategoryService categoryService;

    // Mocking Instance
    @MockBean
    private CategoryDao categoryDao;

    //Definition of multiple data registers
    private List<Category> lsrCategories = new ArrayList<>();

    //Definition of test categories
    Category category1 =  new Category();
    Category category2 =  new Category();

    //Definition of null objects
    private Data nullData = null;
    private Category nullCategory = null;

    @Before
    public void setUp(){
        // Set up dummies and lists

        //Category1
        category1.setCategoryId(1);
        category1.setCategoryName("PERSON");

        // Category2
        category2.setCategoryId(1);
        category2.setCategoryName("PLACE");

        // Mutiple data entries in one time
        lsrCategories.add(category1);
        lsrCategories.add(category2);
    }

    //Unit test for some cases to show knowledge ( can be done thousands as milimetrically requested from customer...

    @Test(expected = NoDataFoundException.class)
    public void listNotFoundTest(){
        // If Positive case happens, muck it and test fail test
        Mockito.when(categoryDao.findAll()).thenReturn(null);
        assertThat(categoryService.list());
    }

    @Test(expected = InvalidInputException.class)
    public void saveTest() {
        // If Positive case happens, muck it and will fail test
        Mockito.when(categoryDao.save(null)).thenReturn(null);
        assertThat(categoryService.saveCategory(null));
    }

    @Test(expected = CategoryNotFoundException.class)
    public void findIdByCategoryNameNotFoundTest() {
        // If Positive case happens, muck it and will fail test
        Mockito.when(categoryDao.findIdByCategoryName("WIZARDS")).thenReturn(null);
        assertThat(categoryService.findIdByCategoryName("WIZARDS"));
    }

    @Test(expected = InvalidInputException.class)
    public void findIdByCategoryNameInvalidTest() {
        // If Positive case happens, muck it and will fail test
        Mockito.when(categoryDao.findIdByCategoryName(null)).thenReturn(null);
        assertThat(categoryService.findIdByCategoryName(null));
    }

    @Test(expected = UnableToSaveException.class)
    public void saveFailedTest() {
        // If Positive case happens, muck it and will fail test
        Mockito.when(categoryDao.save(category1)).thenReturn(null);
        assertThat(categoryService.saveCategory(category1));
    }

    @Test(expected = InvalidInputException.class)
    public void saveAllInvalidInputTest() {
        // If Positive case happens, muck it and will fail test
        Mockito.when(categoryDao.save(null)).thenReturn(null);
        assertThat(categoryService.findIdByCategoryName(null));
    }

    @Test(expected = InvalidInputException.class)
    public void validateCategoriesInvalidInputTest() {
        // If Positive case happens, muck it and will fail test
        assertThat(categoryService.validateCategories(null));
    }

    @Test(expected = InvalidInputException.class)
    public void calculateOcurrenciesInvalidInputTest() {
        assertThat(categoryService.validateCategories(null));
    }


}
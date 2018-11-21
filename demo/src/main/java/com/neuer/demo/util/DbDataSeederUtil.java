package com.neuer.demo.util;

        import com.neuer.demo.dao.CategoryDao;
        import com.neuer.demo.dao.DataDao;
        import com.neuer.demo.model.entity.Category;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.boot.CommandLineRunner;
        import org.springframework.stereotype.Component;
        import javax.transaction.Transactional;
        import java.util.*;

/**
 * Contains an util to create fill o update the database with the valid categories every time the application runs with
 * default valid info ( in this case, categories ).
 **/

@Component
public class DbDataSeederUtil implements CommandLineRunner {

    @Autowired
    CategoryDao categoryDao;

    @Autowired
    DataDao dataDao;

    @Override
    @Transactional
    public void run(String... strings) {

        // Categories
        Category cat1 = new Category();
        cat1.setCategoryName("PERSON");

        Category cat2 = new Category();
        cat2.setCategoryName("PLACE");

        Category cat3 = new Category();
        cat3.setCategoryName("COMPUTER");

        Category cat4 = new Category();
        cat4.setCategoryName("ANIMAL");

        Category cat5 = new Category();
        cat5.setCategoryName("OTHER");

        // Drop all Users
        categoryDao.deleteAll();

        // Add our Users to Database
        List<Category> categories = Arrays.asList(cat1, cat2, cat3, cat4, cat5);
        categoryDao.saveAll(categories);
    }
}
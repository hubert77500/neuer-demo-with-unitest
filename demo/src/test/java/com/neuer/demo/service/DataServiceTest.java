package com.neuer.demo.service;

import com.neuer.demo.dao.DataDao;
import com.neuer.demo.model.entity.Category;
import com.neuer.demo.model.entity.Data;
import com.neuer.demo.model.exception.DataNotDeletedException;
import com.neuer.demo.model.exception.InvalidInputException;
import com.neuer.demo.model.exception.NoDataFoundException;
import com.neuer.demo.model.exception.UnableToSaveException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest
public class DataServiceTest {

    @Autowired
    private DataService dataService;

    // Mocking Instance
    @MockBean
    private DataDao dataDao;

    //Definition of Valid Test case data dummies
    private Data dataRegister1 = new Data();
    private Data dataRegister2 = new Data();

    //Definition of multiple data registers
    private List<Data> lsrDataRegisters = new ArrayList<>();

    //Definition of test categories
    Category category1 =  new Category();
    Category category2 =  new Category();

    //Definition of null objects
    private Data nullData = null;
    private Category nullCategory = null;

    @Before
    public void setUp(){
        // Set up dummies and lists

        //Data2
        dataRegister1.setId(1);
        category1.setCategoryId(1);
        category1.setCategoryName("PERSON");
        dataRegister1.setCategory(category1);
        dataRegister1.setSubCategory("Bob Jones");

        // Data 1
        dataRegister2.setId(2);
        category2.setCategoryId(1);
        category2.setCategoryName("PLACE");
        dataRegister2.setCategory(category2);
        dataRegister2.setSubCategory("Washington");

        // Mutiple data entries in one time
        lsrDataRegisters.add(dataRegister1);
        lsrDataRegisters.add(dataRegister2);
    }

    //Unit test for some cases to show knowledge ( can be done thousands as milimetrically requested from customer...

    @Test(expected = InvalidInputException.class)
    public void listInvalidInputTest(){
        // If Positive case happens, muck it and test fail test
        Page page = new PageImpl(lsrDataRegisters);
        Pageable pageable = page.getPageable();
        Mockito.when(dataDao.findAll(pageable)).thenReturn(page);
        assertThat(dataService.list(null));
    }

    @Test(expected = NoDataFoundException.class)
    public void listNotFoundTest(){
        // If Positive case happens, muck it and test fail test
        Page page = new PageImpl(lsrDataRegisters);
        Pageable pageable = page.getPageable();
        Mockito.when(dataDao.findAll(pageable)).thenReturn(null);
        assertThat(dataService.list(pageable));
    }

    @Test(expected = InvalidInputException.class)
    public void saveAllTest() {
        // If Positive case happens, muck it and will fail test
        Mockito.when(dataDao.saveAll(null)).thenReturn(null);
        assertThat(dataService.saveAll(null));
    }

    @Test(expected = UnableToSaveException.class)
    public void saveAllFailedTest() {
        // If Positive case happens, muck it and will fail test
        Mockito.when(dataDao.saveAll(lsrDataRegisters)).thenReturn(null);
        assertThat(dataService.saveAll(lsrDataRegisters));
    }




}
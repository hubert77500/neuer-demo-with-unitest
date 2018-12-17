package com.neuer.demo.service;

import com.neuer.demo.dao.DataDao;
import com.neuer.demo.interfaces.BasicService;
import com.neuer.demo.model.entity.Data;
import com.neuer.demo.model.exception.InvalidInputException;
import com.neuer.demo.model.exception.NeuerException;
import com.neuer.demo.model.exception.NoDataFoundException;
import com.neuer.demo.model.exception.UnableToSaveException;
import com.neuer.demo.model.pojo.CategoryParsedResponse;
import com.neuer.demo.model.pojo.SavedCategoryCount;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;
import java.util.*;

import static com.neuer.demo.util.constants.Constants.CATEGORY_SERVICE_DESCRIPTION;
import static com.neuer.demo.util.constants.Constants.DATA_SERVICE_DESCRIPTION;

@Service
public class DataService implements BasicService {

    private static Logger log = LoggerFactory.getLogger(DataService.class.getName());

    @Autowired
    private DataDao dataDao;

    @Autowired
    private CategoryService categoryService;

    // Lists Historic data registers paginated
    public Page<Data> list(@PageableDefault(value = 5) Pageable pageable) {
        // Validation of the existence of the Pageable object
        if (pageable == null ) {
            log.error("Error found in DataService.list(Pageable pageable)");
            throw new InvalidInputException("Unable to create a list to show, there is no data");
        }
        Page<Data> listFound = dataDao.findAll(pageable);
        if(listFound == null) {
            log.error("Error found in DataService.list(Pageable pageable)");
            throw new NoDataFoundException("Unable to create a list to show, there is no data found");
        }
        return listFound;
    }

    public CategoryParsedResponse saveAll(List<Data> multipleDataRegisters) {
        if (multipleDataRegisters == null) {
            log.error("Error found in DataService.saveAll(List<Data> multipleDataRegisters)");
            throw new InvalidInputException("Unable to find multiple Data to save!");
        }
        //Validate the list
        List<Data> validList = categoryService.validateCategories(multipleDataRegisters);
        List<Data> savedData = dataDao.saveAll(validList);
        if(savedData == null) {
            log.error("Error found in DataService.saveAll(List<Data> multipleDataRegisters)");
            throw new UnableToSaveException("Unable to save data!");
        }

        //Do report of count of categories validated and persisted
        List<SavedCategoryCount> savedCategoriesReport = categoryService.calculateOcurrencies(validList);
        //Do the response to show to the client
        CategoryParsedResponse cpr = new CategoryParsedResponse(validList,savedCategoriesReport);
        return cpr;
    }

    @Override
    public String getServiceDescription() {
        return DATA_SERVICE_DESCRIPTION;
    }
}

package com.neuer.demo.controller;

import com.neuer.demo.model.entity.Data;
import com.neuer.demo.model.pojo.CategoryParsedResponse;
import com.neuer.demo.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

import java.util.List;

import static com.neuer.demo.util.constants.Constants.DATA_ROOT_PATH;

@RestController
@RequestMapping(DATA_ROOT_PATH)
public class DataController {

    @Autowired
    private DataService dataService;

    @GetMapping
    public Page<Data> list(@PageableDefault(value = 5) Pageable pageable) {
        return dataService.list(pageable);
    }

    @PostMapping
    public CategoryParsedResponse saveAll(@Valid @RequestBody List<Data> registers) {
        return dataService.saveAll(registers);
    }
}


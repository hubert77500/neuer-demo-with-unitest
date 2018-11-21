package com.neuer.demo.dao;

import com.neuer.demo.model.entity.Category;
import com.neuer.demo.model.entity.Data;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface CategoryDao extends JpaRepository<Category, Long> {
    // As it is does findAll(), findAll(Sort sort), findAllById(Iterable<ID> ids), getOne(ID id), among others and custom:
    @Query(value = "SELECT category_id FROM category WHERE category_name = ?1", nativeQuery = true)
    Long findIdByCategoryName(String category_name);
}

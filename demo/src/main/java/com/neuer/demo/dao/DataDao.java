package com.neuer.demo.dao;

import com.neuer.demo.model.entity.Data;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DataDao extends JpaRepository<Data, Long> {
    // As it is does findAll(), findAll(Sort sort), findAllById(Iterable<ID> ids), getOne(ID id), among others.
}

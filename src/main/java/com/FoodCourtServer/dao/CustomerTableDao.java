package com.FoodCourtServer.dao;

import com.FoodCourtServer.model.CustomerTable;
import org.springframework.data.repository.Repository;

import java.util.List;

/**
 * Created by bagus on 05/07/17.
 */
public interface CustomerTableDao extends Repository<CustomerTable, Long> {
    public List<CustomerTable> findAll();
}

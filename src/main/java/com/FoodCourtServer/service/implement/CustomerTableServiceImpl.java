package com.FoodCourtServer.service.implement;

import com.FoodCourtServer.dao.CustomerTableDao;
import com.FoodCourtServer.model.CustomerTable;
import com.FoodCourtServer.service.CustomerTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by bagus on 05/07/17.
 */
@Service("CustomerTableService")
public class CustomerTableServiceImpl implements CustomerTableService {
    @Autowired private CustomerTableDao customerTableDao;

    @Override
    public List<CustomerTable> getCustomerTables() {
        return customerTableDao.findAll();
    }
}

package com.FoodCourtServer.controller;

import com.FoodCourtServer.model.CustomerTable;
import com.FoodCourtServer.model.Tenant;
import com.FoodCourtServer.rest.CustomerTableWrapper;
import com.FoodCourtServer.service.CustomerTableService;
import com.FoodCourtServer.util.CustomErrorType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bagus on 05/07/17.
 */
@RestController
@RequestMapping("/table")
public class TableController {
    private static final Logger LOGGER = LoggerFactory.getLogger(TableController.class);

    @Autowired private CustomerTableService customerTableService;

    @RequestMapping(value = "/get-tables", method = RequestMethod.GET)
    ResponseEntity<?> getTables() {
        LOGGER.info("fetching Tables");

        List<CustomerTable> customerTables = customerTableService.getCustomerTables();
        List<CustomerTableWrapper> customerTableWrappers = new ArrayList<>();

        for (CustomerTable customerTable : customerTables) {
            customerTableWrappers.add(
                    new CustomerTableWrapper(
                            customerTable.getId(),
                            customerTable.getSector().charAt(0),
                            customerTable.getTableTotal()
                    )
            );
        }

        if (customerTables.isEmpty()) {
            LOGGER.error("Tables not found");

            return new ResponseEntity<>(new CustomErrorType("Tables not found"), HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(customerTableWrappers, HttpStatus.OK);

    }
}

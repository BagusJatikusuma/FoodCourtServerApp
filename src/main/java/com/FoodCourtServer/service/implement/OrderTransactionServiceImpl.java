/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.FoodCourtServer.service.implement;

import com.FoodCourtServer.model.Menu;
import com.FoodCourtServer.model.OrderTransaction;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.FoodCourtServer.service.OrderTransactionService;
import com.FoodCourtServer.dao.OrderTransactionDao;

/**
 *
 * @author bagus
 */
@Service("OrderTransactionService")
@Transactional
public class OrderTransactionServiceImpl implements OrderTransactionService {

    @Autowired
    private OrderTransactionDao transactionDao;
    
    @Override
    public void createTransaction(List<Menu> Menus) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateTransaction(OrderTransaction transaction) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

package com.FoodCourtServer.service.implement;

import com.FoodCourtServer.dao.ToppingDao;
import com.FoodCourtServer.model.Topping;
import com.FoodCourtServer.service.ToppingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by bagus on 03/07/17.
 */
@Service("ToppingService")
@Transactional
public class ToppingServiceImpl implements ToppingService {

    @Autowired
    private ToppingDao toppingDao;

    @Override
    @Transactional(readOnly = true)
    public List<Topping> getToppings() {
        return toppingDao.findAll();
    }

    @Override
    public void createTopping(Topping topping) {
        toppingDao.save(topping);
    }

    @Override
    public void editTopping(Topping topping) {
        toppingDao.save(topping);
    }

    @Override
    public void deleteTopping(String toppingId) {
        toppingDao.deleteById(toppingId);
    }
}

package com.FoodCourtServer.service;

import com.FoodCourtServer.model.Topping;
import org.springframework.data.repository.Repository;

import java.util.List;

/**
 * Created by bagus on 03/07/17.
 */
public interface ToppingService extends Repository<Topping, Long> {
    public List<Topping> getToppings();
    public void createTopping(Topping topping);
    public void editTopping(Topping topping);
    public void deleteTopping(String toppingId);

}

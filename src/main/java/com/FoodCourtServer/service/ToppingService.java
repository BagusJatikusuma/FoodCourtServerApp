package com.FoodCourtServer.service;

import com.FoodCourtServer.model.Topping;
import org.springframework.data.repository.Repository;

import java.security.PublicKey;
import java.util.List;

/**
 * Created by bagus on 03/07/17.
 */
public interface ToppingService {
    public List<Topping> getToppings();
    public Topping getToppingById(String toppingId);
    public void update(Topping topping);
    public void createTopping(Topping topping);
    public void editTopping(Topping topping);
    public void deleteTopping(String toppingId);
    public short getStockById(String toppingId);
}

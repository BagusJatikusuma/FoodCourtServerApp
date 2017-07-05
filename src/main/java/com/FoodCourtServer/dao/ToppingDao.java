package com.FoodCourtServer.dao;

import com.FoodCourtServer.model.Topping;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by bagus on 03/07/17.
 */
public interface ToppingDao extends Repository<Topping, Long> {
    public List<Topping> findAll();
    public void save(Topping topping);
    public void deleteById(String toppingId);

    @Query("select t.stock from Topping t where t.id = :id")
    public short getStockById(@Param("id") String toppingId);
}

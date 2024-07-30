package com.jensen.dao;

import com.jensen.pojo.Dish;
import org.apache.ibatis.annotations.Insert;

public interface DishMapper {

    @Insert("insert into dish values(null,#{name},#{price},#{description})")
    public void addDish(Dish dish);
}

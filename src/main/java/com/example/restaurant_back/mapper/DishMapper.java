package com.example.restaurant_back.mapper;

import com.example.restaurant_back.bean.Dish;
import com.example.restaurant_back.bean.DishExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DishMapper {
    long countByExample(DishExample example);

    int deleteByExample(DishExample example);

    int deleteByPrimaryKey(String name);

    int insert(Dish record);

    int insertSelective(Dish record);

    List<Dish> selectByExample(DishExample example);

    Dish selectByPrimaryKey(String name);

    int updateByExampleSelective(@Param("record") Dish record, @Param("example") DishExample example);

    int updateByExample(@Param("record") Dish record, @Param("example") DishExample example);

    int updateByPrimaryKeySelective(Dish record);

    int updateByPrimaryKey(Dish record);
}
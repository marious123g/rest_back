package com.example.restaurant_back.mapper;

import com.example.restaurant_back.bean.OrderDish;
import com.example.restaurant_back.bean.OrderDishExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderDishMapper {
    long countByExample(OrderDishExample example);

    int deleteByExample(OrderDishExample example);

    int insert(OrderDish record);

    int insertSelective(OrderDish record);

    List<OrderDish> selectByExample(OrderDishExample example);

    int updateByExampleSelective(@Param("record") OrderDish record, @Param("example") OrderDishExample example);

    int updateByExample(@Param("record") OrderDish record, @Param("example") OrderDishExample example);
}
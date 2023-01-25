package com.example.restaurant_back.bean;

public class DishSales
{
    private String name;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }


    public int getAmount()
    {
        return amount;
    }

    public void setAmount(int amount)
    {
        this.amount = amount;
    }

    private int amount;
    public void increaseAmount(int amount)
    {
        this.amount+=amount;
    }

}

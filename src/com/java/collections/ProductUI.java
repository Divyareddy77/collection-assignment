package com.java.collections;

public class ProductUI {
    public Product enterDetails(){
        int id= ProductUtil.getInt("Enter id : ");
        String name= ProductUtil.getString("Enter product name : ");
        int price= ProductUtil.getInt("Enter price : ");
        Product product=new Product(id,name,price);
        return product;
    }
}

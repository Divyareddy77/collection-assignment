package com.java.collections;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ProductRepositoryImpl productRepositoryImpl=new ProductRepositoryImpl();
        try {
            productRepositoryImpl.save(new Product(1, "Laptop", 90000));
            productRepositoryImpl.save(new Product(2, "Phone", 40000));
            productRepositoryImpl.save(new Product(3, "Tv", 50000));
            productRepositoryImpl.save(new Product(4, "AC", 10000));
            productRepositoryImpl.save(new Product(2, "Phone", 40000));
        }catch (ProductExistsException e){
        System.out.println(e.getMessage());
        }


            System.out.println("------------------------------------");
            System.out.println("Displaying all products(findAll)");
            productRepositoryImpl.findAll();

        try {
            Product productById = productRepositoryImpl.findById(1);
            System.out.println("------------------------------------");
            System.out.println("Displaying by Id(productById)");
            System.out.println(productById);
        }catch (ProductNotFoundException e){
        System.out.println(e.getMessage());
    }
    try {
        Product updatedProduct = new Product(1, "Laptop", 100000);
        Product product1 = productRepositoryImpl.update(updatedProduct);
        System.out.println("------------------------------------");
        System.out.println("Updating a product");
        System.out.println(product1);
    }catch (ProductNotFoundException e){
        System.out.println(e.getMessage());
    }

    try {
        productRepositoryImpl.delete(new Product(4, "AC", 10000));
        System.out.println("------------------------------------");
        System.out.println("Deleting a product and displaying remaining products");
        productRepositoryImpl.findAll();
    }catch (ProductNotFoundException e){
        System.out.println(e.getMessage());
    }


    try {
        System.out.println("------------------------------------");
        System.out.println("Deleting product by id");
        productRepositoryImpl.deleteById(3);
        productRepositoryImpl.findAll();
    } catch (ProductNotFoundException e){
            System.out.println(e.getMessage());
        }


    }
}

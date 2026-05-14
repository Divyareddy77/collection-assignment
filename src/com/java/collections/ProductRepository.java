package com.java.collections;

public interface ProductRepository {
    void save (Product newProduct) throws ProductExistsException;
    Product findById(int id) throws ProductNotFoundException;
    void findAll();
    Product update(Product product) throws ProductNotFoundException;
    void delete(Product product) throws ProductNotFoundException;
    void deleteById(int id) throws ProductNotFoundException;

}

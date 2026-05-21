package com.java.collections.assignment;

import java.util.List;

public interface ProductRepository {
    public List<Product> getAllProducts();
    public Product addProduct(Product product);
    public Product addProductById(int id);
    public Product updateProduct(Product product);
    public void deleteProduct(Product product);
    public void deleteById(int id);
    List<Product> getProductByCompany(String Company);
    List<Product> getProductsByCategory(String category);
    List<Product> getProductsByMinRating();
    List<Product> getProductsByMaxRating();
    List<Product> getProductsBetweenMinMaxRating();
    List<Product> getProductsWithinRangeAndCategory();
    List<Product> getByAvailabilityAndCategory(String category);

}

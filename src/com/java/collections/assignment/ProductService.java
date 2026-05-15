package com.java.collections.assignment;

import java.util.List;

public class ProductService {
    private List<Product> products;
    private csvReader csvReader;

    public ProductService(csvReader csvReader) {
        this.csvReader = csvReader;
        products = this.csvReader.getDataFromCsv();

    }

    public List<Product> getAllProducts() {
        return products;
    }

    public Product addProduct(Product product) {
        products.add(product);
        return product;
    }

    public Product addProductById(int id) {
        Product getProductById = null;
        for (Product product : products) {
            if (product.getId() == id) {
                getProductById = product;
            }
        }
        return getProductById;
    }

    public Product updateProduct(Product product) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == product.getId()) {
                products.set(i,product);
            }
        }
        return product;
    }

    public void deleteProduct(Product product) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId()==product.getId()) {
                products.remove(i);
            }
        }
    }
    public void deleteById(int id){
        for (int i = 0; i < products.size(); i++) {
            if(products.get(i).getId()==id){
                products.remove(i);

            }
        }
    }
}

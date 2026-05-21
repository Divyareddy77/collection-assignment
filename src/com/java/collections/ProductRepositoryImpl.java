package com.java.collections;

import java.util.ArrayList;
import java.util.List;

public class ProductRepositoryImpl implements ProductRepository {
    List<Product> productList = new ArrayList<>();

    @Override
    public void save(Product newProduct) throws ProductExistsException{
        for(Product product:productList){
            if(product.id==newProduct.id){
                throw new ProductExistsException("Product already exists");
            }
        }
        productList.add(newProduct);
    }

    @Override
    public Product findById(int id) throws ProductNotFoundException{
        for (Product product : productList) {
            if (product.id == id)
                return product;
        }
        throw new ProductNotFoundException("No product found");
    }

    @Override
    public void findAll() {
        for (Product product : productList) {
            System.out.println("-------------------");
            System.out.println("Id : " + product.id);
            System.out.println("Name : " + product.name);
            System.out.println("Price : " + product.price);
            System.out.println("-------------------");
        }

    }

    @Override
    public Product update(Product updatedProduct) throws ProductNotFoundException{
        for (Product product : productList) {
            if (product.id == updatedProduct.id) {
                product.price = updatedProduct.price;
                return product;
            }
        }
       throw new ProductNotFoundException("Product not found");
    }

    @Override
    public void delete(Product product) throws ProductNotFoundException{
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).equals(product)) {
                productList.remove(productList.get(i));
                return;
            }

        }
        throw new ProductNotFoundException("Product not found");
    }

    @Override
    public void deleteById(int id) throws ProductNotFoundException{
        for (Product product : productList) {
            if (product.id == id) {
                productList.remove(product);
                return;
            }

        }
        throw new ProductNotFoundException("Product not found");
    }

    @Override
    public Product getProductByCompany(String company) {
        for(Product product:productList){

        }
        return null;
    }
}

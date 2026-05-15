package com.java.collections.assignment;

public class Main {
    public static void main(String[] args) {
        csvReader csvReader=new csvReader();
        ProductService productService=new ProductService(csvReader);
        System.out.println(productService.getAllProducts());
        Product product=new Product();
        product.setId(51);
        product.setName("TV");
        product.setMaxRetailPrice(40000);
        product.setDiscountPercentage(5);
        product.setAvailable(true);
        product.setCompany("samsung");
        product.setCategory("Tv");
        product.setManufacturedYear(2026);
        productService.addProduct(product);
        System.out.println(productService.getAllProducts());
        productService.deleteProduct(product);
        System.out.println(productService.getAllProducts());
        productService.deleteById(50);
        System.out.println(productService.getAllProducts());
        Product product1=new Product();
        product1.setId(1);
        product1.setName("TV");
        product1.setMaxRetailPrice(40000);
        product1.setDiscountPercentage(5);
        product1.setAvailable(true);
        product1.setCompany("samsung");
        product1.setCategory("Tv");
        product1.setManufacturedYear(2026);
        productService.updateProduct(product1);
        System.out.println(productService.getAllProducts());

    }
}

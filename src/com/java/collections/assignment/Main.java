package com.java.collections.assignment;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        CsvReader csvReader=new CsvReader();
        ProductRepositoryImpl productService=new ProductRepositoryImpl(csvReader);
        System.out.println(productService.getAllProducts());
        System.out.println("-------------------------------------------------------------------------");
        Product product=new Product();
        product.setId(51);
        product.setName("TV");
        product.setMaxRetailPrice(40000);
        product.setDiscountPercentage(5);
        product.setAvailable(true);
        product.setCompany("samsung");
        product.setCategory("Tv");
        product.setManufacturedYear(2026);
        product.setRating(4.3f);
        productService.addProduct(product);
        System.out.println(productService.getAllProducts());
        System.out.println("--------------------------------------------------------------------------");
        productService.deleteProduct(product);
        System.out.println(productService.getAllProducts());
        System.out.println("-------------------------------------------------------------------------");
        productService.deleteById(50);
        System.out.println(productService.getAllProducts());
        System.out.println("-----------------------------------------------------------------------------");
        Product product1=new Product();
        product1.setId(1);
        product1.setName("TV");
        product1.setMaxRetailPrice(40000);
        product1.setDiscountPercentage(5);
        product1.setAvailable(true);
        product1.setCompany("samsung");
        product1.setCategory("Tv");
        product1.setManufacturedYear(2026);
        product1.setRating(4.3f);
        productService.updateProduct(product1);
        System.out.println(productService.getAllProducts());
        System.out.println("--------------------------------------------------------------------------------");
        List<Product> productByCompany = productService.getProductByCompany("Apple");
        System.out.println(productByCompany);
        List<Product> productBtCategory=productService.getProductsByCategory("electronics");
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println(productBtCategory);
        List<Product> minRatingProducts=productService.getProductsByMinRating();
        System.out.println("================================================================================");
        System.out.println(minRatingProducts);
        List<Product> maxRatingProducts=productService.getProductsByMaxRating();
        System.out.println("================================================================================");
        System.out.println(maxRatingProducts);
        List<Product> productsBetween=productService.getProductsBetweenMinMaxRating();
        System.out.println("==================================================================================");
        System.out.println(productsBetween);
        List<Product> rangeAndCategory=productService.getProductsWithinRangeAndCategory();
        System.out.println("==================================================================================");
        System.out.println(rangeAndCategory);
        List<Product> availabilityAndCategory=productService.getByAvailabilityAndCategory("Accessories");
        System.out.println("=====================================================================================");
        System.out.println(availabilityAndCategory);

    }
}

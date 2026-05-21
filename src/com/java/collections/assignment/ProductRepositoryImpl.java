package com.java.collections.assignment;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

public class ProductRepositoryImpl implements ProductRepository {
    private List<Product> products;
    private CsvReader csvReader;

    public ProductRepositoryImpl(CsvReader csvReader) {
        this.csvReader = csvReader;
        products = this.csvReader.getDataFromCsv();

    }

    @Override
    public List<Product> getAllProducts() {
        return products;
    }

    @Override
    public Product addProduct(Product product) {
        products.add(product);
        return product;
    }

    @Override
    public Product addProductById(int id) {
        Product getProductById = null;
        for (Product product : products) {
            if (product.getId() == id) {
                getProductById = product;
            }
        }
        return getProductById;
    }

    @Override
    public Product updateProduct(Product product) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == product.getId()) {
                products.set(i, product);
            }
        }
        return product;
    }

    @Override
    public void deleteProduct(Product product) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == product.getId()) {
                products.remove(i);
            }
        }
    }

    @Override
    public void deleteById(int id) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == id) {
                products.remove(i);

            }
        }
    }

    @Override
    public List<Product> getProductByCompany(String company) {
        List<Product> companyProducts = new ArrayList<>();
        for (Product product : products)
            if (product.getCompany().equalsIgnoreCase(company))
                companyProducts.add(product);
        return companyProducts;
    }

    @Override
    public List<Product> getProductsByCategory(String category) {
        List<Product> categoryProducts = new ArrayList<>();
        for (Product product : products) {
            if (product.getCategory().equalsIgnoreCase(category))
                categoryProducts.add(product);


        }

        return categoryProducts;
    }

    @Override
    public List<Product> getProductsByMinRating() {
        List<Product> minRatingProducts=new ArrayList<>();
        for (Product product:products)
            if(product.getRating()==getMinRating())
                minRatingProducts.add(product);
        return minRatingProducts;
    }

    @Override
    public List<Product> getProductsByMaxRating() {
        List<Product> maxRatingProducts=new ArrayList<>();
        for (Product product:products)
            if(product.getRating()==getMaxRating())
                maxRatingProducts.add(product);
        return maxRatingProducts;
    }

    @Override
    public List<Product> getProductsBetweenMinMaxRating() {
        List<Product> productsBetween=new ArrayList<>();
        for(Product product : products){
            if(product.getRating()>getMinRating() && product.getRating()<getMaxRating())
                productsBetween.add(product);
        }
        return productsBetween;
    }

    @Override
    public List<Product> getProductsWithinRangeAndCategory() {
        List<Product> rangeAndCategory = new ArrayList<>();
        for (Product product : products) {
            double price=product.getMaxRetailPrice()-((double) (product.getMaxRetailPrice() * product.getDiscountPercentage()) /100);
            if (price> 10000 && price<60000 && product.getCategory().equalsIgnoreCase("electronics"))
                rangeAndCategory.add(product);

        }
        return rangeAndCategory;
    }

    @Override
    public List<Product> getByAvailabilityAndCategory(String category) {
        List<Product> availabilityAndCategory=new ArrayList<>();
        for (Product product: products) {
            if (product.getCategory().equalsIgnoreCase(category) && product.isAvailable())
                availabilityAndCategory.add(product);
        }
        return availabilityAndCategory;
    }


    public float getMinRating() {
        float minRating=products.getFirst().getRating();
        for(Product product:products)
            if(product.getRating()<minRating)
                minRating=product.getRating();
        return minRating;
        }
    public float getMaxRating() {
        float maxRating=products.getFirst().getRating();
        for(Product product:products)
            if(product.getRating()>maxRating)
                maxRating=product.getRating();
        return maxRating;
    }





}

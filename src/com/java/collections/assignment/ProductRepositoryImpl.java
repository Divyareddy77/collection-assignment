package com.java.collections.assignment;

import java.security.PublicKey;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
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

    //Date and Time Practice

    /*public void dateOfProductManufactured() {
        LocalDate localDate = LocalDate.now();
        System.out.println("Manufactured Date : " + localDate);
        LocalDate Date = LocalDate.of(2026, 6, 26);
        System.out.println("Date : " + Date);
        for (Product product : products) {
            if (product.getManufacturedYear() < LocalDate.now().getYear())
                System.out.println(product + "old stock");
        }
        LocalTime localTime = LocalTime.now();
        LocalTime orderTime = LocalTime.of(14, 30);
        System.out.println(localTime);
        System.out.println(orderTime);
        LocalDateTime orderPlaced = LocalDateTime.now();
        System.out.println("Order placed at " + orderPlaced);
        if (orderPlaced.getHour() > 11) {
            System.out.println("Next day delivery");
        }
        ZonedDateTime indiaTime = ZonedDateTime.now();
        System.out.println("India time " + indiaTime);
        ZonedDateTime usTime = ZonedDateTime.now((ZoneId.of("America/New_York")));
        System.out.println("US time :" + usTime);


        LocalDate orderDate = LocalDate.of(2026, 5, 20);
        LocalDate today = LocalDate.now();
        Period period = Period.between(orderDate, today);
        System.out.println(period.getDays());
        if (period.getDays() > 5)
            System.out.println("DElayed delivery");

        LocalTime start = LocalTime.now();
        LocalTime end = start.plusHours(5);
        Duration duration = Duration.between(start, end);
        System.out.println(duration.toHours());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String formattedDate = LocalDate.now().format(formatter);
        System.out.println(formattedDate);
        LocalDate date = LocalDate.parse("2026-05-26");
        System.out.println(date);
        System.out.println(date.getYear());
        System.out.println(date.getMonth());
        System.out.println(date.getDayOfMonth());
        LocalDate deliveryDate = LocalDate.now().plusDays(4);
        System.out.println("Delivery date :" + deliveryDate);
        LocalDate oldDate = LocalDate.now().minusDays(3);
        System.out.println("OLd date :" + oldDate);
        if (deliveryDate.isAfter(LocalDate.now()))
            System.out.println("upcoming delivery");
        if (oldDate.isBefore(LocalDate.now()))
            System.out.println("Early delivery");

        for (Product product : products) {
            int age = Period.between(LocalDate.of(product.getManufacturedYear(),1,1),LocalDate.now()).getYears();
            if(age>4)
                System.out.println(product+"Old stock");

        }
    }*/





}

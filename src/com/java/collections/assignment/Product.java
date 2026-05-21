package com.java.collections.assignment;

import java.util.Objects;

public class Product {
    private int id;
    private String name;
    private int maxRetailPrice;
    private int discountPercentage;
    private boolean isAvailable;
    private String company;
    private String category;
    private int manufacturedYear;
    private float rating;

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public Product() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxRetailPrice() {
        return maxRetailPrice;
    }

    public void setMaxRetailPrice(int maxRetailPrice) {
        this.maxRetailPrice = maxRetailPrice;
    }

    public int getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(int discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getManufacturedYear() {
        return manufacturedYear;
    }

    public void setManufacturedYear(int manufacturedYear) {
        this.manufacturedYear = manufacturedYear;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id && maxRetailPrice == product.maxRetailPrice && discountPercentage == product.discountPercentage && isAvailable == product.isAvailable && manufacturedYear == product.manufacturedYear && Objects.equals(name, product.name) && Objects.equals(company, product.company) && Objects.equals(category, product.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, maxRetailPrice, discountPercentage, isAvailable, company, category, manufacturedYear);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", maxRetailPrice=" + maxRetailPrice +
                ", discountPercentage=" + discountPercentage +
                ", isAvailable=" + isAvailable +
                ", company='" + company + '\'' +
                ", category='" + category + '\'' +
                ", manufacturedYear=" + manufacturedYear +
                ", rating=" + rating +
                '}';
    }
}

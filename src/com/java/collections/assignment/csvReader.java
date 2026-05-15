package com.java.collections.assignment;

import com.sun.source.tree.BreakTree;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class csvReader {
    public List<Product> getDataFromCsv(){
        List<Product> products=new ArrayList<>();
        try{
            BufferedReader br=new BufferedReader(new FileReader("C://java workspace//products.csv"));
            br.readLine();
            String productData=br.readLine();
            while(productData!=null){
                String[] data=productData.split(",");
                Product product=new Product();
                product.setId(Integer.parseInt(data[0]));
                product.setName(data[1]);
                product.setMaxRetailPrice(Integer.parseInt(data[2]));
                product.setDiscountPercentage(Integer.parseInt(data[3]));
                product.setAvailable(Boolean.parseBoolean(data[4]));
                product.setCompany(data[5]);
                product.setCategory(data[6]);
                product.setManufacturedYear(Integer.parseInt(data[7]));
                products.add(product);
                productData=br.readLine();
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return products;
    }

}

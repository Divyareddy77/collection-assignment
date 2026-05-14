package com.java.collections;

import java.util.Scanner;

public class ProductUtil {
    private static Scanner scanner=new Scanner(System.in);
    public static int getInt(String message){
        System.out.println(message);
        return scanner.nextInt();

    }
    public static String getString(String message){
        System.out.println(message);
        return scanner.next();
    }
}

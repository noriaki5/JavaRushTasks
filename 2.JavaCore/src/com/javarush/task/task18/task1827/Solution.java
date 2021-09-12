package com.javarush.task.task18.task1827;


import java.io.*;
import java.util.*;

/* 
Прайсы
*/

public class Solution {


    public static void main(String[] args) throws Exception {
        ArrayList<Product> products = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String filename = bufferedReader.readLine();
        if (args.length == 0) return;
        switch (args[0]) {
            case "-c": {
                BufferedReader fileReader = new BufferedReader(new FileReader(filename));
                while (fileReader.ready()) {
                    String str = fileReader.readLine();
                    Product product = new Product(str);
                    products.add(product);
                }
                fileReader.close();
                int maxId = products.stream().mapToInt(Product::getId).max().orElseThrow(NoSuchElementException::new);
                int newId = maxId + 1;
                StringBuilder strNewProduct = new StringBuilder();
                for (int i = 1; i < args.length-2; i++) {
                    strNewProduct.append(args[i]).append(" ");
                }
                Product newProduct = new Product(newId, strNewProduct.toString(), args[args.length-2], args[args.length-1]);
                products.add(newProduct);
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filename));
                for (Product product : products) {
                    bufferedWriter.write(product.getInfo());
                }
                bufferedWriter.close();
            }
        }
        bufferedReader.close();
    }

    public static class Product {
        private int id;
        private String productName;
        private double price;
        private int quantity;

        public Product(String str) {
            this.id = Integer.parseInt(str.substring(0, 8).trim());
            this.productName = str.substring(8, 38).trim();
            this.price = Double.parseDouble(str.substring(38, 46).trim());
            this.quantity = Integer.parseInt(str.substring(46, 50).trim());
        }

        public Product(int id, String productName, String price, String quantity) {
            this.id = id;
            this.productName = productName.trim();
            this.price = Double.parseDouble(price.trim());
            this.quantity = Integer.parseInt(quantity.trim());
//            this.productName = str.substring(0, 30).trim();
//            this.price = Double.parseDouble(str.substring(30, 38).trim());
//            this.quantity = Integer.parseInt(str.substring(38, 42).trim());
        }

        public String getInfo() {
            return String.format(Locale.ENGLISH,"%-8d%-30s%-8.2f%-4d\n", id, productName, price, quantity);
        }

        public int getId() {
            return this.id;
        }
    }
}

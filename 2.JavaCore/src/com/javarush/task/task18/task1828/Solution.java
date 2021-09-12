package com.javarush.task.task18.task1828;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.NoSuchElementException;

/* 
Прайсы 2
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        if (args.length == 0) return;

        ArrayList<Product> products = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String filename = bufferedReader.readLine();
        BufferedReader fileReader = new BufferedReader(new FileReader(filename));
        while (fileReader.ready()) {
            String str = fileReader.readLine();
            Product product = new Product(str);
            products.add(product);
        }
        fileReader.close();

        switch (args[0]) {
            case "-c": {
                int maxId = products.stream().mapToInt(Product::getId).max().orElseThrow(NoSuchElementException::new);
                int newId = maxId + 1;
                StringBuilder strNewProduct = new StringBuilder();
                for (int i = 1; i < args.length-2; i++) {
                    strNewProduct.append(args[i]).append(" ");
                }
                Product newProduct = new Product(newId, strNewProduct.toString(), args[args.length-2], args[args.length-1]);
                products.add(newProduct);
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filename, true));
                bufferedWriter.write(newProduct.getInfo());
                bufferedWriter.write("\n");
//                for (Product product : products) {
//                    bufferedWriter.write(product.getInfo());
//                }
                bufferedWriter.close();
                break;
            }
            case "-u": {
                int id = Integer.parseInt(args[1]);
                StringBuilder strUpdateProduct = new StringBuilder();
                for (int i = 2; i < args.length-2; i++) {
                    strUpdateProduct.append(args[i]).append(" ");
                }
                double price = Double.parseDouble(args[args.length-2].trim());
                int quantity = Integer.parseInt(args[args.length-1].trim());
                Product productForUpdate = products.stream().filter(product -> product.getId()==id).findFirst().orElseThrow(NoSuchElementException::new);
                productForUpdate.setProductName(strUpdateProduct.toString().trim());
                productForUpdate.setPrice(price);
                productForUpdate.setQuantity(quantity);
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filename));
                for (Product product : products) {
                    bufferedWriter.write(product.getInfo());
                    bufferedWriter.write("\n");
                }
                bufferedWriter.close();
                break;
            }
            case "-d": {
                int id = Integer.parseInt(args[1]);
                //Product deleteProduct = products.stream().filter(product -> product.getId()==id).findFirst().orElseThrow(NoSuchElementException::new);
                products.removeIf(product -> product.getId()==id);
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filename));
                for (Product product : products) {
                    bufferedWriter.write(product.getInfo());
                    bufferedWriter.write("\n");
                }
                bufferedWriter.close();
                break;
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
            return String.format(Locale.ENGLISH,"%-8d%-30s%-8.2f%-4d", id, productName, price, quantity);
        }

        public int getId() {
            return this.id;
        }

        public String getProductName() {
            return productName;
        }

        public void setProductName(String productName) {
            this.productName = productName;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }
    }
}

package org.example;

import java.util.*;

 public class Main {
     static HashMap<String, Integer> map = new HashMap<>();

     public static String addProduct(String name, int quantity) {
         if (map.containsKey(name)) {
             return "Product already exists in the inventory. Please use update stock.";
         } else {
             map.put(name, quantity);
             return "Product added!";
         }
     }

     public static String checkProduct(String name) {
         if(map.containsKey(name)) {
             return name + " is in stock: " + map.get(name);
         } else {
             return "Product is not in stock.";
         }
     }

     public static String updateProduct(String name, int newQuantity) {
         if(map.containsKey(name)) {
             map.put(name, newQuantity);
             return "Stock updated!";
         } else {
             return "Product is not in the inventory.";
         }
     }

     public static String removeProduct(String name) {
         if(map.containsKey(name)) {
             map.remove(name);
             return "Product removed.";
         } else {
             return "Product is not in the inventory.";
         }
     }

     public static void viewInventory() {
         for(Map.Entry<String, Integer> entry : map.entrySet()) {
             System.out.println(entry.getKey() + " - " + entry.getValue() + "pcs");
         }
     }

     public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("\n--- Grocery Inventory Menu ---");
            System.out.println("1. View Inventory");
            System.out.println("2. Add Product");
            System.out.println("3. Check Product");
            System.out.println("4. Update Stock");
            System.out.println("5. Remove Product");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            option = scanner.nextInt();
            scanner.nextLine();

            switch(option) {
                case 1: {
                    System.out.println("\n--- View Inventory ---");
                    System.out.println("Current Inventory: ");
                    viewInventory();
                    break;
                }
                case 2: {
                    System.out.println("\n--- Add Product ---");
                    System.out.print("Enter product name: ");
                    String productName = scanner.nextLine();
                    System.out.print("Enter quantity: ");
                    int productQuantity = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println(addProduct(productName, productQuantity));
                    break;
                }
                case 3: {
                    System.out.println("\n--- Check Product ---");
                    System.out.print("Enter product name to check: ");
                    String productName = scanner.nextLine();
                    System.out.println(checkProduct(productName));
                    break;
                }
                case 4: {
                    System.out.println("\n--- Update Stock ---");
                    System.out.print("Enter product name to update: ");
                    String productName = scanner.nextLine();
                    System.out.print("Enter new stock quantity: ");
                    int productQuantity = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println(updateProduct(productName, productQuantity));
                    break;
                }
                case 5: {
                    System.out.println("\n--- Remove Product ---");
                    System.out.print("Enter name of product to remove: ");
                    String productName = scanner.nextLine();
                    System.out.println(removeProduct(productName));
                    break;
                }
                case 6: {
                    System.out.println("Exiting System...");
                    break;
                }
                default: {
                    System.out.println("Not a valid choice. Try again.");
                }
            }
        } while (option != 6);
     }
}
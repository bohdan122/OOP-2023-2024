package src;

import java.util.ArrayList;

public class Main {

    public abstract static class Product {
        private String name;
        private double price;

        public Product(String name, double price) {
            this.name = name;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public double getPrice() {
            return price;
        }

        public abstract double getDiscount();
    }

    public static class FoodProduct extends Product {
        public FoodProduct(String name, double price) {
            super(name, price);
        }

        @Override
        public double getDiscount() {
            return 0;
        }
    }

    public static class ElectronicsProduct extends Product {
        public ElectronicsProduct(String name, double price) {
            super(name, price);
        }

        @Override
        public double getDiscount() {
            return getPrice() * 0.15;
        }
    }

    public static class ShoppingCart {
        private ArrayList<Product> products;
        private double total;

        public ShoppingCart() {
            products = new ArrayList<>();
            total = 0;
        }

        public void addProduct(Product product) {
            products.add(product);
            total += product.getPrice();
        }

        public double calculateTotalDiscount() {
            double totalDiscount = 0;
            for (Product product : products) {
                totalDiscount += product.getDiscount();
            }
            return totalDiscount;
        }

        public void displayCart() {
            System.out.println("Shopping Cart:");
            for (Product product : products) {
                double discount = product.getDiscount();
                System.out.println(product.getName() + ": $" + product.getPrice() + " (Discount: $" + discount + ")");
            }
            double totalDiscount = calculateTotalDiscount();
            double finalTotal = total - totalDiscount;
            System.out.println("Total price: $" + total);
            System.out.println("Total discount: $" + totalDiscount);
            System.out.println("Final total: $" + finalTotal);
        }
    }

    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        FoodProduct apple = new FoodProduct("Apple", 1.25);
        FoodProduct banana = new FoodProduct("Banana", 0.75);
        ElectronicsProduct laptop = new ElectronicsProduct("Laptop", 999.99);
        ElectronicsProduct smartphone = new ElectronicsProduct("Smartphone", 799.99);

        cart.addProduct(apple);
        cart.addProduct(laptop);
        cart.addProduct(smartphone);

        cart.displayCart();
    }
}

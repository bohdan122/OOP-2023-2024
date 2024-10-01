package src;

public class Main {
    public static void main(String[] args) {
        String[] productNames = { "Apple", "Banana", "Orange", "Laptop", "Smartphone" };
        double[] prices = { 1.25, 0.75, 1.50, 999.99, 799.99 };
        boolean[] isFood = { true, true, true, false, false };
        double total = 0;

        System.out.println("Available products:");
        for (int i = 0; i < productNames.length; i++) {
            System.out.println(productNames[i] + ": $" + prices[i] + " (Food: " + isFood[i] + ")");
        }

        System.out.println("User buys: Apple, Laptop and Smartphone");
        total += prices[0];
        total += prices[3];
        total += prices[4];

        System.out.println("Total price: $" + total);

        double electronicsDiscount = 0;
        if (!isFood[3]) {
            electronicsDiscount += prices[3] * 0.15;
        }
        if (!isFood[4]) {
            electronicsDiscount += prices[4] * 0.15;
        }

        total -= electronicsDiscount;
        System.out.println("Electronics discount: $" + electronicsDiscount);
        System.out.println("Final total: $" + total);
    }
}
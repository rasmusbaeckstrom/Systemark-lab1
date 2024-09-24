package org.example;

public class Main {
    public static void main(String[] args) {
        Product milk = new Product("milk", 20.0, 5);
        Product bread = new Product("bread", 15.0, 5);

        Discount discountChain = new FridayDiscount(new MilkDiscount(new QuantityDiscount(null)));

        double milkDiscount = discountChain.apply(milk);
        double milkTotalPrice = milk.price() * milk.quantity() - milkDiscount;

        System.out.println("Milk discount: " + milkDiscount + " SEK");
        System.out.println("Milk total price after discount: " + milkTotalPrice + " SEK");
        System.out.println("Milk description:\n" + discountChain.getDescription(milk));

        double breadDiscount = discountChain.apply(bread);
        double breadTotalPrice = bread.price() * bread.quantity() - breadDiscount;

        System.out.println("Bread discount: " + breadDiscount);
        System.out.println("Bread total price after discount: " + breadTotalPrice);
        System.out.println("Bread description:\n" + discountChain.getDescription(bread));
    }
}
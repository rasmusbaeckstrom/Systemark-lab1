package org.example;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Product milk = new Product("milk", 20.0, 5);
        Product bread = new Product("bread", 15.0, 5);

        Discount fridayDiscount = new BaseDiscount(
                product -> LocalDate.now().getDayOfWeek() == DayOfWeek.FRIDAY,
                product -> product.price() * 0.10 * product.quantity(),
                "10% off on Fridays",
                null
        );

        Discount milkDiscount = new BaseDiscount(
                product -> product.name().equalsIgnoreCase("milk"),
                product -> product.price() * 0.05 * product.quantity(),
                "5% off on milk",
                fridayDiscount
        );

        Discount quantityDiscount = new BaseDiscount(
                product -> product.quantity() >= 5,
                product -> 10.0 * product.quantity(),
                "10 SEK off per product for 5 or more items",
                milkDiscount
        );

        double milkDiscountValue = quantityDiscount.apply(milk);
        double milkTotalPrice = milk.price() * milk.quantity() - milkDiscountValue;

        System.out.println("Milk discount: " + milkDiscountValue + " SEK");
        System.out.println("Milk total price after discount: " + milkTotalPrice + " SEK");
        System.out.println("Milk description:\n" + quantityDiscount.getDescription(milk));

        double breadDiscountValue = quantityDiscount.apply(bread);
        double breadTotalPrice = bread.price() * bread.quantity() - breadDiscountValue;

        System.out.println("Bread discount: " + breadDiscountValue);
        System.out.println("Bread total price after discount: " + breadTotalPrice);
        System.out.println("Bread description:\n" + quantityDiscount.getDescription(bread));
    }
}
package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BaseDiscountTest {

    @Test
    public void testFridayDiscount() {
        Product product = new Product("milk", 20.0, 5);
        Discount fridayDiscount = new BaseDiscount(
                p -> true, // Simulate it's Friday
                p -> p.price() * 0.10 * p.quantity(),
                "10% off on Fridays",
                null
        );

        double discountValue = fridayDiscount.apply(product);
        assertEquals(10.0, discountValue);
    }

    @Test
    public void testNoFridayDiscount() {
        Product product = new Product("milk", 20.0, 5);
        Discount fridayDiscount = new BaseDiscount(
                p -> false, // Simulate it's not Friday
                p -> p.price() * 0.10 * p.quantity(),
                "10% off on Fridays",
                null
        );

        double discountValue = fridayDiscount.apply(product);
        assertEquals(0.0, discountValue);
    }

    @Test
    public void testMilkDiscount() {
        Product product = new Product("milk", 20.0, 5);
        Discount milkDiscount = new BaseDiscount(
                p -> p.name().equalsIgnoreCase("milk"),
                p -> p.price() * 0.05 * p.quantity(),
                "5% off on milk",
                null
        );

        double discountValue = milkDiscount.apply(product);
        assertEquals(5.0, discountValue);
    }

    @Test
    public void testNoMilkDiscount() {
        Product product = new Product("bread", 20.0, 5);
        Discount milkDiscount = new BaseDiscount(
                p -> p.name().equalsIgnoreCase("milk"),
                p -> p.price() * 0.05 * p.quantity(),
                "5% off on milk",
                null
        );

        double discountValue = milkDiscount.apply(product);
        assertEquals(0.0, discountValue);
    }

    @Test
    public void testFridayDiscountDescription() {
        Product product = new Product("milk", 20.0, 5);
        Discount fridayDiscount = new BaseDiscount(
                p -> true, // Simulate it's Friday
                p -> p.price() * 0.10 * p.quantity(),
                "10% off on Fridays",
                null
        );

        String description = fridayDiscount.getDescription(product);
        assertEquals("10% off on Fridays", description);
    }

    @Test
    public void testNoFridayDiscountDescription() {
        Product product = new Product("milk", 20.0, 5);
        Discount fridayDiscount = new BaseDiscount(
                p -> false, // Simulate it's not Friday
                p -> p.price() * 0.10 * p.quantity(),
                "10% off on Fridays",
                null
        );

        String description = fridayDiscount.getDescription(product);
        assertEquals("", description);
    }

    @Test
    public void testMilkDiscountDescription() {
        Product product = new Product("milk", 20.0, 5);
        Discount milkDiscount = new BaseDiscount(
                p -> p.name().equalsIgnoreCase("milk"),
                p -> p.price() * 0.05 * p.quantity(),
                "5% off on milk",
                null
        );

        String description = milkDiscount.getDescription(product);
        assertEquals("5% off on milk", description);
    }

    @Test
    public void testNoMilkDiscountDescription() {
        Product product = new Product("bread", 20.0, 5);
        Discount milkDiscount = new BaseDiscount(
                p -> p.name().equalsIgnoreCase("milk"),
                p -> p.price() * 0.05 * p.quantity(),
                "5% off on milk",
                null
        );

        String description = milkDiscount.getDescription(product);
        assertEquals("", description);
    }

    @Test
    public void testChainedDiscounts() {
        Product product = new Product("milk", 20.0, 5);
        Discount milkDiscount = new BaseDiscount(
                p -> p.name().equalsIgnoreCase("milk"),
                p -> p.price() * 0.05 * p.quantity(),
                "5% off on milk",
                new BaseDiscount(
                        p -> true, // Simulate it's Friday
                        p -> p.price() * 0.10 * p.quantity(),
                        "10% off on Fridays",
                        null
                )
        );

        double discountValue = milkDiscount.apply(product);
        assertEquals(15.0, discountValue);

        String description = milkDiscount.getDescription(product);
        assertEquals("5% off on milk\n10% off on Fridays", description);
    }
}
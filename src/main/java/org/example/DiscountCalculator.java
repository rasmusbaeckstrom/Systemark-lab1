package org.example;

@FunctionalInterface
public interface DiscountCalculator {
    double calculateDiscount(Product product);
}
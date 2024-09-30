package org.example;

@FunctionalInterface
public interface DiscountCondition {
    boolean isApplicable(Product product);
}

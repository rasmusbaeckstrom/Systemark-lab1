package org.example;

public class BaseDiscount implements Discount {
    private final DiscountCondition condition;
    private final DiscountCalculator calculator;
    private final String description;
    private final Discount nextDiscount;

    public BaseDiscount(DiscountCondition condition, DiscountCalculator calculator, String description, Discount nextDiscount) {
        this.condition = condition;
        this.calculator = calculator;
        this.description = description;
        this.nextDiscount = nextDiscount;
    }

    @Override
    public double apply(Product product) {
        double discount = 0;
        if (condition.isApplicable(product)) {
            discount += calculator.calculateDiscount(product);
        }
        if (nextDiscount != null) {
            discount += nextDiscount.apply(product);
        }
        return discount;
    }

    @Override
    public String getDescription(Product product) {
        StringBuilder descriptionBuilder = new StringBuilder();
        if (condition.isApplicable(product)) {
            descriptionBuilder.append(description).append("\n");
        }
        if (nextDiscount != null) {
            descriptionBuilder.append(nextDiscount.getDescription(product)).append("\n");
        }
        return descriptionBuilder.toString().trim();
    }
}
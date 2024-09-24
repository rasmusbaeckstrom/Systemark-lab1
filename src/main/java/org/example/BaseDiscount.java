package org.example;

abstract class BaseDiscount implements Discount {
    Discount nextDiscount;

    public BaseDiscount(Discount nextDiscount) {
        this.nextDiscount = nextDiscount;
    }

    protected abstract boolean isApplicable(Product product);

    protected abstract double calculateDiscount(Product product);

    @Override
    public double apply(Product product) {
        double discount = 0;
        if (isApplicable(product)) {
            discount += calculateDiscount(product);
        }
        if (nextDiscount != null) {
            discount += nextDiscount.apply(product);
        }
        return discount;
    }

    @Override
    public String getDescription(Product product) {
        StringBuilder description = new StringBuilder();
        if (isApplicable(product)) {
            description.append(getClass().getSimpleName()).append(": ").append(getSpecificDescription()).append("\n");
        }
        if (nextDiscount != null) {
            description.append(nextDiscount.getDescription(product)).append("\n");
        }
        return description.toString().trim();
    }

    protected abstract String getSpecificDescription();
}
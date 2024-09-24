package org.example;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class FridayDiscount extends BaseDiscount {

    public FridayDiscount(Discount nextDiscount) {
        super(nextDiscount);
    }

    @Override
    protected boolean isApplicable(Product product) {
        return LocalDate.now().getDayOfWeek() == DayOfWeek.FRIDAY;
    }

    @Override
    protected double calculateDiscount(Product product) {
        return product.price() * 0.10 * product.quantity();
    }

    @Override
    protected String getSpecificDescription() {
        return "10% off on Fridays";
    }
}
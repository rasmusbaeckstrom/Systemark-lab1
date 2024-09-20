package org.example;

abstract class BaseDiscount implements Discount {
    protected abstract boolean isApplicable(Product product);

    protected abstract double calculateDiscount(Product product);

    // Klassen behöver även ett fält av typen Discount som lagrar nästa rabbat i kedjan av rabatter och sätts via konstruktorn.

    Discount nextDiscount;
}

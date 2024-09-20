package org.example;

public interface Discount {
    void apply(Product product);

    void getDescription(Product product);
}

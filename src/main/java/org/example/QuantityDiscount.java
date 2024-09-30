//package org.example;
//
//public class QuantityDiscount extends BaseDiscount {
//
//    public QuantityDiscount(Discount nextDiscount) {
//        super(nextDiscount);
//    }
//
//    @Override
//    protected boolean isApplicable(Product product) {
//        return product.quantity() >= 5;
//    }
//
//    @Override
//    protected double calculateDiscount(Product product) {
//        return 10.0 * product.quantity();
//    }
//
//    @Override
//    protected String getSpecificDescription() {
//        return "10 SEK off per product for 5 or more items";
//    }
//}
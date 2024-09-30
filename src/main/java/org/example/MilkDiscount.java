//package org.example;
//
//public class MilkDiscount extends BaseDiscount {
//
//    public MilkDiscount(Discount nextDiscount) {
//        super(nextDiscount);
//    }
//
//    @Override
//    protected boolean isApplicable(Product product) {
//        return product.name().equalsIgnoreCase("milk");
//    }
//
//    @Override
//    protected double calculateDiscount(Product product) {
//        return product.price() * 0.05 * product.quantity();
//    }
//
//    @Override
//    protected String getSpecificDescription() {
//        return "5% off on milk";
//    }
//}
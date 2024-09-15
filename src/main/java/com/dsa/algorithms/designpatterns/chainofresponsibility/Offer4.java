package com.dsa.algorithms.designpatterns.chainofresponsibility;

public class Offer4 extends OfferHandler {
    @Override
    public void applyOffer(Order order) {
        if(order.getCost()>25 && order.getItemCategories().contains("GROCERIES")) {
            order.setOfferType("OFFER 4");
            System.out.println(order.getOfferType() + " applied to " + order.getOrderId());
        }
        else if (nextOfferHandler!=null) {
            nextOfferHandler.applyOffer(order);
        }
    }
}

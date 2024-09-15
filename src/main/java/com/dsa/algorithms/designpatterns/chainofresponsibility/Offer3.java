package com.dsa.algorithms.designpatterns.chainofresponsibility;

public class Offer3 extends OfferHandler {

    @Override
    public void applyOffer(Order order) {
        if(order.getIsPrimeUser() && order.getItemCategories().contains("GROCERIES")) {
            order.setOfferType("OFFER 3");
            System.out.println(order.getOfferType() + " applied to " + order.getOrderId());
        }
        else if (nextOfferHandler!=null) {
            nextOfferHandler.applyOffer(order);
        }
    }
}

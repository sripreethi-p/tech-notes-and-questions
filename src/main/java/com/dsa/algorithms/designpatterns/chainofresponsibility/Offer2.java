package com.dsa.algorithms.designpatterns.chainofresponsibility;

public class Offer2 extends OfferHandler {

    @Override
    public void applyOffer(Order order) {
        if(order.getIsPrimeUser()) {
            order.setOfferType("OFFER 2");
            System.out.println(order.getOfferType() + " applied to " + order.getOrderId());
        }
        else if (nextOfferHandler!=null) {
            nextOfferHandler.applyOffer(order);
        }
    }
}

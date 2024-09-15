package com.dsa.algorithms.designpatterns.chainofresponsibility;

public class Offer1 extends OfferHandler {

    @Override
    public void applyOffer(Order order) {
        if(order.cost> 200 && order.isPrimeUser) {
            order.setOfferType("OFFER 1");
            System.out.println(order.getOfferType() + " applied to " + order.getOrderId());
        }
        else if(nextOfferHandler!=null) {
            nextOfferHandler.applyOffer(order);
        }
    }
}

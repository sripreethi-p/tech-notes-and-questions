package com.dsa.algorithms.designpatterns.chainofresponsibility;

public abstract class OfferHandler {

    // protected and not private because we want the subclasses to be able to access it
    protected OfferHandler nextOfferHandler;
    public void setNextOfferHandler(OfferHandler nextOfferHandler) {
        this.nextOfferHandler = nextOfferHandler;
    }
    public abstract void applyOffer(Order order);

}

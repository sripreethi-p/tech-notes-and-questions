package com.dsa.algorithms.designpatterns.chainofresponsibility;

import java.util.List;

public class ChainOfResponsibility {

    public static void main(String[] args) {

        // Initiate offers
        OfferHandler offer1 = new Offer1();
        OfferHandler offer2 = new Offer2();
        OfferHandler offer3 = new Offer3();
        OfferHandler offer4 = new Offer4();

        // Set up the chain
        offer1.setNextOfferHandler(offer2);
        offer2.setNextOfferHandler(offer3);
        offer3.setNextOfferHandler(offer4);


        Order order1 = new Order("1", 30, List.of("GROCERIES"), true, null);
        Order order2 = new Order("2", 30, List.of("GROCERIES"), false, null);

        offer1.applyOffer(order1);
        offer1.applyOffer(order2);

    }
}

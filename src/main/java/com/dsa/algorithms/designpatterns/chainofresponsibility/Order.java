package com.dsa.algorithms.designpatterns.chainofresponsibility;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Order {
    String orderId;
    Integer cost;
    List<String> itemCategories;
    Boolean isPrimeUser;
    String offerType;
}

package com.dsa.algorithms.domain.java;

import com.dsa.algorithms.domain.linkedlists.DoublyLinkedListNode;
import com.dsa.algorithms.domain.linkedlists.ListNode;

public class Animal {
    private final String name;


    public Animal() {
        this.name = null;
    }
    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

package com.dsa.algorithms.domain.java;

// Violates SRP: This class is responsible for both managing employee data and calculating salary.
public class Employee {
    private String name;
    private int id;

    // Employee data management responsibility
    public void saveEmployeeData() {
        // Code to save employee data to a database
    }

    // Salary calculation responsibility
    public double calculateSalary() {
        // Code to calculate employee salary
        return 0.0;
    }
}


// SRP-compliant design:
class EmployeeSRP {
    private String name;
    private int id;
    // Class responsible for employee data
}

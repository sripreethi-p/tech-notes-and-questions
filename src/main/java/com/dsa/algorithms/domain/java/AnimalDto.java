package com.dsa.algorithms.domain.java;

public class AnimalDto {
    private final String name;

    private final Integer age;


    public AnimalDto(Integer age) {
        this.age = age;
        this.name = null;
    }
    public AnimalDto(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }
}

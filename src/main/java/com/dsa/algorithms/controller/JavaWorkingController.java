package com.dsa.algorithms.controller;

import com.dsa.algorithms.domain.java.Person;
import com.dsa.algorithms.service.corejava.ConstructorWorking;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/java")
@Slf4j
public class JavaWorkingController {
    private final ConstructorWorking constructorWorking;


    public JavaWorkingController(ConstructorWorking constructorWorking) {
        this.constructorWorking = constructorWorking;
    }

    @GetMapping(value = "/person")
    public void usePerson()  {
//        constructorWorking.usePerson();
        constructorWorking.comparePersons();
    }

    @GetMapping(value = "/student")
    public void useStudent()  {
        constructorWorking.useStudent();
    }
}

package com.dsa.algorithms.service.corejava;

import com.dsa.algorithms.domain.java.Person;
import com.dsa.algorithms.domain.java.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Objects;

@Slf4j
@Service
public class ConstructorWorking {

    public void usePerson() {
        Person person = new Person();
        System.out.println(person.getName());
    }

    public void useStudent() {
        Student student = new Student();
        student.setGrade(17);
        student.setName("David");

        log.info("Name : {}, Grade: {}", student.getName(), student.getGrade());
    }

    public void comparePersons() {
        String s1 = "Preethi";
        String s2 = "Preethi";
        Person person1 = new Person("Preethi");
        Person person2 = new Person("Preethi");
        int a = 2;
        int b = 2;
        int c = a;

        log.info("Comparing two objects with same name using \".equals\": {}", person1.equals(person2));
        log.info("Comparing two objects with same name using \"==\": {}", person1==person2);

        log.info("Comparing two integers with same value using \".equals\": {}", Objects.equals(a, b));
        log.info("Comparing two integers with same value using \"==\": {}", a==b);
        log.info("Comparing two integers with same reference using \".equals\": {}", Objects.equals(a, c));
        log.info("Comparing two integers with same reference using \"==\": {}", a==c);

        log.info("Comparing two strings with same value using \".equals\": {}", s1.equals(s2));
        log.info("Comparing two strings with same value using \"==\": {}", s1==s2);


        HashMap<String,String> map = new HashMap<String,String>(){
            {
                put("1", "ONE");
            }{
                put("2", "TWO");
            }{
                put("3", "THREE");
            }
        };

    }
}

package com.dsa.algorithms.domain.java;

public class SomeClass {

   public static class StaticClass {

       private static String str = "Hello World";
       private static StaticClass instance;
       private StaticClass() {

       }

       public static StaticClass getInstance() {
           if (instance == null) {
               instance = new StaticClass();
           }
           return instance;
       }


       public static int num = 0;

       public static void print() {
           System.out.println(str);
           num++;
           System.out.println("Hello World" + num);
       }

       public static void printL() {
           System.out.println("Printing LLLLLLLLL");
       }
   }


}

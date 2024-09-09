# Basic Java

## Topics
- [Inheritance](#1-inheritance)
- [Polymorphism](#2-polymorphism)
- [Encapsulation](#3-encapsulation)
- [Dependency Injection](#4-dependency-injection)
- [Inversion of Control (IoC)](#5-inversion-of-control-ioc)
- [Garbage Collectors](#6-garbage-collectors)


## Comparisons
- [JDK vs JRE vs JVM](#4-jdk-vs-jre-vs-jvm)
- [Abstract class Vs Interface](#1-abstract-classes-vs-interface)
- [STATIC vs FINAL](#2-static-vs-final)
- [Static Classes vs Static Methods vs Static fields](#7-static-classes-vs-static-methods-vs-static-fields)
- [HashMap vs ConcurrentHashMap](#3-hashmap-vs-concurrenthashmap)
- [String vs StringBuilder vs StringBuffer](#5-string-vs-stringbuilder-vs-stringbuffer)
- [CallByValue vs CallByReference](#6-callbyvalue-vs-callbyreference)

<br></br>

## Topics
### 1. Inheritance
The property that allows a subclass to inherit the properties (fields, methods, constructors) of its super class.
Benefits:
- Code reusability
- Method overriding
- Polymorphism

### 2. Polymorphism
The property of allowing us to perform a single action in different ways. Inheritance lets us inherit attributes and methods from another class. Polymorphism uses those methods to perform different tasks.
For example, think of a superclass called _Animal_ that has a method called _animalSound()_. Subclasses of Animals could be _Pigs_, _Cats_, _Dogs_, _Birds_ - And they also have their own implementation of an animal sound (the pig oinks, and the cat meows, etc.):
- Compile time / Static polymorphism (method overloading): having methods with the same name in a class but with different parameters, different return type(optional)
- Runtime polymorphism (method overriding): redefining/overriding a method in the subclass that is already present in the superclass.  

![Method overloading VS Method overriding](../images/overloading-vs-overriding.png)
### 3. Encapsulation
The property of bundling the data (fields, methods) inside the object & exposing only the required components outside the object. Its done by "private" keyword.  
Benefits:
- Security & Access Control (data hiding)
- Flexible implementation of classes
- Modular design of code

### 4. Dependency Injection
### 5. Inversion of Control (IoC)

### 6. Garbage Collectors
Garbage collectors (GC) manage memory by automatically deleting unused java objects.

**1. Serial GC** - single thread does the garbage collection, useful in applications with small data sets where simplicity is more important than performance `JVM Option: -XX:+UseSerialGC`

**2. Parallel GC** - multiple threads do the garbage collection, focusing on maximizing application throughput by minimizing the time spent in garbage collection. Useful for applications with higher throughput as priority, and short pause times are less critical `JVM Option: -XX:+UseParallelGC`

**3. Concurrent Mark Sweep GC** - uses multiple threads to collect garbage while the application is running, minimizing the pause times. Suitable for applications that require low-latency and can afford to trade some throughput for shorter pause times `JVM Option: -XX:+UseConcMarkSweepGC`

**4. G1 GC** - designed to replace the CMS GC, offering more predictable garbage collection pauses. It divides the heap into regions and performs garbage collection incrementally, allowing it to prioritize regions with the most garbage. Suitable for applications requiring a balance between throughput and low-latency, with a focus on predictable pause times `JVM Option: -XX:+UseG1GC`

**5. Z GC** - scalable, low-latency garbage collector designed to handle huge heaps with minimal pause times. It performs most of its work concurrently, ensuring that pause times remain below 10ms, even for heaps of several terabytes. Suitable for applications that require extremely low-latency and can operate with huge heaps `JVM Option: -XX:+UseZGC`

**6. Shenandoah GC** - concurrent, low-latency with concurrent compaction `JVM Option: -XX:+UseShenandoahGC`

**7. Epsilon GC (No-op GC)** - The Epsilon GC is a no-op garbage collector that does not reclaim memory. It is designed for testing and benchmarking purposes where you want to see the impact of GC on performance without any actual garbage collection. Suitable for performance testing where garbage collection is not required or for very short-lived applications where memory is not a constraint `JVM Option: -XX:+UseEpsilonGC`




## Comparisons
### 1. Abstract Classes Vs Interface
![Abstract Classes Vs Interface](../images/abstractclass-vs-interface.png)

### 2. STATIC vs FINAL

### 3. HashMap Vs ConcurrentHashMap
| Hashmap                                                                                          | ConcurrentHashMap                                                                                         |
|--------------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------------------|
| Allows one null key, multiple null values                                                        | Doesn't allow null key or null values                                                                     |
| Not thread-safe for concurrent data modifications via multiple threads                           | Thread safe. Lock striping mechanism in segments (map is divided into segments and each has its own lock) |
| Faster in single threaded applications                                                           | Slower in single threaded applications because of the additional lock mechanisms in the map segments      |
| fail-fast iterators (throws exception if data is tried to modified after declaring the iterator) | fail-safe iterators (concurrent modification is allowed after the iterator is declared)                   | 




### 4. JDK vs JRE vs JVM
JDK = Java Development Kit  
JRE = Java Runtime Environment  
JVM = Java Virtual Machine  
- When you install/download a JDK, JRE & JVM comes with it. 
- JDK compiles java code to bytecode for JVM to execute it. 
- JVM takes the help of JRE (which has all the default java classes and libraries) to run the compiled bytecode.



### 5. String vs StringBuilder vs StringBuffer
- String: Immutable, thread-safe, slower for frequent modifications.
- StringBuilder: Mutable, not thread-safe, faster for frequent modifications in single-threaded contexts.
- StringBuffer: Mutable, thread-safe, slower than StringBuilder, but safe for use in multi-threaded contexts.

### 6. CallByValue vs CallByReference
**1. Call by Value (Primitive Data Types):**
   When a method is called with a primitive data type (e.g., int, char, double), Java passes a copy of the value.
   Any changes made to the parameters inside the method will not affect the original variables.  

**2. Call by Value (Object References):**
   When passing objects to methods, Java passes the reference by value.
   This means that while the reference to the object is copied, both the original and copied references point to the same object in memory.
   Therefore, if you modify the object via the reference inside the method, the changes will reflect in the original object. However, reassigning the reference inside the method does not affect the original reference.


### 7. Static Classes vs Static Methods vs Static fields
The `static` keyword in Java and many other object-oriented programming languages has specific applications when used with classes, methods, and fields. 
Here's how it works in each context:

#### Static Classes (nested)
- Outer Classes: In Java, an outer class cannot be declared as `static`. The `static` keyword is only applicable to inner (nested) classes.
- Nested Static Classes: A nested class can be `static`. When a nested class is declared as `static`, it behaves like a top-level class but is scoped within the outer class. 
- A static nested class can be instantiated without needing an instance of the outer class.
```java
class OuterClass {
    static class StaticNestedClass {
        // Code for static nested class
    }
}

OuterClass.StaticNestedClass nestedObj = new OuterClass.StaticNestedClass();
```

#### Static Methods
- A `static` method belongs to the class rather than instances (objects) of the class. You can call a static method directly using the class name without creating an object of the class.
- Static methods cannot access instance variables or methods directly; they can only access other static members (methods or fields) of the class. This is because static methods do not have access to the instance (`this` reference) of the class.
- This is the first block of code that's executed when a class is loaded.
```java
class ExampleClass {
    static void staticMethod() {
        System.out.println("This is a static method.");
    }
}

ExampleClass.staticMethod(); // Call static method without creating an object
```

#### Static Fields (variables)
- A `static` field is shared across all instances of the class. All objects of that class share the same copy of the static variable, which is stored in a common memory location.
- Static variables are often used for constants or for sharing data between all objects of a class.
```java
class ExampleClass {
    static int staticCounter = 0;

    ExampleClass() {
        staticCounter++;
    }
}

ExampleClass obj1 = new ExampleClass();
ExampleClass obj2 = new ExampleClass();
System.out.println(ExampleClass.staticCounter); // Output will be 2
```
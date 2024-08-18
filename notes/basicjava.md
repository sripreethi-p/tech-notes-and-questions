# Basic Java

## Topics
- Inheritance
- Polymorphism
- Encapsulation
- Dependency Injection
- Inversion of Control (IoC)
- Abstract class Vs Interface
- STATIC vs FINAL
- Garbage Collectors

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

![Method overloading VS Method overriding](images/overloading-vs-overriding.png)
### 3. Encapsulation
The property of bundling the data (fields, methods) inside the object & exposing only the required components outside the object. Its done by "private" keyword.  
Benefits:
- Security & Access Control (data hiding)
- Flexible implementation of classes
- Modular design of code

### 4. Dependency Injection
### 5. Inversion of Control (IoC)

### Abstract Classes Vs Interface
![Abstract Classes Vs Interface](images/abstractclass-vs-interface.png)

### STATIC vs FINAL

### HashMap Vs ConcurrentHashMap
| Hashmap                                                                                          | ConcurrentHashMap                                                                                         |
|--------------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------------------|
| Allows one null key, multiple null values                                                        | Doesn't allow null key or null values                                                                     |
| Not thread-safe for concurrent data modifications via multiple threads                           | Thread safe. Lock striping mechanism in segments (map is divided into segments and each has its own lock) |
| Faster in single threaded applications                                                           | Slower in single threaded applications because of the additional lock mechanisms in the map segments      |
| fail-fast iterators (throws exception if data is tried to modified after declaring the iterator) | fail-safe iterators (concurrent modification is allowed after the iterator is declared)                   | 


### Garbage Collectors
Garbage collectors (GC) manage memory by automatically deleting unused java objects.  

**1. Serial GC** - single thread does the garbage collection, useful in applications with small data sets where simplicity is more important than performance `JVM Option: -XX:+UseSerialGC`    

**2. Parallel GC** - multiple threads do the garbage collection, focusing on maximizing application throughput by minimizing the time spent in garbage collection. Useful for applications with higher throughput as priority, and short pause times are less critical `JVM Option: -XX:+UseParallelGC`  

**3. Concurrent Mark Sweep GC** - uses multiple threads to collect garbage while the application is running, minimizing the pause times. Suitable for applications that require low-latency and can afford to trade some throughput for shorter pause times `JVM Option: -XX:+UseConcMarkSweepGC`

**4. G1 GC** - designed to replace the CMS GC, offering more predictable garbage collection pauses. It divides the heap into regions and performs garbage collection incrementally, allowing it to prioritize regions with the most garbage. Suitable for applications requiring a balance between throughput and low-latency, with a focus on predictable pause times `JVM Option: -XX:+UseG1GC`  

**5. Z GC** - scalable, low-latency garbage collector designed to handle huge heaps with minimal pause times. It performs most of its work concurrently, ensuring that pause times remain below 10ms, even for heaps of several terabytes. Suitable for applications that require extremely low-latency and can operate with huge heaps `JVM Option: -XX:+UseZGC`

**6. Shenandoah GC** - concurrent, low-latency with concurrent compaction `JVM Option: -XX:+UseShenandoahGC`  

**7. Epsilon GC (No-op GC)** - The Epsilon GC is a no-op garbage collector that does not reclaim memory. It is designed for testing and benchmarking purposes where you want to see the impact of GC on performance without any actual garbage collection. Suitable for performance testing where garbage collection is not required or for very short-lived applications where memory is not a constraint `JVM Option: -XX:+UseEpsilonGC` 




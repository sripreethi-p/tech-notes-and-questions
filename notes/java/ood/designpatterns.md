# Design Patterns

## Creational Patterns
1. Singleton 
2. Factory Method
3. Abstract Factory
4. Builder
5. Prototype

## Structural Patterns



## Creational Patterns
Creational design patterns are concerned with the process of object creation. They provide various ways to create objects while hiding the complexities of the instantiation process.  

### 1. Singleton Design Pattern
* **Purpose:** Ensures a class has only one instance and provides a global point of access to it.
* **Use Case:** When exactly one instance of a class is needed, such as in logging, configuration management, or connection pooling.
* **Implementation:** Typically involves creating a static instance of the class and providing a static method to access it.  


![Singleton Design Pattern](../../images/singleton-pattern.png)

<br></br>

### 2. Factory Method
**Purpose:** When you want to create objects of different classes without specifying the exact class based on some conditions  

**Use Case:** When a class can’t anticipate the type of objects it needs to create or when subclasses are expected to specify the objects to be created.  

**Implementation:** Involves a base class with a factory method that is overridden by subclasses to create specific objects.

![Factory Design Pattern](../../images/factory-design-pattern.png)

<br></br>

### 3. Abstract Factory Pattern
**Purpose:** Same as factory method, but when you want to group the subclasses into families based on some behavior without specifying the concrete classes.

**Use Case:** When the system needs to be independent of how its products are created, composed, and represented, or when products are designed to work together.

**Implementation:** Involves a set of factory methods, each responsible for creating different types of related objects.

![Abstract Factory Design Pattern](../../images/abstract-factory-design-pattern.png)


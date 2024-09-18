# Creational Design Patterns
[definition, purpose, use cases, design, example, implementation]

**Creational design patterns** are concerned with the process of object creation.
They provide various ways to create objects while hiding the complexities of the instantiation process.


1. [Singleton](#1-singleton-design-pattern) - ensures a class has only one instance and provides a global point of access to it
2. [Factory Method](#2-factory-pattern) - defines an interface for creating objects, but lets subclasses decide which class to instantiate
3. [Abstract Factory](#3-abstract-factory-pattern) - provides an interface for creating families of related or dependent objects without specifying their concrete classes
4. [Builder](#4-builder-pattern) - separates the construction of a complex object from its representation, allowing the same construction process to create different objects
5. [Prototype](#5-prototype-design-pattern) - creates new objects by copying an existing object, known as a prototype

## 1. Singleton Design Pattern

### Definition

### Purpose

### Use cases

### Design

### Example

### Implementation


<br></br>
* **Purpose:** Ensures a class has only one instance and provides a global point of access to it.
* **Use Case:** When exactly one instance of a class is needed, such as in logging, configuration management, or connection pooling.
* **Implementation:** Typically involves creating a static instance of the class and providing a static method to access it.

![Singleton Design Pattern](../images/singleton-pattern.png)

<br></br>

## 2. Factory Pattern

### Definition

### Purpose

### Use cases

### Design

### Example

### Implementation


<br></br>
**Purpose:** When you want to create objects of different classes without specifying the exact class based on some conditions

**Use Case:** When a class can’t anticipate the type of objects it needs to create or when subclasses are expected to specify the objects to be created.

**Implementation:** Involves a base class with a factory method that is overridden by subclasses to create specific objects.

![Factory Design Pattern](../images/factory-design-pattern.png)

<br></br>

## 3. Abstract Factory Pattern

### Definition

### Purpose

### Use cases

### Design

### Example

### Implementation


<br></br>
**Purpose:** Same as factory method, but when you want to group the subclasses into families based on some behavior without specifying the concrete classes.

**Use Case:** When the system needs to be independent of how its products are created, composed, and represented, or when products are designed to work together.

**Implementation:** Involves a set of factory methods, each responsible for creating different types of related objects.

![Abstract Factory Design Pattern](../images/abstract-factory-design-pattern.png)

<br></br>


## 4. Builder Pattern

### Definition

### Purpose

### Use cases

### Design

### Example

### Implementation


<br></br>

**Purpose:** Separates the construction of a complex object from its representation so that the same construction process can create different representations.

**Use Case:** When an object needs to be created with many possible configurations or when the construction process involves multiple steps.

**Implementation:** Involves a builder class that assembles the parts of an object and a director class that directs the building process.

![Builder Design Pattern](../images/builder-design-pattern.png)

**Explanation:**
- House: The House class is the complex object that we want to build. It has private fields and a private constructor that only the HouseBuilder can use.
- HouseBuilder: The static HouseBuilder class is responsible for building the House object. It contains methods for setting each attribute of the House. Each method returns this to allow for method chaining. Its made static to be able to be used with House without creating an instance of house first.
- build(): The build() method creates an instance of House using the HouseBuilder.
- Main Method: The example usage demonstrates how to create a House object using the builder pattern.

<br></br>

## 5. Prototype Design Pattern

### Definition

### Purpose

### Use cases

### Design

### Example

### Implementation

**Purpose:** Specifies the kinds of objects to create using a prototypical instance and creates new objects by copying this prototype.

**Use Case:** When the cost of creating a new object is more expensive than copying an existing object, or when objects can be cloned rather than created from scratch.

**Implementation:** Involves a prototype interface with a method for cloning itself and concrete classes that implement this method.  
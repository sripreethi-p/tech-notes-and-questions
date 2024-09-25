# Design Patterns

- Design patterns are general, reusable solutions to common problems that occur in software design. 
- They provide a standardized approach to solving architectural challenges in object-oriented design and development, allowing developers to create flexible, maintainable, and scalable software. 
- These patterns are not specific code implementations but rather templates that guide how to structure your code to solve particular problems.

## [Creational Patterns](creational-patterns.md)
Creational design patterns are concerned with the process of object creation.
They provide various ways to create objects while hiding the complexities of the instantiation process.

### 1. Singleton 
Ensures a class has only one instance and provides a global point of access to it.

### 2. Factory Method
Defines an interface for creating objects, but lets subclasses decide which class to instantiate.

### 3. Abstract Factory
Provides an interface for creating families of related or dependent objects without specifying their concrete classes.

### 4. Builder
Separates the construction of a complex object from its representation, allowing the same construction process to create different objects.

### 5. Prototype
Creates new objects by copying an existing object, known as a prototype.


<br></br>

## [Structural Patterns](structural-patterns.md)
Structural design patterns are concerned
with how objects and classes are composed to form larger structures,
how we establish relationships between the entities for that.

### 1. Adapter (Wrapper)
Converts one interface to another, allowing incompatible interfaces to work together.

### 2. Bridge
Decouples an abstraction from its implementation, enabling them to vary independently.

### 3. Composite
Composes objects into tree structures to represent part-whole hierarchies.

### 4. Decorator
Adds responsibilities to an object dynamically without altering its structure.

### 5. Facade
Provides a simplified interface to a complex system of classes.

### 6. Flyweight
Reduces memory usage by sharing common parts of objects, making large numbers of fine-grained objects more efficient.

### 7. Proxy
Controls access to another object, providing additional functionality like lazy initialization or security.

<br></br>

## [Behavioral Patterns](behavioural-patterns.md)
Behavioral patterns are concerned with managing algorithms, relationships, and responsibilities between objects,
ensuring that objects communicate effectively and efficiently to perform tasks.

### 1. Chain of Responsibility 
Passes a request along a chain of handlers.


### 2. Command
Encapsulates a request as an object.

### 3. Interpreter
Interprets sentences in a language.

### 4. Iterator
Provides a way to traverse a collection without exposing its underlying representation.

### 5. Mediator
Defines communication between objects to reduce direct interactions.

### 6. Memento
Saves and restores an object’s state.

### 7. Observer
Notifies dependent objects of state changes.

### 8. State
Changes an object’s behavior when its state changes.

### 9. Strategy
Allows the selection of an algorithm at runtime.

### 10. Template Method
Defines the structure of an algorithm but lets subclasses modify certain steps.

### 11. Visitor
Adds new operations to a class without changing it.





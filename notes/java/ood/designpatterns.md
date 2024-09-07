# Design Patterns

## [Creational Patterns](#creational-design-patterns)
Creational design patterns are concerned with the process of object creation.
They provide various ways to create objects while hiding the complexities of the instantiation process.
1. **Singleton** 
2. **Factory Method**
3. Abstract Factory
4. Builder
5. Prototype

## [Structural Patterns](#structural-design-patterns)
Structural design patterns are concerned
with how we establish relationships between the entities for an efficient working of the system.
1. Adapter (Wrapper)
2. Bridge
3. Composite
4. **Decorator**
5. Facade
6. Flyweight
7. Proxy

## [Behavioral Patterns](#behavioral-design-patterns)
These patterns manage algorithms, relationships, and responsibilities between objects,
ensuring that objects communicate effectively and efficiently to perform tasks.

1. Chain of Responsibility: Passes a request along a chain of handlers.
2. Command: Encapsulates a request as an object.
3. Interpreter: Interprets sentences in a language.
4. Iterator: Provides a way to traverse a collection without exposing its underlying representation.
5. Mediator: Defines communication between objects to reduce direct interactions.
6. Memento: Saves and restores an object’s state.
7. **Observer**: Notifies dependent objects of state changes.
8. State: Changes an object’s behavior when its state changes.
9. **Strategy**: Allows the selection of an algorithm at runtime.
10. Template Method: Defines the structure of an algorithm but lets subclasses modify certain steps.
11. Visitor: Adds new operations to a class without changing it.




<br></br>

## Creational Design Patterns

### 1. Singleton Design Pattern
* **Purpose:** Ensures a class has only one instance and provides a global point of access to it.
* **Use Case:** When exactly one instance of a class is needed, such as in logging, configuration management, or connection pooling.
* **Implementation:** Typically involves creating a static instance of the class and providing a static method to access it.

![Singleton Design Pattern](../../images/singleton-pattern.png)

<br></br>

### 2. Factory Pattern
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

<br></br>


### 4. Builder Pattern

**Purpose:** Separates the construction of a complex object from its representation so that the same construction process can create different representations.  

**Use Case:** When an object needs to be created with many possible configurations or when the construction process involves multiple steps.  

**Implementation:** Involves a builder class that assembles the parts of an object and a director class that directs the building process.  

![Builder Design Pattern](../../images/builder-design-pattern.png)  

**Explanation:**
- House: The House class is the complex object that we want to build. It has private fields and a private constructor that only the HouseBuilder can use.
- HouseBuilder: The static HouseBuilder class is responsible for building the House object. It contains methods for setting each attribute of the House. Each method returns this to allow for method chaining. Its made static to be able to be used with House without creating an instance of house first.
- build(): The build() method creates an instance of House using the HouseBuilder.
- Main Method: The example usage demonstrates how to create a House object using the builder pattern.

<br></br>

### 5. Prototype Design Pattern
**Purpose:** Specifies the kinds of objects to create using a prototypical instance and creates new objects by copying this prototype.  

**Use Case:** When the cost of creating a new object is more expensive than copying an existing object, or when objects can be cloned rather than created from scratch.  

**Implementation:** Involves a prototype interface with a method for cloning itself and concrete classes that implement this method.  

<br></br>

## Structural Design Patterns

### 4. Decorator Pattern
**Purpose:** Dynamically adds responsibilities to objects by wrapping them in additional functionality without altering the object itself. It provides an alternative to subclassing for extending behavior.  

**Application:** Adding additional features (e.g., scrollbars or borders) to GUI components.

**Example**: Say you want to take an order for a pizza, with many possible combinations of toppings. Creating subclass to superclass Pizza for each combination would create Class Explosion. So we create a Decorative Layer on top that could accommodate multiple combinations but return the same class ultimately.
This decorating layer will have **both 'has-a' & 'is-a' relationships** with the base class.

![Decorator Design Pattern](../../images/decorator-design-pattern.png)

<br></br>

## Behavioral Design Patterns

### 7. Observer Pattern

**Description:** an object (known as the subject) maintains a list of its dependents (known as observers) and notifies them of any state changes, usually by calling one of their methods.

**Purpose:** This pattern is commonly used in scenarios where you want to establish a one-to-many relationship between objects, ensuring that when one object changes, all its dependents are automatically informed.

**Example Use case:** A stock ticker system where investors (observers) receive updates on stock prices as soon as there is any change in the stock market. The stock data (subject) is continuously monitored, and all subscribed investors are notified of the updates.
<br></br>

### 9. Strategy Pattern

**Description:** a behavioral design pattern that allows defining a family of algorithms, encapsulating each one, and making them interchangeable. The pattern lets the algorithm vary independently from the clients that use it.  

**Purpose:** Widely used when you have multiple algorithms for a specific task, and you want to make your system flexible by switching between these algorithms at runtime.

**Implementation:** In Java, the Strategy pattern is implemented by defining a strategy interface, implementing different strategy algorithms as concrete classes, and allowing clients to choose the appropriate strategy dynamically.

**Example Use case:** An e-commerce platform that allows customers to pay using different methods (e.g., Credit Card, PayPal, Cryptocurrency).
A `PaymentContext` class can switch between different payment strategies like `CreditCardPayment`, `PayPalPayment`, or `CryptoPayment` based on the user's selection during checkout.

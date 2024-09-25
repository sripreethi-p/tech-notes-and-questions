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
A design pattern that ensures a class has only one instance and provides a global point of access to that instance.

### Purpose
This is useful when you want to control access to a shared resource, like a configuration object or a connection pool.

### Use cases

#### 1. Thread Pool Management
- A thread pool manager that manages a pool of threads for executing tasks. 
- A singleton ensures that only one thread pool instance is created, managing resources efficiently.

#### 2. Caching
- A cache manager that stores frequently accessed data. 
- A singleton ensures that there is a single cache instance used across the application, avoiding duplication of cached data.

#### 3. Database Connections
- A database connection manager that handles connections to a database. 
- Using a singleton can help manage a single database connection or a connection pool, reducing overhead and ensuring consistent access.

#### 4. Logging
- A logging class that writes log messages to a file or console. 
- A singleton ensures that all log messages go through the same logging instance, preventing issues like multiple log files or inconsistent logging

### Design

* `Single Instance`: Ensures that only one instance of the class is created.
* `Global Access`: Provides a global point of access to the instance.
* `Lazy Initialization`: The instance is created only when it is needed (optional but common practice).
* `Eager Initialization`: The instance is created at the time of class loading. This is simple but can lead to unnecessary resource usage if the instance is never used.

### Example
Let's implement a simple Java class that behaves like a Singleton class

### Implementation

1. Create the `SingletonClass` for which you want only one instance created (lazy initialization)

```java
public class SingletonClass {
    
    public static SingletonClass instance;
    // (eager initialization)
    // public static SingletonClass instance = new SingletonClass();
    
    
    // blocking the constructor so it's not accessible for multiple instantiations
    private SingletonClass() {
    }
    
    /*
        'synchronized' so that even when multiple threads try to access, 
         only one thread can instantiate it & the others will use that instance
     */
    public static synchronized SingletonClass getInstance() {
        
        // (lazy initialization)
        // 'instance==null' check to ensure all the threads use the one instance that's already created
        if (instance==null) {
            instance = new SingletonClass();
        }
        return instance;
    }
}
```

2. Client code demonstrate Singleton usage

```java
public static void main (String[] args) {
    SingletonClass instance1 = SingletonClass.getInstance();
    SingletonClass instance2 = SingletonClass.getInstance();

    System.out.println(instance1 == instance2); // true, same instance
}
```

<br></br>

## 2. Factory Pattern

### Definition
- A design pattern used to create objects without exposing the creation logic to the client. 
- It provides an interface for creating objects, allowing subclasses to alter the type of objects that will be created.


- **Encapsulation of object creation logic:** The factory method handles the instantiation of the objects.
- **Decoupling:** The client only knows about the abstract type (interface/abstract class), not the actual concrete class that is instantiated.
- **Flexibility:** Easily extendable with new product types without changing existing code, adhering to the Open-Closed Principle.

#### Benefits
* **Decouples** object creation from the client.
* **Easily extendable:** If a new vehicle type is introduced, like Bus, only the factory and the new class need modification.

### Purpose
Used in various scenarios where object creation requires flexibility, 
decoupling, or the creation logic can change based on specific conditions 
without the client having to know which subclasses to create.

### Use cases

#### 1. To support multiple payment options in the future
* **Use Case:** If you want to add new classes to your system without modifying existing client code, the Factory Pattern provides a good solution.
* **Example:** If a payment system supports Credit Card and PayPal initially, but later on needs to support Google Pay, the factory can easily be extended without changing the existing logic.
```java
Payment payment = PaymentFactory.getPaymentMethod("GooglePay");
payment.process();
```

#### 2. When You Want to Hide Complex Object Construction Logic
* **Use Case:** The factory pattern can abstract complex object creation logic so that the client code does not have to deal with it.
* **Example:** A system that handles multimedia files (images, videos, audio) where each file type requires different decoding mechanisms.
```java
MediaFile file = MediaFactory.getMediaFile("MP4");
file.play();
```

#### 3. When You Need to Manage the Versioning of Objects
* **Use Case:** When a class evolves over time with new versions, the factory can handle creating the correct version based on the input.
* **Example:** If a document management system needs to handle multiple versions of a file format, a factory can instantiate the correct version of the document handler.
```java
DocumentHandler handler = DocumentHandlerFactory.getHandler("v2");
```

### Design

- `Product` interface: declares the interface of the objects that the factory method creates
- `Concrete Product` classes: these classes implement the product interface
- `Creator (Factory)` class: declares the factory method, which returns an object of type `Product`
- `Concrete Creator`: implements the factory method to create instances of concrete product types.

### Example
Let's say we have different vehicles like Bike, Car, etc. 
We want the client to initiate instances as per required without having to know about the associated concrete classes.

### Implementation

1. Create the `Vehicle` interface

```java
interface Vehicle {
    void drive();
}
```

2. Create the Concrete classes `Car`, `Bike`, etc.

```java
public class Car implements Vehicle {
    
    @Override
    void drive() {
        System.out.println("Driving a Car...");
    }
}
```

```java
public class Bike implements Vehicle {
    
    @Override
    void drive() {
        System.out.println("Driving a Bike...");
    }
}
```

3. Create the `Factory class` with methods to decide the type of class for the object (object creation logic)

```java
public class VehicleFactory {
    public Vehicle getVehicle(String vehicleName) {
        if(vehicleName.equalsIgnoreCase("car")) {
            return new Car();
        }
        else if(vehicleName.equalsIgnoreCase("bike")) {
            return new Bike();
        }
        
        return null;
    }
}
```

4. `Client` code to demonstrate the usage
```java
public static void main (String[] args) {
    VehicleFactory vehicleFactory = new VehicleFactory();
    
    Vehicle vehicle1 = vehicleFactory.getVehicle("car");
    Vehicle vehicle2 = vehicleFactory.getVehicle("bike");
    
    vehicle1.drive(); // Driving a Car...
    vehicle2.drive(); // Driving a Bike...
}
```

<br></br>

## 3. Abstract Factory Pattern

### Definition
- A design pattern
that provides an interface
for creating families of related or dependent objects without specifying their concrete classes.

- In factory method, we have an abstraction at product level.   
Here, we have another layer of abstraction at the factory class to group the concrete products.


### Purpose
It's useful when you need to create objects from several related classes without knowing their exact types.

### Use cases

### Design
- `Abstract Product` interface: Declares the interface for a type of product.
- `Concrete Product`: Implements the abstract product interface.
- `Abstract Factory` interface: Declares the creation methods for each product type.
- `Concrete Factory`: Implements the creation methods for the specific product family.
- `Client`: Uses the factories to get instances of products but is unaware of the specific classes being created.

### Example
Let's take the same example as above - vehicles like Car, 
Bike but with subcategories of Luxury vehicles & Economic vehicles

### Implementation

1. Create the `Vehicle` interface

```java
interface Vehicle {
    void move();
}
```

2. Create the `ConcreteProduct` classes

```java
public class EconomicCar implements Vehicle {

    @Override
    void move() {
        System.out.println("Driving an Economic Car...");
    }
}
```

```java
public class LuxuryCar implements Vehicle {

    @Override
    void move() {
        System.out.println("Driving a Luxury Car...");
    }
}
```

```java
public class EconomicBike implements Vehicle {

    @Override
    void move() {
        System.out.println("Riding an Economic Bike...");
    }
}
```

```java
public class LuxuryBike implements Vehicle {

    @Override
    void move() {
        System.out.println("Riding a Luxury Bike...");
    }
}
```

3. Create the abstract `VehicleFactory` interface

```java
public interface VehicleFactory {
    Vehicle getVehicle(String vehicleName);
} 
```

4. Create the `ConcreteVehicleFactory` classes that group the products

```java
public class EconomicVehicleFactory implements VehicleFactory {
    
    @Override
    Vehicle getVehicle(String vehicleName) {
        if (vehicleName.equalsIgnoreCase("car")) {
            return new EconomicCar();
        }
        else if(vehicleName.equalsIgnoreCase("bike")) {
            return new EconomicBike();
        }
        
        return null;
    }
}
```

```java
public class LuxuryVehicleFactory implements VehicleFactory {
    
    @Override
    Vehicle getVehicle(String vehicleName) {
        if (vehicleName.equalsIgnoreCase("car")) {
            return new LuxuryCar();
        }
        else if(vehicleName.equalsIgnoreCase("bike")) {
            return new LuxuryBike();
        }
        
        return null;
    }
}
```

5. `Client` code to demonstrate the usage

```java
public static void main (String[] args) {
    VehicleFactory economicFactory = new EconomicVehicleFactory();
    VehicleFactory luxuryFactory = new LuxuryVehicleFactory();
    
    Vehicle vehicle1 = economicFactory.getVehicle("car");   
    Vehicle vehicle2 = luxuryFactory.getVehicle("car");     
    Vehicle vehicle3 = economicFactory.getVehicle("bike");  
    Vehicle vehicle4 = luxuryFactory.getVehicle("bike");    
    
    vehicle1.move();  // Driving an Economy Car...
    vehicle2.move();  // Driving a Luxury Car...
    vehicle3.move();  // Riding an Economic Bike...
    vehicle4.move();  // Riding a Luxury Bike...
}
```

<br></br>


## 4. Builder Pattern

### Definition
The pattern separates the construction of an object from its representation, 
allowing for more control over the object creation process.

### Purpose
When an object needs to be created with many possible configurations 
or when the construction process involves multiple steps.

### Use cases

### Design

* `Builder`: A separate object that builds the desired object step by step.
* `Product`: The object that the builder constructs.
* `Director`: (Optional) An object that controls the construction process, ensuring that all necessary steps are performed.

### Example

Imagine you want to build a house object, and it has multiple optional and mandatory fields. 
Instead of having a constructor with many parameters, 
you can use the builder pattern to construct the house step by step.

### Implementation

1. Create the `House` class with its fields & also a static class `HouseBuilder` inside it that builds the object of House type.

```java
// Product class
public class House {
    // Required parameters
    private final String foundation;
    private final String structure;

    // Optional parameters
    private final boolean hasGarage;
    private final boolean hasSwimmingPool;
    private final boolean hasGarden;

    // Private constructor
    private House(HouseBuilder builder) {
        this.foundation = builder.foundation;
        this.structure = builder.structure;
        this.hasGarage = builder.hasGarage;
        this.hasSwimmingPool = builder.hasSwimmingPool;
        this.hasGarden = builder.hasGarden;
    }

    @Override
    public String toString() {
        return "House{" +
                "foundation='" + foundation + '\'' +
                ", structure='" + structure + '\'' +
                ", hasGarage=" + hasGarage +
                ", hasSwimmingPool=" + hasSwimmingPool +
                ", hasGarden=" + hasGarden +
                '}';
    }

    // Builder Class
    public static class HouseBuilder {
        // Required parameters
        private final String foundation;
        private final String structure;

        // Optional parameters - initialize with default values
        private boolean hasGarage = false;
        private boolean hasSwimmingPool = false;
        private boolean hasGarden = false;

        // Builder constructor with required parameters
        public HouseBuilder(String foundation, String structure) {
            this.foundation = foundation;
            this.structure = structure;
        }

        // Setters for optional parameters
        public HouseBuilder setGarage(boolean hasGarage) {
            this.hasGarage = hasGarage;
            return this; // Return builder to allow chaining
        }

        public HouseBuilder setSwimmingPool(boolean hasSwimmingPool) {
            this.hasSwimmingPool = hasSwimmingPool;
            return this;
        }

        public HouseBuilder setGarden(boolean hasGarden) {
            this.hasGarden = hasGarden;
            return this;
        }

        // Build method to create the House object
        public House build() {
            return new House(this);
        }
    }
}
```

2. `Client` code to demonstrate the usage

```java
public class BuilderPatternExample {
    public static void main(String[] args) {
        // Using the builder to create a complex House object
        House house = new House.HouseBuilder("Concrete", "Wood")
                .setGarage(true)
                .setSwimmingPool(false)
                .setGarden(true)
                .build();

        System.out.println(house);
    }
}
```
<br></br>

**Explanation:**
- House: The House class is the complex object that we want to build. It has private fields and a private constructor that only the HouseBuilder can use.
- HouseBuilder: The static HouseBuilder class is responsible for building the House object. It contains methods for setting each attribute of the House. Each method returns this to allow for method chaining. Its made static to be able to be used with House without creating an instance of house first.
- build(): The build() method creates an instance of House using the HouseBuilder.
- Main Method: The example usage demonstrates how to create a House object using the builder pattern.

<br></br>

## 5. Prototype Design Pattern

### Definition

* A design pattern that allows you to create new objects by copying an existing object, known as the prototype. 
* The key benefit is that it allows for dynamic object creation and can simplify object creation processes.

### Purpose

This pattern is useful 
when the cost of creating a new instance of an object is more expensive than copying an existing one.

### Use cases

### Design

- `Prototype` Interface: This defines a method for cloning itself.
- `Concrete Prototype`: This is the class that implements the Prototype interface and provides the cloning functionality.

### Example

Let's illustrate this with a simple example involving shapes.

### Implementation

1. Create the `Prototype Interface`

```java
public interface Shape {
    Shape clone();
    void draw();
}
```

2. Create `Concrete Prototype` Classes

```java
public class Circle implements Shape {
    @Override
    public Shape clone() {
        return new Circle();
    }

    @Override
    public void draw() {
        System.out.println("Drawing a Circle");
    }
}
```

```java
public class Square implements Shape {
    @Override
    public Shape clone() {
        return new Square();
    }

    @Override
    public void draw() {
        System.out.println("Drawing a Square");
    }
}
```

3. Client code to demonstrate the usage

```java
public static void main(String[] args) {
        // Create a circle and square
        Shape circle = new Circle();
        Shape square = new Square();
        
        // Clone the shapes
        Shape clonedCircle = circle.clone();
        Shape clonedSquare = square.clone();
        
        // Draw original and cloned shapes
        circle.draw(); // Output: Drawing a Circle
        clonedCircle.draw(); // Output: Drawing a Circle
        
        square.draw(); // Output: Drawing a Square
        clonedSquare.draw(); // Output: Drawing a Square
}
```
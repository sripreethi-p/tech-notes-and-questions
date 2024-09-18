# Behavioral Design Patterns 
[definition, purpose, use cases, design, example, implementation] 
1. [Chain of Responsibility](#1-chain-of-responsibility-pattern)
2. [Command](#2-command-pattern)
3. [Interpreter](#3-interpreter-pattern)
4. [Iterator](#4-iterator-pattern)
5. []

## 1. Chain of Responsibility Pattern

### Definition
This pattern allows an object to pass the request along a chain of handlers. 
Upon receiving a request, each handler decides whether to process the request or to pass it to the next handler in the chain.

### Purpose
When you have a set of conditions, and you need to pick the one to be applied based on priority.
- **Decoupling:** The sender of a request doesn't know which object will handle it.
- **Flexibility:** The chain can be dynamically modified to suit the program's needs.
### Use cases

### Design

### Example
Say, you have a shopping cart and a set of offers where we want to pick which to be applied based on a set priority.
The offers (priority wise):
- If prime user & cost>200$: 1 week free shipping
- If prime user: 4 days free shipping
- If prime user & items are groceries: 5 days free shipping
- If items are groceries & cost>200$: 2 days free shipping
### Implementation
1. We create an Offer Handler interface
```java
abstract class OfferHandler {
    // protected and not private because we want the subclasses to be able to access it
    protected OfferHandler nextOfferHandler;
    
    public void setNextOfferHandler(OfferHandler nextOfferHandler) {
        this.nextOfferHandler = nextOfferHandler;
    }
    
    public abstract void applyOrder(Order order);
}
```
2. Create Concrete Offer Classes with the logic
```java
public class Offer1 extends OfferHandler {
    @Override
    public void applyOffer(Order order) {
        if(order.cost> 200 && order.isPrimeUser) {
            order.setOfferType("OFFER 1");
            System.out.println(order.getOfferType() + " applied to " + order.getOrderId());
        }
        else if(nextOfferHandler!=null) {
            nextOfferHandler.applyOffer(order);
        }
    }
}
```

```java
public class Offer4 extends OfferHandler {
    @Override
    public void applyOffer(Order order) {
        if(order.getCost()>25 && order.getItemCategories().contains("GROCERIES")) {
            order.setOfferType("OFFER 4");
            System.out.println(order.getOfferType() + " applied to " + order.getOrderId());
        }
        else if (nextOfferHandler!=null) {
            nextOfferHandler.applyOffer(order);
        }
    }
}
```


3. Instantiate the offers & setup the chain & run the order through it
```java
public class ChainOfResponsibility {
    public static void main(String[] args) {

        // Initiate offers
        OfferHandler offer1 = new Offer1();
        OfferHandler offer2 = new Offer2();
        OfferHandler offer3 = new Offer3();
        OfferHandler offer4 = new Offer4();

        // Set up the chain
        offer1.setNextOfferHandler(offer2);
        offer2.setNextOfferHandler(offer3);
        offer3.setNextOfferHandler(offer4);

        Order order1 = new Order("1", 30, List.of("GROCERIES"), true, null);
        Order order2 = new Order("2", 30, List.of("GROCERIES"), false, null);

        offer1.applyOffer(order1);  // OFFER 2 applied to 1
        offer1.applyOffer(order2);  // OFFER 4 applied to 2
    }
}
```

<br></br>

## 2. Command Pattern

### Definition


### Purpose
When you need to execute some commands, but also want to decouple the command invoker & command executor so you can make client requests encapsulated, queued, logged, or executed later.

### Use Cases

**1. Undo/Redo Functionalities in text editors, games, etc.**
- Each action (command) like typing, drawing, or moving can be encapsulated as a command object.
- You can store these commands in a stack to support undo/redo operations.

**2. Logging or Transactional Mechanisms in Banking systems, File Systems**
- For Systems that require logging of every action or transaction for auditing or rollback purposes.
- Each command can be logged and re-executed if needed. It can also facilitate rollback by executing inverse commands.
- Each transaction can be a command (withdraw, deposit) and can be logged for future reference or auditing.
- A file copy, move, or delete operation can be encapsulated as a command and logged for recovery or rollback in case of failure.


### Design
* We will have a common `Command` interface, and then its implementations. 
* We have a `Receiver` class that actually performs the work. 
* And then the `Invoker` class that asks the command to run.


### Example
Let’s assume we have a Light class that can be turned on and off, 
and we want to implement the Command pattern to encapsulate these operations.

### Implementation

1. `Command` Interface
```java
// Command Interface
public interface Command {
    void execute();
}
```

2. Concrete Command Classes
```java
// Concrete Command to turn the light on
public class LightOnCommand implements Command {
    private Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOn();
    }
}

// Concrete Command to turn the light off
public class LightOffCommand implements Command {
    private Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOff();
    }
}
```

3. `Receiver` class
```java
// Receiver Class
public class Light {
    public void turnOn() {
        System.out.println("The light is on.");
    }

    public void turnOff() {
        System.out.println("The light is off.");
    }
}
```
4. `Invoker` class
```java
// Invoker Class
public class RemoteControl {
    private Command command;

    // Set the command to be executed
    public void setCommand(Command command) {
        this.command = command;
    }

    // Execute the command
    public void pressButton() {
        command.execute();
    }
}
```

5. Client code
```java
// Client
public class CommandPatternDemo {
    public static void main(String[] args) {
        // Receiver
        Light light = new Light();

        // Concrete Commands
        Command lightOnCommand = new LightOnCommand(light);
        Command lightOffCommand = new LightOffCommand(light);

        // Invoker
        RemoteControl remote = new RemoteControl();

        // Turn the light on
        remote.setCommand(lightOnCommand);
        remote.pressButton();

        // Turn the light off
        remote.setCommand(lightOffCommand);
        remote.pressButton();
    }
}
```

<br></br>

## 3. Interpreter Pattern

### Definition
The pattern defines
- a grammatical representation for a language
- an interpreter that uses the representation to interpret the language

### Purpose
- It is used to represent and evaluate language syntax or expressions. 
- The pattern is commonly used in applications where grammar or expressions are predefined and simple.


### Use cases

#### 1. Interpreting Domain Specific Languages (DSLs)
* Use Case: Create an internal DSL for business rules or configuration.
* Application: An enterprise system might have rules like "if an order value is above a certain amount, apply a discount."
* How Interpreter Pattern Helps: Defines a grammar for these rules and interprets the rules to automate decision-making.

#### 2. Configuration or Scripting Languages
* Use Case: Design an interpreter for a small configuration language or scripting language.
* Application: A custom configuration syntax for a software system, where administrators can define settings like "set max_connections to 100".
* How Interpreter Pattern Helps: Each configuration rule can be an expression that the interpreter parses and executes.

#### 3. Spreadsheet Formulas
* Use Case: Interpret and evaluate spreadsheet formulas like =SUM(A1:B2).
* Application: A spreadsheet application where users can define formulas for automatic calculation of values.
* How Interpreter Pattern Helps: Each formula or function (e.g., SUM, AVERAGE) is treated as a rule to be interpreted and evaluated.


### Design
- abstract `Expression`: declares an interface for interpreting the context
- terminal `Expression`: implements an `interpret()` operation associated with terminal symbols in grammar (simplest rules)
- non-terminal `Expression`: represents more complex grammar rules & composes expressions using other expressions
- `Context`: contains info that is global to the interpreter


### Example
Let's create a simple example where we interpret mathematical expressions using the Interpreter pattern. 
We'll define an expression that can handle addition, subtraction, and numbers.


### Implementation

1. Define the `Expression` interface
```java
interface Expression {
    int interpret();
}
```

2. Create `Terminal Expression` classes for Numbers
```java
class NumberExpression implements Expression {
    private int number;

    public NumberExpression(int number) {
        this.number = number;
    }

    @Override
    public int interpret() {
        return this.number;
    }
}
```

3. Create Non-Terminal Expression classes for Add and Subtract

```java
class AddExpression implements Expression {
    private Expression leftExpression;
    private Expression rightExpression;

    public AddExpression(Expression leftExpression, Expression rightExpression) {
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
    }

    @Override
    public int interpret() {
        return leftExpression.interpret() + rightExpression.interpret();
    }
}
```

```java
class SubtractExpression implements Expression {
    private Expression leftExpression;
    private Expression rightExpression;

    public SubtractExpression(Expression leftExpression, Expression rightExpression) {
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
    }

    @Override
    public int interpret() {
        return leftExpression.interpret() - rightExpression.interpret();
    }
}
```

4. `Client` code that builds the expression tree

```java
public static void main(String[] args) {
        // Create number expressions
        Expression ten = new NumberExpression(10);
        Expression twenty = new NumberExpression(20);
        Expression five = new NumberExpression(5);

        // Create the expression tree: (10 + 20) - 5
        Expression addExpression = new AddExpression(ten, twenty);
        Expression subtractExpression = new SubtractExpression(addExpression, five);

        // Interpret the expression tree and print the result
        int result = subtractExpression.interpret();
        System.out.println("(10 + 20) - 5 = " + result);  // Output: (10 + 20) - 5 = 25
    }
```


<br></br>


## 4. Iterator Pattern

### Definition
The pattern allows for sequential access of elements in a collection without exposing its underlying representation.

### Purpose
It provides a standard way to iterate through collections like lists, arrays, or trees 
while hiding the complexities involved in the iteration process.

- Encapsulation: The collection's internal structure remains hidden.
- Single Responsibility: The collection handles storage, while the iterator handles iteration.
- Consistent Interface: Regardless of the collection's type (array, list, etc.), the client uses the same interface for iteration.

### Use cases

#### 1. Custom Iteration Logic
* **Use Case:** When you need customized iteration logic that differs from the default traversal, such as reverse iteration or skipping certain elements.
* **Example:** A media player playlist might need to implement a custom iterator that plays songs in a shuffled order, or a shopping cart might skip certain low-priority items when running out of budget.

#### 2. Batch Processing of Elements
* **Use Case:** Iterators can facilitate batch processing by breaking down large tasks into smaller chunks for processing one element at a time.
* **Example 1:** A large-scale image processing system might use an iterator to read and process images in small batches, ensuring the system doesn’t run out of memory when processing millions of images.
* **Example 2:** Batch processing in Kafka Consumers

#### 3. Handling Composite Structures
* **Use Case:** In tree-like or graph structures (e.g., file systems or DOM trees), where elements may have nested sub-elements, the Iterator pattern can abstract away the complexity of traversal.
* **Example:** In a file system where directories contain files and subdirectories, you can implement an iterator that allows a user to easily traverse through all files in a directory, including files in subdirectories.


### Design
- `Iterator` interface: declares the methods needed for iteration (like `hasNext()` and `next()`)
- `Aggregator` interface: provides the iterator to traverse through the elements
- concrete `Iterator`: implements the iterator interface to provide the actual mechanism for iterating over the collection.
- concrete `Aggregator`: A concrete implementation of the collection.


### Example
Let's consider a basic Java example of iterating through an array of Strings

### Implementation

1. Define the `Iterator` Interface
```java
public interface Iterator<T> {
    boolean hasNext();
    T next();
}
```

2. Create the `Aggregator` Interface
```java
public interface IterableCollection<T> {
    Iterator<T> createIterator();
}
```

3. `Concrete Iterator` Implementation
```java
public class NameIterator implements Iterator<T> {
    private String[] names;
    private int index;
    
    public NameIterator(String[] names) {
        this.names = names;
        this.index = 0;
    }
    
    @Override
    public boolean hasNext() {
        return index<names.length;
    }
    
    @Override
    public String next() {
        if(this.hasNext()) {
            return names[index++];
        }
        return null;
    }
}
```

4. `Concrete Collection` Implementation

```java
public class NameCollection implements IterableCollection<T> {
    private String[] names;
    
    public NameCollection(String[] names) {
        this.names = names;
    }
    
    @Override
    public Iterator<String> createIterator() {
        return NameIterator(names);
    }
} 
```


5. `Client` Code to Use the Iterator

```java
public static void main (String[] args) {
    String[] names = { "Dave", "Joseph", "Jessica", "Nick" };
    
    NameCollection nameCollection = new NameCollection(names);
    Iterator<String> iterator = nameCollection.createIterator();
    
    while ((iterator.hasNext())) {
        String name = iterator.next();
        System.out.println("Name: " + name);
    }
}
```


<br></br>


## 5. Mediator Pattern

### Definition
- The pattern that defines an object that encapsulates how a set of objects interact. 
- It promotes loose coupling by keeping objects from referring to each other explicitly, and it lets you vary their interaction independently.


### Purpose
When you want to loosely couple objects and manage their interactions (control and logic) in another class
* Reduces the complexity of communication between multiple objects.
* Centralizes control and logic in one place (the mediator).
* Encourages loose coupling between colleagues.

### Use cases

#### 1. Chat Applications
- In chat applications, the mediator pattern can be used to manage communication between multiple users. 
- The mediator (e.g., a chat room) can handle message routing, ensuring that messages are delivered to the appropriate recipients without users directly referring to each other.

#### 2. Workflow Systems
- In workflow or process management systems like `Apache Airflow` & `Apache Nifi`, the mediator pattern can manage the interaction between different steps or components of a workflow. 
- This ensures that each component communicates properly with others, without being tightly coupled.

#### 3. Order Processing Systems
- In an order processing system, where different components (e.g., inventory, payment, shipping) need to interact, a mediator can manage the communication and ensure that each component is updated with the necessary information without direct dependencies.


### Design
- `Mediator` interface: defines a method for communication between colleague objects
- `ConcreteMediator` class: implements the mediator interface and coordinates communication between colleague objects
- `Colleague` interface: abstract class or interface for objects that communicate through the mediator
- `ConcreteColleague` classes: implements the colleague interface and communicates with other colleagues through the mediator

### Example
Let's use a chatroom as an example where multiple users can communicate with each other. 
We'll use the Mediator pattern to manage the interactions between users.

### Implementation
1. Define the `Mediator` interface

```java
public interface Mediator {
    void sendMessage (String message, User user);
}
```

2. Define the `Colleague` interface/abstract class

```java
import java.awt.*;

public abstract class User {
    protected Mediator mediator;
    protected String name;

    public User(Mediator mediator, String name) {
        this.mediator = mediator;
        this.name = name;
    }

    public abstract void receiveMessage(String message);
    public abstract void sendMessage(String message);
}
```

3. Implement the `ConcreteMediator`

```java
public class ChatRoom implements Mediator {
    private List<User> users = new ArrayList<>();

    public void addUser(User user) {
        users.add(user);
    }
    
    @Override
    public void sendMessage(String message, User user) {
        for (User u : users) {
            if (u != user) {
                u.receiveMessage(message);
            }
        }
    }
}
```

4. Implement the `ConcreteColleague` classes

```java
public class ConcreteUser extends User {
    public ConcreteUser(Mediator mediator, String name) {
        super(mediator, name);
    }
    
    @Override
    public void receiveMessage (String message) {
        System.out.println(name + " received: " + message);
    }
    
    @Override
    public void sendMessage (String message) {
        System.out.println(name + " sent: " + message);
        mediator.sendMessage(message, this);
    }
}
```

5. Client code to demonstrate the usage

```java
public static void main (String[] args) {
    
    ChatRoom chatRoom = new ChatRoom();
    
    ConcreteUser dave = new ConcreteUser (chatRoom, "Dave");
    ConcreteUser jessica = new ConcreteUser (chatRoom, "Jessica");
    ConcreteUser nick = new ConcreteUser (chatRoom, "Nick");
    
    chatRoom.addUser(dave);
    chatRoom.addUser(jessica);
    chatRoom.addUser(nick);
    
    dave.sendMessage("Hi! I'm Dave, everyone.");
    jessica.sendMessage("Hi Dave and everyone else");
    nick.sendMessage("Hi Dave and Jessica, and everyone else");
}
```


<br></br>


## 6. Memento Pattern

### Definition

### Purpose

### Use cases

### Design


### Example


### Implementation


<br></br>


## 7. Observer Pattern

**Description:** an object (known as the subject) maintains a list of its dependents (known as observers) and notifies them of any state changes, usually by calling one of their methods.

**Purpose:** This pattern is commonly used in scenarios where you want to establish a one-to-many relationship between objects, ensuring that when one object changes, all its dependents are automatically informed.

**Example Use case:** A stock ticker system where investors (observers) receive updates on stock prices as soon as there is any change in the stock market. The stock data (subject) is continuously monitored, and all subscribed investors are notified of the updates.
<br></br>

## 9. Strategy Pattern

**Description:** a behavioral design pattern that allows defining a family of algorithms, encapsulating each one, and making them interchangeable. The pattern lets the algorithm vary independently from the clients that use it.

**Purpose:** Widely used when you have multiple algorithms for a specific task, and you want to make your system flexible by switching between these algorithms at runtime.

**Implementation:** In Java, the Strategy pattern is implemented by defining a strategy interface, implementing different strategy algorithms as concrete classes, and allowing clients to choose the appropriate strategy dynamically.

**Example Use case:** An e-commerce platform that allows customers to pay using different methods (e.g., Credit Card, PayPal, Cryptocurrency).
A `PaymentContext` class can switch between different payment strategies like `CreditCardPayment`, `PayPalPayment`, or `CryptoPayment` based on the user's selection during checkout.

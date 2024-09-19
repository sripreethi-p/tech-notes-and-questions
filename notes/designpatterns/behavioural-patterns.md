# Behavioral Design Patterns 
[definition, purpose, use cases, design, example, implementation] 

**Behavioral patterns** are concerned with managing algorithms, relationships, and responsibilities between objects,
ensuring that objects communicate effectively and efficiently to perform tasks.

1. [Chain of Responsibility](#1-chain-of-responsibility-pattern) - passes a request along a chain of handlers
2. [Command](#2-command-pattern) - encapsulates a request as an object
3. [Interpreter](#3-interpreter-pattern) - interprets sentences in a language
4. [Iterator](#4-iterator-pattern) - provides a way to traverse a collection without exposing its underlying representation
5. [Mediator](#5-mediator-pattern) - defines communication between objects to reduce direct interactions
6. [Memento](#6-memento-pattern) - saves and restores an object’s state
7. [Observer](#7-observer-pattern) - notifies dependent objects of state changes
8. [State](#8-state-pattern) - changes an object’s behavior when its state changes
9. [Strategy](#9-strategy-pattern) - allows the selection of an algorithm at runtime
10. [Template Method](#10-template-method-pattern) - defines the structure of an algorithm but lets subclasses modify certain steps
11. [Visitor](#11-visitor-pattern) - adds new operations to a class without changing it

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
The design pattern is used to capture and restore an object's state without violating encapsulation.

### Purpose
It is particularly useful when you need to implement undo/redo functionality or save and restore the state of an object.


### Use cases

#### 1. Undo/Redo Functionality
- **Use Case:** In applications where users can make changes to an object (e.g., text editors, graphic design software), the Memento pattern helps implement undo and redo functionality. Each change can be saved as a Memento, allowing users to revert to previous states.

- **Example:** A text editor can use the Memento pattern to save the state of the document at different points in time, allowing users to undo or redo their changes.

#### 2. Version Control Systems
- **Use Case:** In version control systems, the state of a file or project needs to be captured and restored. The Memento pattern can be used to save snapshots of files or projects, enabling rollback to previous versions.

- **Example:** A source code repository saves snapshots of code changes, allowing developers to revert to earlier versions of the codebase.


#### 3. Simulation and Testing
- **Use Case:** In simulation or testing environments, the Memento pattern can be used to save the state of the system at different points for testing purposes or to analyze different scenarios.

- **Example:** A simulation tool saves the state of a simulated environment at various points, enabling users to analyze how changes in parameters affect the system.

### Design
- `Originator` class: the object whose state needs to be saved and restored
- `Memento` class: stores the state of the **_Originator_** and is used to restore the state
- `Caretaker` class: responsible for keeping the **_Memento_** and ensuring it is not modified. It can request the **_Memento_** from the **_Originator_** and use it to restore the Originator's state.


### Example
Let's consider a simple example of a text editor where we can save and restore the state of the text content.

### Implementation

1. Create `Originator` class whose state needs to be stored

```java
public class TextEditor {
    private String content;
    
    public void setContent(String content) {
        this.content = content;
    }
    
    public String getContent() {
        return content;
    }
    
    public Memento save() {
        return new Memento(content);
    }
    
    public void restore(Memento memento) {
        this.content = memento.getContent();
    }
}
```
2. Create `Memento` class which stores the state of Originator objects

```java
public class Memento {
    private final String content;
    
    public Memento (String content) {
        this.content = content;
    }
    
    public String getContent() {
        return content;
    }
}
```

3. Create `Caretaker` class that handles Memento's requests to restore Originator objects

```java
import java.util.Stack;

public class Caretaker {
    private final Stack<Memento> mementoStack = new Stack<>();
    
    public void saveState(TextEditor editor) {
        mementoStack.push(editor.save());
    }
    
    public void restoreState(TextEditor editor) {
        if(!mementoStack.isEmpty()) {
            Memento memento = mementoStack.pop();
            editor.restore(memento);
        }
    }
}
```

4. `Client` code to demonstrate the usage

```java
public static void main (String[] args) {
    TextEditor editor = new TextEditor();
    Caretaker caretaker = new Caretaker();
    
    editor.setContent("Version 1");
    caretaker.saveState(editor);

    editor.setContent("Version 2");
    caretaker.saveState(editor);

    editor.setContent("Version 3");
    
    System.out.println("Current Content: " + editor.getContent()); // Version 3
    
    caretaker.restoreState(editor);
    System.out.println("Restored to: " + editor.getContent()); // Version 2

    caretaker.restoreState(editor);
    System.out.println("Restored to: " + editor.getContent()); // Version 1
}
```

<br></br>


## 7. Observer Pattern

### Definition
- A design pattern that defines a one-to-many dependency between objects. 
- When one object (the subject) changes state, all its dependents (observers) are notified and updated automatically.

### Purpose
This pattern is particularly useful for implementing distributed event handling systems.

### Use cases

#### 1. Notification Systems
- **Use Case:** Systems that need to send notifications to multiple users or modules whenever an event occurs.
- **Example:** A stock trading application where various clients (observers) get real-time updates (notifications) on stock price changes from a central server (subject).

#### 2. Logging Frameworks
- **Use Case:** Logging frameworks often use the Observer pattern to allow multiple loggers to observe the execution of code and generate logs in various formats (e.g., file, console, or remote server).
- **Example:** In a server-side application, the log manager (subject) notifies different loggers (observers) whenever an event occurs, so they can log it in different destinations.

#### 3. Social Media Feeds
- **Use Case:** Users (observers) get updates from accounts they follow (subjects) in real-time.
- **Example:** On platforms like Twitter or Instagram, when someone you follow posts new content, you're notified automatically through feeds or notifications.


### Design
- `Subject` interface: the object that holds the state and notifies observers of any changes
- `Observer` interface: the object that gets notified of changes in the subject
- `ConcreteSubject` class: concrete implementation of the subject that maintains the state and notifies observers
- `ConcreteObserver` class: concrete implementation of the observer that reacts to the changes in the subject

### Example
Let's create a simple example where a WeatherStation (the subject) notifies multiple displays (observers) about temperature updates.

### Implementation

1. Create `Observer` interface
```java
public interface Observer {
    void update(float temperature);
}
```

2. Create `Subject` interface
```java
public interface Subject {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}
```

3. Create a `ConcreteSubject` class - WeatherStation
```java
public class WeatherStation implements Subject {
    private List<Observer> observers;
    private float temperature;

    public WeatherStation() {
        observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(temperature);
        }
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
        notifyObservers();
    }
}
```

4. Create a `ConcreteObserver` class - Weather Display

```java
public class WeatherDisplay implements Observer {
    private float temperature;
    
    @Override
    public void update(float temperature) {
        this.temperature = temperature;
        display();
    }

    public void display() {
        System.out.println("Temperature Display: " + temperature + "°C");
    }
}
```

5. Client code to demonstrate the usage

```java
public static void main (String[] args) {
    WeatherStation weatherStation = new WeatherStation();

    WeatherDisplay display1 = new WeatherDisplay();
    WeatherDisplay display2 = new WeatherDisplay();
    
    weatherStation.registerObserver(display1);
    weatherStation.registerObserver(display2);

    weatherStation.setTemperature(25.0f); // "Temperature Display: 25.0°C" x2
    weatherStation.setTemperature(30.0f); // "Temperature Display: 30.0°C" x2
}
```

<br></br>



## 8. State Pattern

### Definition
- A design pattern that allows an object to change its behavior when its internal state changes.
- The key idea is to represent different states as separate classes and make the object delegate behavior to the current state.

### Purpose
This pattern is typically used when an object needs to change its behavior based on its current state, 
without changing the object's class.


### Use cases

#### 1. Vending Machine
- **Use Case:** Vending machines can have different states like `NoCoinState`, `HasCoinState`, and `SoldState`. The behavior of inserting a coin, pressing a button, and dispensing items depends on the machine's current state.
- **Benefit:** The pattern helps in cleanly handling transitions between states and behavior specific to each state.

#### 2. Traffic Light System
- **Use Case:** A traffic light has multiple states such as `GreenState`, `YellowState`, and `RedState`, and each state governs the behavior of the traffic light.
- **Benefit:** The State pattern allows easy switching between these states and encapsulating the behavior of each state in a separate class.

#### 3. Authentication Process
- **Use Case:** An authentication process can have states such as `NotAuthenticatedState`, `AuthenticatedState`, and `LockedState`. The operations allowed (e.g., login, logout, retry) depend on the current state of the user session.
- **Benefit:** Using the State pattern makes it easier to handle user sessions, lock the system after a number of failed attempts, and switch between authenticated and non-authenticated states cleanly.

### Design
- `Context` class: the object whose behavior changes as its internal state changes. It holds a reference to a State object that defines the current state
- `State` interface: an interface that declares methods corresponding to the behavior that varies by state
- `ConcreteState` classes: classes that implement the State interface and define specific behavior for different states.

### Example
Let's design a vending machine that has three states: `NoCoinState`, `HasCoinState`, and `SoldState`. 
The behavior of dispensing items and accepting coins changes based on the machine's state.


### Implementation

1. Create `State` interface for declaring behaviors of different states

```java
public interface State {
    void insertCoin();
    void ejectCoin();
    void pressButton();
    void dispense();
}
```

2. Create Context class (vending machine) which has different states

```java
class VendingMachine {
    private State noCoinState;
    private State hasCoinState;
    private State soldState;

    private State currentState;

    public VendingMachine() {
        noCoinState = new NoCoinState(this);
        hasCoinState = new HasCoinState(this);
        soldState = new SoldState(this);

        currentState = noCoinState;  // Initial state
    }

    public void setState(State state) {
        this.currentState = state;
    }

    public State getNoCoinState() {
        return noCoinState;
    }

    public State getHasCoinState() {
        return hasCoinState;
    }

    public State getSoldState() {
        return soldState;
    }
    
    // delegate behavior to the current state
    public void insertCoin() {
        currentState.insertCoin();
    }

    public void ejectCoin() {
        currentState.ejectCoin();
    }

    public void pressButton() {
        currentState.pressButton();
        currentState.dispense();
    }
}
```

3. Create `ConcreteState` classes - `NoCoinState`, `HasCoinState`, and `SoldState`

```java
public class NoCoinState implements State {
    private VendingMachine vendingMachine;

    public NoCoinState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    public void insertCoin() {
        System.out.println("Coin inserted.");
        vendingMachine.setState(vendingMachine.getHasCoinState());
    }

    public void ejectCoin() {
        System.out.println("No coin to eject.");
    }

    public void pressButton() {
        System.out.println("You need to insert a coin first.");
    }

    public void dispense() {
        System.out.println("No item dispensed.");
    }
}
```

```java
class HasCoinState implements State {
    VendingMachine vendingMachine;
    
    public HasCoinState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }
    
    public void insertCoin() {
        System.out.println("Coin already inserted.");
    }
    
    public void ejectCoin() {
        System.out.println("Coin ejected.");
        vendingMachine.setState(vendingMachine.getNoCoinState());
    }
    
    public void pressButton() {
        System.out.println("Button pressed.");
        vendingMachine.setState(vendingMachine.getSoldState());
    }
    
    public void dispense() {
        System.out.println("No item dispensed.");
    }
}
```


```java
class SoldState implements State {
    VendingMachine vendingMachine;
    
    public SoldState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }
    
    public void insertCoin() {
        System.out.println("Please wait, we're already giving you an item.");
    }
    
    public void ejectCoin() {
        System.out.println("You can't eject the coin, the item is being dispensed.");
    }
    
    public void pressButton() {
        System.out.println("Already pressed the button.");
    }
    
    public void dispense() {
        System.out.println("Item dispensed.");
        vendingMachine.setState(vendingMachine.getNoCoinState());  // Back to no coin state
    }
}
```

4. `Client` code to test the Vending Machine

```java
public static void main(String[] args) {
        VendingMachine vendingMachine = new VendingMachine();
        
        // Testing the behavior of the vending machine in different states
        vendingMachine.insertCoin();  // Coin inserted
        vendingMachine.pressButton();  // Button pressed, item dispensed
        
        vendingMachine.ejectCoin();  // No coin to eject, already in NoCoinState
}
```


<br></br>


## 9. Strategy Pattern

### Definition
- A design pattern that allows you to define a family of algorithms, 
encapsulate each one, and make them interchangeable at runtime.
- The pattern lets the algorithm vary independently of clients that use it.

#### Benefits
* **Flexibility:** You can change algorithms dynamically at runtime.
* **Maintainability:** Adding new algorithms doesn't require modifying the context class.
* **Code Reusability:** Different algorithms are encapsulated in their own classes, making them reusable.


### Purpose
When we want to let the client choose the strategy/algorithm at runtime

* Encapsulation of algorithms: Each algorithm is defined in a separate class.
* Interchangeable strategies: The client can choose any of the available strategies at runtime.
* Open/Closed principle: You can add new strategies without modifying the existing context class.


### Use cases

#### 1. Payment Methods in E-commerce
- **Use Case:** An e-commerce application supports multiple payment methods such as Credit Card, PayPal, and Apple Pay. Based on the user's selection, a different payment strategy should be used.
- **Example:** The strategy pattern can encapsulate different payment algorithms, and at checkout, the system can choose which payment method to apply.

#### 2. Data Validation
- **Use Case:** Applications often need to validate input data, but the validation rules may vary depending on the context (e.g., different countries, types of users, or data formats)
- **Example:** A form validation system that uses different strategies for validating email, phone numbers, and postal addresses based on regional requirements.

#### 3. Discount Calculation in Retail Applications
- **Use Case:** An online retail system may need to calculate discounts based on different criteria (e.g., seasonal discount, membership discount, bulk purchase discount).
- **Example:** The system can apply a different discount strategy for a premium member versus a first-time customer.



### Design
- `Strategy` interface: declares a common method that all concrete strategies must implement
- `ConcreteStrategy` classes: classes that implement the strategy interface and define specific behavior
- `Context` class: the class that uses the `Strategy` interface. It is configured with a strategy object and calls its methods.


### Example
Imagine a scenario where we want to sort a list of numbers using different algorithms 
(e.g., Bubble Sort, Quick Sort, Merge Sort), 
and we want to dynamically choose the sorting strategy at runtime.

### Implementation

1. Create `Strategy` interface

```java
public interface SortStrategy {
    void sort(int[] numbers);
}
```

2. Create `Concrete Strategies` classes - BubbleSort, SelectionSort

```java
public class SelectionSort implements SortStrategy {
    
    @Override
    public void sort (int[] numbers) {
        int n = numbers.length;
        
        for (int i = 0; i<n-1; i++) {
            int minIdx = i;
            for (int j = i+1; j<n; j++) {
                if(numbers[j]<numbers[minIdx]) {
                    minIdx = j;
                }
            }
            
            int temp = numbers[minIdx];
            numbers[minIdx] = numbers[i];
            numbers[i] = temp;
        }

        System.out.println("Sorted using Selection Sort");
    }
}
```

```java
public class BubbleSort implements SortStrategy {
    
    @Override
    public void sort (int[] numbers) {
        int n = numbers.length;
        
        for (int i = 0; i<n-1; i++) {
            for (int j = 0; j<n-i-1; j++) {
                
                if(numbers[j]>numbers[j+1]) {
                    int temp = numbers[j];
                    numbers[j] = numbers[j+1];
                    numbers[j+1] = temp;
                }
            }
        }

        System.out.println("Sorted using Bubble Sort");
    }
}
```

3. Create `Context` Class to switch between sorting strategies

```java
public class SortContext {
    private SortStrategy sortStrategy;

    // Set strategy at runtime
    public void setSortStrategy(SortStrategy sortStrategy) {
        this.sortStrategy = sortStrategy;
    }

    // Sort the array using the selected strategy
    public void executeSortStrategy(int[] numbers) {
        sortStrategy.sort(numbers);
    }
}
```


4. `Client` code to change strategies at runtime

```java
public static void main (String[] args) {
    int[] numbers = { 5, -2, 7, 8, 1, -6, 4};
    
    SortContext context = new SortContext();
    SelectionSort selectionSort = new SelectionSort();
    BubbleSort bubbleSort = new BubbleSort();
    
    context.setSortStrategy(selectionSort);
    context.executeSortStrategy(numbers); // "Sorted using Selection Sort"
    
    context.setSortStrategy(bubbleSort);
    context.executeSortStrategy(numbers); // "Sorted using Bubble Sort"
}
```
<br></br>


## 10. Template Method Pattern

### Definition
- A pattern that defines the skeleton of an algorithm in a base class, but lets subclasses override specific steps of the algorithm without changing its structure. 
- This promotes code reuse by moving common behavior to the parent class and allows flexibility by letting subclasses define custom behavior for individual steps.

#### Benefits
* **Code Reusability:** Common steps are written once in the base class, avoiding duplication.
* **Flexibility:** Subclasses can modify specific steps of the algorithm without changing the overall structure.
* **Consistency:** Ensures that the algorithm's core structure is consistent across different implementations.

### Purpose
Useful in various scenarios where the structure of an algorithm remains the same but individual steps may vary.

### Use cases

#### 1. Frameworks and Libraries
- **Use Case:** When developing frameworks or libraries, it's common to provide a standard workflow or process while allowing users to customize specific parts
- **Example:** A web framework that defines the overall lifecycle of handling HTTP requests (like authentication, authorization, request processing, response generation), but lets developers provide their custom logic for processing specific types of requests.

#### 2. File I/O Operations
- **Use Case:** Reading from or writing to different types of files (e.g., text, binary, CSV) often follows a similar pattern (open, read/write, close), but with different implementations for file-specific behavior.
- **Example:** A file handling system where the processFile() method is defined in the base class and specific file types (text files, binary files) override methods to handle the actual read/write operations.

#### 3. Database Operations
- **Use Case:** When defining database operations, the general flow of connecting to a database, executing a query, and closing the connection is the same, but the specific SQL query or logic may vary
- **Example:** A database framework may define a template method for executing database operations. Subclasses can implement specific operations such as inserting, updating, or deleting data, but the overall process of opening connections and handling transactions remains consistent

### Design
- `Base` class (`abstract` or `concrete`): contains the skeleton of the algorithm in the form of a method, usually marked as `final` to prevent modification. This method calls other methods, some of which may be abstract or have default behavior
- `Concrete` subclasses: override the abstract or optional methods to provide custom behavior for specific steps in the algorithm

### Example
Imagine a game where different players (like a Cricketer or Footballer) need to prepare for a game. 
The steps might include warming up, playing the game, and cooling down. 
The sequence is the same, but the specifics vary depending on the sport.

### Implementation
1. Create the BaseClass

```java
public abstract class Player {
    // Template method
    public final void prepareForGame() {
        warmUp();
        playGame();
        coolDown();
    }

    // Common method, can be overridden if needed
    public void warmUp() {
        System.out.println("General warm-up exercises");
    }

    // Abstract methods that subclasses will implement
    public abstract void playGame();

    // Common method, can be overridden if needed
    public void coolDown() {
        System.out.println("Stretching and cooling down");
    }
}
```

2. Create the `Concrete Subclasses` with the custom method implementations

```java
public class Cricketer extends Player {
    @Override
    public void playGame() {
        System.out.println("Playing cricket: Batting, bowling, fielding");
    }

    @Override
    public void coolDown() {
        System.out.println("Cooling down with light jogging");
    }
}
```

```java
public class Footballer extends Player {
    @Override
    public void playGame() {
        System.out.println("Playing football: Dribbling, passing, shooting");
    }

    @Override
    public void coolDown() {
        System.out.println("Cooling down with a light walk");
    }
}
```

3. `Client` code

```java
public static void main(String[] args) {
        Player cricketer = new Cricketer();
        cricketer.prepareForGame();

        System.out.println();

        Player footballer = new Footballer();
        footballer.prepareForGame();
}
```

<br></br>


## 11. Visitor Pattern

### Definition
A pattern that allows you to add further operations to objects without modifying them. 
It enables you to separate algorithms from the objects on which they operate.

#### Benefits
- **Open/Closed Principle:** You can add new operations (visitors) without modifying the element classes.
- **Separation of concerns:** Operations are separated from the objects they operate on.

#### Disadvantages
- If the object structure frequently changes (new element types are added), you will need to modify all visitors to accommodate the new element.


### Purpose
This pattern is particularly useful when you have a complex object structure 
and need to perform operations on it that are subject to frequent change.

### Use cases

#### 1. UI Component Trees
- **Problem:** A UI framework has different types of components (buttons, text fields, containers), and operations like rendering, accessibility checking, or event handling need to be performed on them.
- **Use Case:** Using the visitor pattern allows these operations to be added or modified without altering the component classes.
- **Example:** Components like `Button`, `TextField`, `Container` accept visitors for operations such as rendering or validation of user inputs.

#### 2. Object Serialization and Deserialization
- **Problem:** You need to serialize or deserialize different object types (e.g., shapes, text, images) to various formats (e.g., JSON, XML)
- **Use Case:** Implementing different visitors to handle the serialization or deserialization logic for each format without changing the object structure.
- **Example:** `Shape`, `Image`, `TextBlock` objects can accept visitors that serialize them to formats like JSON or XML.

#### 3. 
### Design

- `Visitor`: an interface or abstract class that declares a visit method for each type of element in the object structure. It moves from element to element and performs some operations.
- `Concrete Visitor`: classes that implement/extend the operations defined in the Visitor interface for each element
- `Element`: an interface that defines an accept() method. Each concrete element class implements this method, allowing a visitor to perform an operation on it
- `Concrete Element`: classes that implement the accept() method as per the requirement
- `Object Structure`: collection of elements that the visitor will traverse


### Example
Suppose we have a system with different types of files 
(e.g., TextFile, ImageFile, VideoFile) that we want to perform operations on, 
such as compression or rendering. 

**We want to avoid changing the file classes each time we add a new operation.**


### Implementation

1. Create the `Visitor` interface/abstract class

```java
public interface Visitor {
    void visit (TextFileElement textFile);
    void visit (ImageFileElement imageFile);
    void visit (VideoFileElement videoFile);
}
```

2. Create the `Element` interface (File Base) that declares the `accept()` method for element implementations

```java
public interface FileElement {
    void accept(Visitor visitor);
}
```

3. Create the `Concrete Element` classes (File Types) with accept() implementations

```java
public class TextFileElement implements FileElement {
    private String content;
    
    public TextFileElement (String content) {
        this.content = content;
    }
    
    public String getContent() {
        return content;
    }
    
    @Override
    public void accept (Visitor visitor) {
        visitor.accept(this);
    }
}
```


```java
public class ImageFileElement implements FileElement {
    private String resolution;
    
    public ImageFileElement (String resolution) {
        this.resolution = resolution;
    }
    
    public String getResolution() {
        return resolution;
    }
    
    @Override
    public void accept (Visitor visitor) {
        visitor.accept(this);
    }
}
```


```java
public class VideoFileElement implements FileElement {
    private String duration;
    
    public VideoFileElement (String duration) {
        this.duration = duration;
    }
    
    public String getDuration() {
        return duration;
    }
    
    @Override
    public void accept (Visitor visitor) {
        visitor.accept(this);
    }
}
```

4. Create `Concrete Visitor` classes to define the operations to perform (rendering & compressing files)

```java
public class CompressingVisitor implements Visitor {
    @Override
    void visit (TextFileElement textFile) {
        System.out.println("Compressing text file with content: " + textFile.getContent());
    }

    @Override
    void visit (ImageFileElement imageFile) {
        System.out.println("Compressing text file with resolution: " + imageFile.getResolution());
    }

    @Override
    void visit (VideoFileElement videoFile) {
        System.out.println("Compressing text file with duration: " + videoFile.getDuration);
    }
}
```

```java
public class RenderingVisitor implements Visitor {
    @Override
    void visit (TextFileElement textFile) {
        System.out.println("Rendering text file with content: " + textFile.getContent());
    }

    @Override
    void visit (ImageFileElement imageFile) {
        System.out.println("Rendering text file with resolution: " + imageFile.getResolution());
    }

    @Override
    void visit (VideoFileElement videoFile) {
        System.out.println("Rendering text file with duration: " + videoFile.getDuration);
    }
}
```
 
5. `Client` code to demonstrate the usage

```java
public static void main (String[] args) {
    
    // create the object structure (collection of elements)
    FileElement[] files = new FileElement[] {
            new TextFileElement("Hello world"),
            new ImageFileElement("1920x1080"),
            new VideoFileElement("2 hours")
    };

    FileVisitor compressionVisitor = new CompressionVisitor();
    FileVisitor renderingVisitor = new RenderingVisitor();

    // Apply compression to all files
    System.out.println("Applying Compression Visitor:");
    for (FileElement file : files) {
        file.accept(compressionVisitor);
    }

    // Apply rendering to all files
    System.out.println("\nApplying Rendering Visitor:");
    for (FileElement file : files) {
        file.accept(renderingVisitor);
    }
}
```
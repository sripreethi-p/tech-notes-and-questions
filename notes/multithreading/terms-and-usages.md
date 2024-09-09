# Terms and Usages

## 1. `synchronized`
### Usage
Used to achieve thread safety by allowing only one thread to access a particular block of code or method at a time. It ensures that a critical section of code is not concurrently accessed by multiple threads.
### Example
```java
public synchronized void method() {
    // Critical section of code
}

// Or synchronized block
public void method() {
    synchronized(this) {
        // Critical section of code
    }
}
```

## 2. `volatile`
### Usage
Used to mark a variable as "volatile," ensuring that every read of the variable will be directly from memory, and not from a cached copy. This helps in ensuring visibility of shared data between threads.
```java
private volatile boolean flag = true;

public void stopThread() {
    flag = false;
}
```

## 3. `wait()`
### Usage
A method called on a monitor object (typically within a synchronized block) to make the current thread release the lock (so other threads can use it) and go into a waiting state until another thread calls notify() or notifyAll() on the same object.
### Example
```java
synchronized (lock) {
    lock.wait();  // Current thread waits until notified
}
```

## 4. `notify()` and `notifyAll()`
### Usage
These methods are used to wake up threads that are waiting on a monitor object. notify() wakes up one waiting thread, while notifyAll() wakes up all waiting threads.
### Example
```java
synchronized (lock) {
    lock.notify();  // Wake up one waiting thread
}
```

## 5. `Thread` Class
### Usage
This class represents a thread in Java. You can create a new thread by extending the Thread class or by implementing the Runnable interface and passing it to a Thread object.
### Example

#### Extending `Thread` class
```java
class MyThread extends Thread {
    public void run() {
        // Code to be executed by the thread
    }
}

MyThread thread = new MyThread();
thread.start();  // Start the thread
```

#### Implementing `Runnable` interface
```java
public class CustomThreadRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("Entered Custom Thread implementing Runnable's run method");
    }
}
```

## 6. `Runnable` Interface
### Usage
Used to create a thread by implementing the run() method. 
It allows for more flexibility as a class can implement Runnable and extend another class at the same time.
### Example
```java
class MyRunnable implements Runnable {
    public void run() {
        // Code to be executed by the thread
    }
}

Thread thread = new Thread(new MyRunnable());
thread.start();  // Start the thread
```

## 7. `join()`
### Usage
This method makes one thread wait for the completion of another thread. 
When you call `join()` on a thread, the current thread will block until the thread on which `join()` was called finishes.

### Example
```java
Thread thread = new Thread(() -> {
    // Some work
});
thread.start();
thread.join();  // Wait for this thread to finish
```


## 8. `sleep()`
### Usage
Makes the current thread sleep for a specified duration of time (in milliseconds), causing it to temporarily cease execution.
But it still holds the lock while sleep unlike `wait()` if in synchronized block.
### Example
```java
try {
    Thread.sleep(1000);  // Sleep for 1 second
} catch (InterruptedException e) {
    e.printStackTrace();
}
```


## 9. `yield()`
### Usage
This method pauses the currently executing thread to allow other threads of the same priority to execute. 
It's a suggestion to the thread scheduler that the current thread is willing to yield its current use of a CPU.
### Example
```java
Thread.yield();  // Suggest to yield execution to other threads
```

## 10. `ExecutorService` and `Executors`
### Usage
Part of the java.util.concurrent package, ExecutorService provides a higher-level replacement for working with threads. 
It manages thread pools and offers a cleaner and more efficient way to execute asynchronous tasks.
### Example
```java
ExecutorService executor = Executors.newFixedThreadPool(10);
executor.submit(() -> {
    // Task to be executed
});
executor.shutdown();
```

## 11. `Callable` and `Future`
### Usage
`Callable` is similar to `Runnable` but can return a result. 
`Future` represents the result of an asynchronous computation. 
You can retrieve the result of a `Callable` using a `Future`.
### Example
```java
Callable<Integer> callable = () -> {
    return 123;
};

ExecutorService executor = Executors.newSingleThreadExecutor();
Future<Integer> future = executor.submit(callable);

Integer result = future.get();  // Blocks until result is available
executor.shutdown();
```

## 12. `ReentrantLock`
### Usage
A more flexible and powerful locking mechanism compared to `synchronized`. 
It allows for explicit lock management with features like fairness policies and the ability to interrupt threads waiting to acquire the lock.
### Example
```java
ReentrantLock lock = new ReentrantLock();
lock.lock();
try {
    // Critical section of code
} finally {
    lock.unlock();
}
```

## 13. `CountDownLatch`
### Usage
A synchronization aid that allows one or more threads to wait until a set of operations being performed in other threads completes. 
It is used when you want to wait for multiple threads to complete before proceeding.

### Example
```java
CountDownLatch latch = new CountDownLatch(3);

for (int i = 0; i < 3; i++) {
    new Thread(() -> {
        // Do some work
        latch.countDown();  // Decrement the count
    }).start();
}

latch.await();  // Wait for the count to reach zero
```

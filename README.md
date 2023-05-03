# Concurrency-Java


<h1>Introduction to Concurrency/Threads</h1>
This is an introduction to Concurrency using Java<br />


<h2>Basic key Terms</h2>

<p>First of all, let’s define a few key terms:</p>
<p>A process is a unit of execution that has its own memory space. Each instance of a JVM runs as a process (for the most part), when we run a Java application, we are starting a process. In many cases, the term process and application are interchangeably, when we run more than one Java application, each will have its own memory space of heap. </p>
<p>A thread is a unit of executing within a process. Each process (or application) can have multiple threads. We want to use threads because they do not require as many resources as creating a new process. Every thread created within a process shares the same memory (which can be a good or bad thing). Each Thread has its own thread stack, which is the memory that only that thread can use. 
</p>

<h2>Why would we use multiple thread in our application?</h2>

<p>Sometimes, we want to perform a task that’s going to take a long time, we could use the main thread to do so, but the code within the main thread execute in a linear fashion, meaning that the rest of the code will have to wait for the task to be finish to execute. Another reason is because an API requires us to provide one. Sometimes we have to provide the code that will run when a method we have called reaches a certain point. </p>
<p>However, it not all good news, there may be some problems that rise when using multiple threads, such as a DeadLock. A deadlock is when all processes are waiting for an event which another process in the same set hast to cause. For example, Thread A is waiting for Thread B, but at the same time, Thread B is waiting for Thread A, in this case, both thread will be stuck for ever and non of them will ever finish. We will se an example of this later in this guide. 
</p>

<h2>How to create a Thread.</h2>

<p>There are many ways to create threads:</p> 
<p>	1) One method is by creating a class that extends Thread as seen below, note that you MUST implement run().  </p>

```Java
public class AnotherThread extends Thread {
    @Override
    public void run(){
        System.out.println("Hello from Another Thread");
    }
}
```
<p>now if we want to run the thread on main we would use:</p> 

```Java
Thread anotherThread = new AnotherThread();
anotherThread.start();
```

<p>^Note that we use method “start” to start run method, and not run itself. </p> 

<p>2) Create an anonymous class as seen below: </p> 

```Java
new Thread(){
    public void run(){
        System.out.println("Hello from anonymous class thread");
    }
}.start();
```
note that we need to finish anonymous class with .start() to the thread can run.

<p>3) Create a class that implements Runnable: </p> 

```Java
class AnotherThread implements Runnable {
    @Override
    public void run(){
        System.out.println("Hello from Another Thread using Runnable");
    }
}
```
now we can start that thread in main using: 

```Java
Thread runnableThread = new Thread(new AnotherThread());
runnableThread.start();
```

<p></p> 

<h2>Thread Exercices: </h2>

 **Exercice One: ThreadExampleOne class**  
<p>Using BankAccount class (given) with a balance of 1000, let’s create two threads, one thread will deposit 300 and then withdraw 50; The second thread will deposit 200 and then withdraw 100 </p>

```java
public class ThreadExampleOne {
    public static void main(String[] args){

        BankAccount account = new BankAccount("123-456", 1000.00);

        Thread thread1 = new Thread(){
            public void run(){
                account.deposit(300.00);
                account.withdraw(50.00);
            }
        };

        Thread thread2 = new Thread(){
            public void run(){
                account.deposit(200.00);
                account.withdraw(100.00);
            }
        };
        thread1.start();
        thread2.start();
    }
}
```
In this class we can see how to inititate 2 threads using nested classes and then starting them. You may have notice that this way of using threads can cause problems, one problem of using threads is that one thread can access a method at the same time as the other thread, this could cause huge problems in the code. To solve that we can creat Thread Safe methods or block code, where one thread will have to wait until the other thread is done with the method or block code. 

**Exercice Two: BankAccountThreadSafe class**  
<p> Let’s make exercise one ThreadSafe, where one thread will wait for the other thread to be done to work on BankAccount. There are 2 ways that we can solve this execrice</p>
<p> 1) Using the word “synchronized” in a methods name, this makes the method able to be used only by one thread at the time. If a second thread wants to use the same method, this thread will wait until the first thread is finished. This will make the whole method syncronized</p>

```java
//synchronized whole method
    public synchronized void deposit(double amount) {
        balance += amount;
    }
```
<p>2) Sometimes we do not want to synchronized, and we want just a specific block code to be synchronized, to do so we can use the synchronized() method <\p>

```java
    //synchronized only block code
    public  void withdraw(double amount) {
        synchronized (this){
            balance -= amount;
        }
    }
```
    
**Exercice Three: BankAccountReentrantLock class**  
    
Another way to synchronize a method is by using ReentrantLock. To use ReentrantLock we need to create a lock object and use it to lock() the block code, once the block code runs, we need to unlock() the block code so another thread can use it.
    
```java
     public void deposit(double amount) {
       lock.lock();
       try{
           balance += amount;
       } finally {
            lock.unlock();
       }
    }
    
     public  void withdraw(double amount) {
        lock.lock();
        try{
            balance -= amount;
        } finally {
            lock.unlock();
        }
    }
```
Note: notice that we need to use try-finally block, this is the recommended way to use locks. We also need to create a class variable Lock which also needs to be Instantiated in the constructor 
    
**Exercice Four: ThreadExampleTwoDeadLock   class**  
 <p>As I said before, one problem with threads is that we can create deadlocks, deadlocks is when …
In the class ThreadExampleTwoDeadLock this is a possible path that the threads can takeasd: </p>
    

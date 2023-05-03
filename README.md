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

- Windows 10</b> (21H2)
<p>There are many ways to create threads:</p> 
<p>	one method is by creating a class that extends Thread as seen below, note that you MUST implement run().  </p>
```
public class AnotherThread extends Thread {
    @Override
    public void run(){
        System.out.println("Hello from Another Thread");
    }
}
```


<h2>List of Prerequisites</h2>

<br />

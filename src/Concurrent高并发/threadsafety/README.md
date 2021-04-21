# What is Thread-Safety and How to Achieve it?（什么是线程安全，我们又怎么去实现它）

Last modified: April 17, 2020

by [Alejandro Ugarte](https://www.baeldung.com/author/alejandro-ugarte/) 

Translater：ChangKongYi

## **1. Overview概述**

Java supports multithreading out of the box. This means that by running bytecode concurrently in separate worker threads, the [JVM](https://www.baeldung.com/jvm-vs-jre-vs-jdk) is capable of improving application performance.

**Java支持开箱即用（out of the box）的多线程。JVM的优化能够提高应用程序性能, 这也意味着通过在单独的工作线程中同时运行字节码。**

Although multithreading is a powerful feature, it comes at a price. In multithreaded environments, we need to write implementations in a thread-safe way.

**尽管多线程是一项强大的功能，但是是需要付出一定的代价。 在多线程环境中，我们需要有方法的去实现线程安全**

 This means that different threads can access the same resources without exposing erroneous behavior or producing unpredictable results. **This programming methodology is known as “thread-safety”.**

这意味着不同的线程可以访问相同的资源，而不会暴露错误的行为或产生不可预测的结果。 **这种编程方法被称为“线程安全”。**

In this tutorial, we'll look at different approaches to achieve it.

**在这个教程里，我们将在可以下方看多种实现线程安全的方式**

## **2. Stateless Implementations（无状态实现）**

In most cases, errors in multithreaded applications are the result of incorrectly （错误地导致的结果）sharing state between several threads. 

在大多数情况下，多线程应用程序中的错误是错误地在多个线程之间共享状态的结果。

Therefore, the first approach that we'll look at is to achieve thread-safety **using stateless implementations**.

因此，我们要研究的第一种方法是**使用无状态实现**来实现线程安全。

To better understand this approach, let's consider（考虑） a simple utility class with a static method that calculates the factorial of a number:

**为了更好的了解这个方式，  让我们考虑实现一个带有静态方法的简单实用程序类，该方法可计算数字的阶乘：**

```java
public class MathUtils {
    
    public static BigInteger factorial(int number) {
        BigInteger f = new BigInteger("1");
        for (int i = 2; i <= number; i++) {
            f = f.multiply(BigInteger.valueOf(i));
        }
        return f;
    }
}
```

**The \*factorial()\* method is a stateless deterministic function.** Given a specific input, it always produces the same output.

**这个factorial方法是无状态的确定性函数。给定特定输入后，它始终会产生相同的输出**（也就是说每一个线程访问这个factorial方法都会有一个自己特定的值 而不是在一个特定值上进行计算） 

The method **neither relies on external state nor maintains state at all**. Hence, it's considered to be thread-safe and can be safely called by multiple threads at the same time.

**该方法既不依赖于外部状态，也不完全保持状态。 因此，它被认为是线程安全的，并且可以同时被多个线程安全地调用。** 

All threads can safely call the *factorial()* method and will get the expected result without interfering with each other and without altering the output that the method generates for other threads.

**所有线程都可以安全地调用 factorial（）方法，并且将获得预期结果，而不会互相干扰，也不会更改该方法为其他线程生成的输出。**

Therefore, **stateless implementations are the simplest way to achieve thread-safety**.

因此，无状态实现是实现线程安全最简单的方式

## **3. Immutable Implementations（不可变实现）**

**Immutable objects** are instances whose state doesn’t change after it has been initialized. For example, [String](https://www.journaldev.com/16928/java-string) is an immutable class and once instantiated its value never changes.

**不可变的对象是实例，其状态在初始化后不会改变。 例如，[String]是一个不可变的类，一旦实例化，其值就永远不会改变。**

**If we need to share state between different threads, we can create thread-safe classes by making them immutable**.

**如果我们需要在不同线程之间共享状态，则可以通过使它们的值不可变来创建线程安全类**。

Immutability is a powerful, language-agnostic concept and it's fairly easy to achieve in Java.

**不变性是一个功能强大，与语言无关的概念，在Java中相当容易实现。**

To put it simply, **a class instance is immutable when its internal state can't be modified after it has been constructed**.

简而言之，**类实例在构造后无法修改其内部状态时便是不可变的**。

The easiest way to create an immutable class in Java is by declaring all the fields *private* and *final* and not providing setters:

**在Java中创建不可变类的最简单方法是声明所有字段* private 和 final *而不提供setter：**

```java
public class MessageService {
    
    private final String message;//here
 
    public MessageService(String message) {
        this.message = message;
    }
    
    // standard getter
    
}
```

A *MessageService* object is effectively immutable since its state can't change after its construction. Hence, it's thread-safe.

**一个MessageService对象实际上是不可变的， 自从他初始化后便不能再修改他的状态，因此他是线程安全的。**

Moreover, if *MessageService* were actually mutable, but multiple threads only have read-only access to it, it's thread-safe as well.

**而且，如果MessageService 实际上是可以改变的，但是多个线程只有读取的权限，那么他也是线程安全的。**

Thus, **immutability is just another way to achieve thread-safety**.

**因此，不可变只是另一种实现线程安全的方式**

## **4. Thread-Local Fields（线程局部字段）**

In object-oriented programming (OOP), objects actually need to maintain state through fields and implement behavior through one or more methods.

**在面向对象编程(OOP）中，对象实际上需要通过字段维护其状态并通过一种或多种方法来实现行为。**

If we actually need to maintain state, **we can create thread-safe classes that don't share state between threads by making their fields thread-local.**

**如果我们真的需要去保持状态，我们可以通过将其字段设置为线程局部来创建不共享线程状态的线程安全类**

We can easily create classes whose fields are thread-local by simply defining private fields in *[Thread](https://docs.oracle.com/javase/8/docs/api/java/lang/Thread.html)* classes.

**我们可轻松的创建一个定义了线程局部字段且私有的字段的线程类**

**通过简单地在Thread类中定义私有字段，我们可以轻松创建一个其字段为线程局部的类。**

We could define, for instance（例如）, a *Thread* class that stores an *array* of *integers*:

**例如，我们可以定义一个Thread 类，该类存储integers 的一个array ：**

```java
public class ThreadA extends Thread {
    
    private final List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
    
    @Override
    public void run() {
        numbers.forEach(System.out::println);
    }
}
```

While another one might hold an *array* of *strings*:

**而另一个可能是带有  string  的  array  ：**

```java
public class ThreadB extends Thread {
    
    private final List<String> letters = Arrays.asList("a", "b", "c", "d", "e", "f");
    
    @Override
    public void run() {
        letters.forEach(System.out::println);
    }
}
```

**In both implementations, the classes have their own state, but it's not shared with other threads. Thus, the classes are thread-safe.**

**在两种实现上，这些类都拥有他们自己的状态，但是它的这些状态是不会和其他线程进行共享，因此这些类都是线程安全的。**

Similarly, we can create thread-local fields by assigning（分配） *[ThreadLocal](https://www.baeldung.com/java-threadlocal)* instances to a field.

**同样，我们可以通过将ThreadLocal实例分配给一个字段来创建线程本地字段。**

Let's consider, for example, the following *StateHolder* class:

**让我们思考一下，举个例子，下面的StateHolder 类**

```java
public class StateHolder {
    
    private final String state;
 
    // standard constructors / getter
}
```

We can easily make it a thread-local variable as follows:

**我们可以很简单将它入下面一样变成一个线程本地的变量**

```java
public class ThreadState {
    
    public static final ThreadLocal<StateHolder> statePerThread = new ThreadLocal<StateHolder>() {
        
        @Override
        protected StateHolder initialValue() {//初始化
            return new StateHolder("active");  
        }
    };
 
    public static StateHolder getState() {
        return statePerThread.get();
    }
}
```

Thread-local fields are pretty much like normal class fields, except that each thread that accesses them via a setter/getter gets an independently initialized copy of the field so that each thread has its own state.

**线程本地字段与普通类字段非常相似，除了通过setter / getter访问它们的每个线程都会获得该字段的独立初始化副本之外，以便每个线程都有自己的状态。** 

## **5. Synchronized Collections（同步集合）**

We can easily create thread-safe collections by using the set of synchronization wrappers included within the [collections framework](https://docs.oracle.com/javase/8/docs/technotes/guides/collections/overview.html).

**通过使用集合框架中包含的一组同步包装  ，我们可以轻易的创建一个线程安全的集合**

We can use, for instance, one of these [synchronization wrappers](https://www.baeldung.com/java-synchronized-collections) to create a thread-safe collection:

**例如，我们可以使用以下同步包装之一来创建线程安全的集合：**

```java
Collection<Integer> syncCollection = Collections.synchronizedCollection(
    new ArrayList<>());
Thread thread1 = new Thread(
    () -> syncCollection.addAll(Arrays.asList(1, 2, 3, 4, 5, 6)));
Thread thread2 = new Thread(
    () -> syncCollection.addAll(Arrays.asList(7, 8, 9, 10, 11, 12)));
thread1.start();
thread2.start();
```

Let's keep in mind that synchronized collections use intrinsic locking in each method (we'll look at intrinsic locking  later).

**让我们厘清一个概念，就是同步集合在每种方法中都有使用内部锁定（我们将在后面介绍内部锁定）**

**This means that the methods can be accessed by only one thread at a time, while other threads will be blocked until the method is unlocked by the first thread.**

**这便意味着这个方法能够使得在同一时间里只通过一个线程访问请求，然而其他的线程将会被阻塞直至这个方法被第一个线程解锁**

Thus, synchronization has a penalty in performance, due to the underlying logic of synchronized access.

**因此，由于同步访问的基本逻辑，同步的时候也会降低程序性能。**

## **6. Concurrent高并发 Collections（并发集合）**

Alternatively to synchronized collections, we can use concurrent collections to create thread-safe collections.

**除了同步集合之外，我们也可以使用并发集合来创建一个线程安全的集合**

Java provides the *[java.util.concurrent](https://docs.oracle.com/javase/8/docs/api/?java/util/concurrent/package-summary.html)* package, which contains several concurrent collections, such as *[ConcurrentHashMap](https://docs.oracle.com/javase/8/docs/api/?java/util/concurrent/package-summary.html)*:

**java提供了这个XXX包，其中包括了多个并发集合，例如XXX；**

```java
Map<String,String> concurrentMap = new ConcurrentHashMap<>();
concurrentMap.put("1", "one");
concurrentMap.put("2", "two");
concurrentMap.put("3", "three");
```

Unlike their synchronized counterparts**, concurrent collections achieve thread-safety by dividing their data into segments**. 

**与同步对象不同，并发集合通过将其数据划分为多个段来实现线程安全**

In a *ConcurrentHashMap*, for instance, several threads can acquire locks on different map segments, so multiple threads can access the *Map* at the same time.

**例如，在ConcurrentHashMap 中，多个线程可以获取不同映射段上的锁，所以多个线程可以同时访问这个map** 

**Concurrent高并发 collections are** **much more performant than synchronized collections**, due to the inherent advantages of concurrent thread access.

**由于并发线程访问的固有优势，并发集合比同步的集合具有更高的性能。**

It's worth mentioning that **synchronized and concurrent collections only make the collection itself thread-safe and not the contents**.

**值得一提的是，同步集合和并发集合仅使集合本身具有线程安全性，而不使其内容变得线程安全。**嗯？？？😨

## 7. Atomic Objects（原子性对象）

It's also possible to achieve thread-safety using the set of [atomic classes](https://www.baeldung.com/java-atomic-variables) that Java provides, including *[AtomicInteger](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/atomic/AtomicInteger.html)*, *[AtomicLong](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/atomic/AtomicLong.html)*, *[AtomicBoolean](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/atomic/AtomicBoolean.html)*, and *[AtomicReference](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/atomic/AtomicReference.html)*.

**使用java提供的原子类也是可以实现线程安全，他们包括XXXX**

**Atomic classes allow us to perform atomic operations, which are thread-safe, without using synchronization**. An atomic operation is executed in one single machine level operation.

**原子类可以允许我们进行没有同步并且线程安全的原子性操作原子操作在单个机器级别的操作中执行。**

To understand the problem this solves, let's look at the following *Counter* class:

**为了更好的了解和解决这个问题，让我们关注下面的 Counter类**

```java
public class Counter {
    
    private int counter = 0;
    
    public void incrementCounter() {
        counter += 1;
    }
    
    public int getCounter() {
        return counter;
    }
}
```

**Let's suppose that in a race condition, two threads access the \*incrementCounter()\* method at the same time.**

**假设在竞争条件下，两个线程同时访问\ * incrementCounter（）\ *方法。**

In theory, the final value of the *counter* field will be 2. But we just can't be sure about the result, because the threads are executing the same code block at the same time and incrementation is not atomic.

**理论上，* counter *字段的最终值为2。但是我们不能确定结果，因为线程同时执行在同一代码块时，而且增量不是原子性的。**

Let's create a thread-safe implementation of the *Counter* class by using an *AtomicInteger* object:

**让我们使用一个原子对象去实现一个线程安全的counter 类**

```java
public class AtomicCounter {
    
    private final AtomicInteger counter = new AtomicInteger();
    
    public void incrementCounter() {
        counter.incrementAndGet();
    }
    
    public int getCounter() {
        return counter.get();
    }
}
```

**This is thread-safe because, while incrementation, ++, takes more than one operation, \*incrementAndGet\* is atomic**.

 **它是线程安全的，因为它进行++的时候比以往多了一些其他的操作，使得自增是原子性的操作**

## **8. Synchronized Methods（同步方法）**

While the earlier approaches are very good for collections and primitives, we will at times need greater control than that.

**尽管之前的方法对于集合和原函数非常有用，但有时我们需要的控制权要远强于此。**

So, another common approach that we can use for achieving thread-safety is implementing synchronized methods.

**因此，可用于实现线程安全的另一种常见方法是实现同步方法。**

Simply put**, only one thread can access a synchronized method at a time while blocking access to this method from other threads**. Other threads will remain blocked until the first thread finishes or the method throws an exception.

**简而言之，在一时间内只有一个线程允许访问同步方法那么其他的想要访问方法的线程多会被阻塞，其他的线程将会一直阻塞直到出现第一个线程执行完成或者报错**

We can create a thread-safe version of *incrementCounter()* in another way by making it a synchronized method:

**使用同步方法作为另一种方式去实现一个线程安全版本的 IncrementCount（）**

```java
public synchronized void incrementCounter() {
    counter += 1;
}
```

We've created a synchronized method by prefixing the method signature（签名） with the [*synchronized*](https://www.baeldung.com/java-synchronized) keyword.

**我们通过在方法签名之前添加synchornized关键字来创建一个同步方法。**

Since one thread at a time can access a synchronized method, one thread will execute the *incrementCounter()* method, and in turn, others will do the same. No overlapping execution will occur whatsoever.

**由于一个同步方法一次只允许一个线程访问，因此一个线程将执行* incrementCounter（）*方法，而其他线程将执行相同的方法。 任何重叠的执行都不会发生。**

**Synchronized methods rely on the use of “intrinsic locks” or “monitor locks”**. An intrinsic lock is an implicit internal entity associated with a particular class instance.

**同步方法的实现依靠“内部锁”或“监视器锁”** ，内部锁是与特定类实例关联的隐式内部实体。

In a multithreaded context, the term *monitor* is just a reference to the role that the lock performs on the associated object, as it enforces exclusive access to a set of specified methods or statements.

**在多线程上下文中，术语monitor只是对锁对关联对象执行的角色的引用，因为它强制对一组指定的方法或语句进行独占访问。**

**When a thread calls a synchronized method, it acquires the intrinsic lock.** 

**当一个线程调用了同步方法，它便获得了固有锁**

After the thread finishes executing the method, it releases the lock, hence allowing other threads to acquire the lock and get access to the method.

**当这个线程成功执行完这个方法，它便会释放这个锁，因此允许其他的线程获得这个锁去访问这个方法**

We can implement synchronization in instance methods, static methods, and statements (synchronized statements).

**我们可以实现 实例方法同步、静态方法同步，和同步语句**

## **9. Synchronized Statements（同步语句）**

Sometimes, synchronizing an entire method might be overkill if we just need to make a segment of the method thread-safe.

**有时，如果我们只需要使方法的一部分成为线程安全的，那么同步整个方法可能就显得过分了。**

To exemplify this use case, let's refactor the *incrementCounter()* method:

**为了说明这个用例，让我们重构incrementCounter（）方法：**

```java
public void incrementCounter() {
    // additional unsynced operations
    synchronized(this) {
        counter += 1; 
    }
}
```

The example is trivial（不重要）, but it shows how to create a synchronized statement. 

**这个例子很简单，但是它向我们展示了如何创建一个同步语句**

Assuming（假设） that the method now performs a few additional operations, which don't require synchronization, we only synchronized the relevant state-modifying section by wrapping it within a *synchronized* block.

**假设该方法现在执行一些不需要同步的附加操作，我们仅通过将相关的状态修改部分包装在* synchronized *块中来进行同步。**

Unlike synchronized methods, synchronized statements must specify the object that provides the intrinsic lock, usually the [*this*](https://www.baeldung.com/java-this) reference. 

**与同步方法不同，同步语句必须指定一个提供内部锁的对象，通常是引用 this 。**

**Synchronization is expensive, so with this option, we are able to only synchronize the relevant parts of a method**.

**同步非常耗性能，因此使用此选项，我们最好只同步方法的相关部分**。

### 9.1. Other Objects as a Lock（其他对象锁）

We can slightly improve the thread-safe implementation of the *Counter* class by exploiting another object as a monitor lock, instead of *this.*

**我们可以通过将另一个对象用作监视器锁而不是 this  ，来稍微改善  Counter  类的线程安全实现。**（那么这个对象和this有和不同呢）

Not only does this provide coordinated access to a shared resource in a multithreaded environment, **but also it uses an external entity to enforce exclusive access to the resource**:

**这不仅可以在多线程环境中提供对共享资源的协调访问，而且还使用外部实体来强制对资源进行独占访问**：

```java
public class ObjectLockCounter {
 
    private int counter = 0;
    private final Object lock = new Object();
    
    public void incrementCounter() {
        synchronized(lock) {
            counter += 1;
        }
    }
    
    // standard getter
}
```

We use a plain [*Object*](https://docs.oracle.com/javase/8/docs/api/java/lang/Object.html) instance to enforce mutual exclusion. This implementation is slightly better, as it promotes security at the lock level.

**我们使用一个普通的Object实例来强制相互排斥。 此实现稍好一些，因为它可以提高锁定级别的安全性。**

When using *this* for intrinsic locking, **an attacker could cause a deadlock by acquiring the intrinsic lock and triggering a denial of service (DoS) condition.**

**当使用 this 进行内部锁定时， 攻击者可能会通过获取内部锁定并触发拒绝服务（DoS）条件来导致死锁。**

On the contrary, when using other objects, **that private entity is not accessible from the outside.** This makes it harder for an attacker to acquire the lock and cause a deadlock.

**相反，在使用其他对象时，无法从外部访问该私有实体。 这使攻击者更难获得锁并造成死锁。**

### 9.2. Caveats（注意事项）

Even though we can use any Java object as an intrinsic lock, we should avoid using *Strings* for locking purposes:

**即使我们可以将任何Java对象用作内部锁定，也应避免出于锁定目的而使用* Strings *：**

```java
public class Class1 {
    private static final String LOCK  = "Lock";
 
    // uses the LOCK as the intrinsic lock
}
 
public class Class2 {
    private static final String LOCK  = "Lock";
 
    // uses the LOCK as the intrinsic lock
}
```

At first glance, it seems that these two classes are using two different objects as their lock. 

**乍一看，他好像是这个两个类使用了两个不同的对象作为了他们的锁**

However, **because of [string interning](https://www.baeldung.com/string/intern), these two “Lock” values may actually refer to the same object on the [string pool](https://www.baeldung.com/java-string-pool)**. That is, the *Class1* and *Class2* are sharing the same lock!

**但是，由于字符串interning，这两个“ Lock”值实际上可能引用字符串池上的同一对象。 也就是说，* Class1 *和* Class2 *共享着一个相同的锁！**

This, in turn, may cause some unexpected behaviors in concurrent contexts.

**反过来，这可能会导致在并发上下文中发生某些意外行为。**

In addition to *Strings,* **we should avoid using any [cacheable or reusable](https://mail.openjdk.java.net/pipermail/valhalla-spec-observers/2020-February/001199.html) objects as intrinsic locks**. 

**除了字符串之外，我们还应避免将任何可缓存或可重用的对象用作内部锁。**

For example, the [*Integer.valueOf()* ](https://github.com/openjdk/jdk/blob/8c647801fce4d6efcb3780570192973d16e4e6dc/src/java.base/share/classes/java/lang/Integer.java#L1062)method caches small numbers. Therefore, calling *Integer.valueOf(1)* returns the same object even in different classes.

**例如，Integer.valueOf（）方法缓存少量数字。 因此，即使在不同的类中，调用Integer.valueOf（1）也会返回相同的对象。**

## **10. Volatile Fields（Volatile字段）**

Synchronized methods and blocks are handy for addressing （很容易解决） variable visibility problems among（之间） threads. 

**同步的方法和块非常适合解决线程之间的可变可见性问题。**

Even so, the values of regular class fields might be cached by the CPU. Hence, consequent updates to a particular field, even if they're synchronized, might not be visible to other threads.

**即使这样，常规类字段的值也可能会被CPU缓存。 因此，即使是同步的，对特定字段的后续更新也可能对其他线程不可见。（也就说会出现线程不安全 造成r/w数值错误）**

To prevent this situation, we can use [*volatile*](https://www.baeldung.com/java-volatile) class fields:

**为了避免这个情况，我们可以使用volatile类字段**

```java
public class Counter {
 
    private volatile int counter;
 
    // standard constructors / getter
    
}
```

**With the \*volatile\* keyword, we instruct the JVM and the compiler to store the \*counter\* variable in the main memory.** 

**使用 volatile 关键字，我们指示JVM和编译器将  counter 变量存储在主内存中。**

That way, we make sure that every time the JVM reads the value of the *counter* variable, it will actually read it from the main memory, instead of from the CPU cache. Likewise, every time the JVM writes to the *counter* variable, the value will be written to the main memory.

**这样，我们确保每次JVM读取 counter 变量的值时，实际上都会从主内存而不是从CPU缓存读取它。 同样，每次JVM写入  counter  变量时，该值将写入主内存。**

Moreover, **the use of a \*volatile\* variable ensures that all variables that are visible to a given thread will be read from the main memory as well**.

**此外，使用 volatile  变量可确保也将从主内存中 读取给定线程可见的所有变量**。

Let's consider the following example:

**让我们思考一下下面的示例：**

```java
public class User {
 
    private String name;
    private volatile int age;
 
    // standard constructors / getters
    
}
```

In this case, each time the JVM writes the *age* *volatile* variable to the main memory, it will write the non-volatile *name* variable to the main memory as well. This assures that the latest values of both variables are stored in the main memory, so consequent updates to the variables will automatically be visible to other threads.

**在这种情况下，每次JVM将 age   volatile  变量写入主内存时，它也会将非 volatile name 变量也写入主内存。 这确保了两个变量的最新值都存储在主存储器中，因此对变量的后续更新将自动对其他线程可见。**

Similarly, if a thread reads the value of a *volatile* variable, all the variables visible to the thread will be read from the main memory too.

**同样，如果线程读取* volatile *变量的值，则该线程可见的所有变量也将从主内存中读取。**

**This extended guarantee that \*volatile\* variables provide is known as the [full volatile visibility guarantee](http://tutorials.jenkov.com/java-concurrency/volatile.html)**.

**Volatile变量提供的这种扩展保证称为完全易变可见性保证**

## **11. Reentrant Locks（重入锁）**

Java provides an improved set of *[Lock](https://www.baeldung.com/java-concurrent-locks)* implementations, whose behavior is slightly more sophisticated than the intrinsic locks discussed above.

**Java提供了一组改进的Lock实现，其行为操作比上面讨论的内部锁稍微复杂一些。**

**With intrinsic locks, the lock acquisition model is rather rigid:** one thread acquires the lock, then executes a method or code block, and finally releases the lock, so other threads can acquire it and access the method.

**对于内部锁，该锁获取模型相当严格：一个线程获取锁，然后执行方法或代码块，最后释放锁，以便其他线程可以获取它并访问该方法。**

There's no underlying mechanism that checks the queued threads and gives priority access to the longest waiting threads.

**没有一个底层机制可以检查排队的线程并优先访问等待时间最长的线程。**

*[ReentrantLock](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/locks/ReentrantLock.html)* instances allow us to do exactly that, **hence preventing queued threads from suffering some types of [resource starvation](https://en.wikipedia.org/wiki/Starvation_(computer_science)):**

**而ReentrantLock实例使我们能够做到这一点，从而防止排队的线程遭受某种类型的资源匮乏**

```java
public class ReentrantLockCounter {
 
    private int counter;
    private final ReentrantLock reLock = new ReentrantLock(true);
    
    public void incrementCounter() {
        reLock.lock();
        try {
            counter += 1;
        } finally {
            reLock.unlock();
        }
    }
    
    // standard constructors / getter
    
}
```

The *ReentrantLock* constructor takes an optional *fairness*（公平） *boolean* parameter. When set to *true*, and multiple threads are trying to acquire a lock, **the JVM will give priority to the longest waiting thread and grant access to the lock**.

**ReentrantLock构造函数采用一个可选的fairness布尔参数。 如果设置为true，并且多个线程正试图获取锁，则JVM将优先考虑等待时间最长的线程，并授予对该锁的访问权限。**

## **12. Read/Write Locks（读写锁）**

Another powerful mechanism that we can use for achieving thread-safety is the use of *[ReadWriteLock](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/locks/ReadWriteLock.html)* implementations.

**我们可以用来实现线程安全的另一种强大机制是使用ReadWriteLock实现。**

A *ReadWriteLock* lock actually uses a pair of associated locks, one for read-only operations and other for writing operations.

**ReadWriteLock 锁实际上是使用一对关联的锁，一个用于只读操作，另一个用于写操作。**

As a result, **it's possible to have many threads reading a resource, as long as there's no thread writing to it. Moreover, the thread writing to the resource will prevent other threads from reading it**.

**结果就是，只要没有线程写入资源，就有可能有许多线程在读取资源。 此外，将线程写入资源将阻止其他线程读取资源。**

We can use a *ReadWriteLock* lock as follows:

**正如下面 我们可以使用读写锁**

```java
public class ReentrantReadWriteLockCounter {
    
    private int counter;
    private final ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();
    private final Lock readLock = rwLock.readLock();
    private final Lock writeLock = rwLock.writeLock();
    
    public void incrementCounter() {
        writeLock.lock();
        try {
            counter += 1;
        } finally {
            writeLock.unlock();
        }
    }
    
    public int getCounter() {
        readLock.lock();
        try {
            return counter;
        } finally {
            readLock.unlock();
        }
    }
 
   // standard constructors
   
}
```

## **13. Conclusion（总结）**

In this article, **we learned what thread-safety is in Java, and took an in-depth look at different approaches for achieving it**.

在本文中，**我们了解了Java中的线程安全性，并深入研究了实现它的不同方法**。

As usual, all the code samples shown in this article are available [over on GitHub](https://github.com/eugenp/tutorials/tree/master/core-java-modules/core-java-concurrency-basic).

package Concurrent.threadsafety.services;

/**
 * @author yichangkong
 * @create 2020-08-10-22:02
 */
public class Counter {

    private volatile int counter;

    public Counter( ) {
        this.counter = 0;
    }

    public synchronized void incrementCounter(){//increment ×ÔÔö
        counter +=1;
    }
    public int getCounter(){
        return counter;
    }
}

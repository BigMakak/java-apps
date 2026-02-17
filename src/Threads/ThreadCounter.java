package Threads;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadCounter {
    private final AtomicInteger atomicCounter = new AtomicInteger(0);

    public void incrementCounter() {
        atomicCounter.incrementAndGet();
    }

    public int counterValue() {
        return atomicCounter.get();
    }
}



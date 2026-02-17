package Threads;

public class RunnerThread implements Runnable {

    private ThreadCounter counter;
    private final int interations;

    public RunnerThread(ThreadCounter counter, int countingSteps) {
        this.interations = countingSteps;
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < this.interations; i++) {
            counter.incrementCounter();
        }
    }
}

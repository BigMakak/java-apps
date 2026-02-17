import Threads.RunnerThread;
import Threads.ThreadCounter;


public class Main {
    public static void main(String[] args) throws InterruptedException {
       /* List<Integer> scores = Arrays.asList(10, 5, 20, 20, 4, 5, 2, 25, 1);

        BreakingRecords breakingRecords = new BreakingRecords();


        for (Integer value : breakingRecords.breakingRecords(scores)) {
            System.out.print("Score value: " + value);
        } */

        ThreadCounter threadCounter = new ThreadCounter();

        Thread t1 = new Thread( new RunnerThread(threadCounter,1000));
        Thread t2 = new Thread(new RunnerThread(threadCounter,1000));

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.print(threadCounter.counterValue());
    }
}
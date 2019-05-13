import queue.MyQueue;
import threads.Consumer;
import threads.Producer;

import java.util.stream.IntStream;


public class Main {

    private static int NUMBERS_OF_THREADS_PRODECER = 3;
    private static int NUMBERS_OF_THREADS_CONSUMER= 6;

    public static void main(String[] args) throws InterruptedException {

        MyQueue myQueue = new MyQueue();
        IntStream.range(0 , NUMBERS_OF_THREADS_PRODECER)
                .forEach(i -> new Producer(myQueue).start());

        Thread.sleep(1000);

        IntStream.range(0 , NUMBERS_OF_THREADS_CONSUMER)
                .forEach(i -> new Consumer(myQueue).start());
    }
}

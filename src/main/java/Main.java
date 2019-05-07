import queue.MyQueue;
import threads.ThreadEmulatingActivity;
import threads.ThreadRequestWriter;

import java.util.stream.IntStream;


public class Main {

    public static void main(String[] args) throws InterruptedException {

        MyQueue myQueue = new MyQueue();
        IntStream.range(0,3).forEach(i -> new ThreadRequestWriter(myQueue).start());
        Thread.sleep(1000);
        IntStream.range(0,6).forEach(i -> new ThreadEmulatingActivity(myQueue).start());
    }
}

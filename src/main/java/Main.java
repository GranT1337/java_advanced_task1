import org.apache.log4j.Logger;
import queue.MyQueue;
import threads.ThreadEmulatingActivity;
import threads.ThreadRequestWriter;


public class Main {

    public static void main(String[] args) {

        MyQueue myQueue = new MyQueue();

        new ThreadRequestWriter(myQueue).start();
        new ThreadRequestWriter(myQueue).start();
        new ThreadRequestWriter(myQueue).start();

        new ThreadEmulatingActivity(myQueue).start();
        new ThreadEmulatingActivity(myQueue).start();
        new ThreadEmulatingActivity(myQueue).start();
        new ThreadEmulatingActivity(myQueue).start();
        new ThreadEmulatingActivity(myQueue).start();
        new ThreadEmulatingActivity(myQueue).start();


    }
}

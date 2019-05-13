package threads;

import org.apache.log4j.Logger;
import queue.MyQueue;

public class Consumer extends Thread {

    private Logger logger = Logger.getLogger(Consumer.class);

    private MyQueue myQueue;

    public Consumer(MyQueue myQueue) {
        this.myQueue = myQueue;
    }

    @Override
    public void run() {
        while (!myQueue.getList().isEmpty()) {
            myQueue.get();
            logger.info("Обработка запроса" + "\n");
            try {
                sleep(5000);
            } catch (InterruptedException e) {
                logger.error(e);
            }
        }
    }
}

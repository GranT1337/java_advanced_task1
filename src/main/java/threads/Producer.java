package threads;

import entity.BookingRequests;
import entity.Hotel;
import org.apache.log4j.Logger;
import queue.MyQueue;

import java.time.LocalDate;
import java.util.Random;

public class Producer extends Thread{

    private static final Logger logger = Logger.getLogger(Producer.class);

    private MyQueue myQueue;
    private Random random = new Random();

    public Producer(MyQueue myQueue) {
        this.myQueue = myQueue;
    }

    @Override
    public void run() {
        try {
            while (myQueue.getCountAdd() < MyQueue.NUMBERS_OF_REQUESTS) {
                BookingRequests bookingRequests = new BookingRequests(generateHotel(), generateDate());
                myQueue.add(bookingRequests);
            }
        } catch (Exception e) {
            logger.error(e);
        }
    }


    private Hotel generateHotel() {
        int length = 6;
        String hotelName = random.ints(97, 122)
                .mapToObj(i -> (char) i)
                .limit(length)
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                .toString();
        return new Hotel("Hotel " + hotelName, random.nextInt(5) + 1);
    }

    private LocalDate generateDate() {
        return LocalDate.now().plusDays(random.nextInt(50));
    }


}

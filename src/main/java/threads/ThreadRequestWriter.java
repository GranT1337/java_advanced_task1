package threads;

import entity.BookingRequests;
import entity.Hotel;
import queue.MyQueue;

import java.time.LocalDate;
import java.util.Random;

public class ThreadRequestWriter extends Thread{

    private MyQueue myQueue;
    private Random random = new Random();

    public ThreadRequestWriter(MyQueue myQueue) {
        this.myQueue = myQueue;
    }

    @Override
    public void run() {
        while (myQueue.getCountAdd() < MyQueue.NUMBERS_OF_REQUESTS) {
            BookingRequests bookingRequests = new BookingRequests(generateHotel(), generateDate());
            myQueue.add(bookingRequests);
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

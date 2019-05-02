package entity;

import java.time.LocalDate;

public class BookingRequests {

    private Hotel hotel;
    private LocalDate localDate;

    public BookingRequests(Hotel hotel, LocalDate localDate) {
        this.hotel = hotel;
        this.localDate = localDate;
    }

    @Override
    public String toString() {
        return  hotel +
                ". Дата: " + localDate;
    }
}

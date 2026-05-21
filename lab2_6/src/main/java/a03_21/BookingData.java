package a03_21;

import java.util.List;

public class BookingData {
    private List<Booking> bookings;

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    @Override
    public String toString() {
        return "BookingData{" +
                "bookings=" + bookings +
                '}';
    }

}

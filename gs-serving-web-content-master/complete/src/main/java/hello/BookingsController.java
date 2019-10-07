package hello;

import dataproviders.IDBDataProvider;
import models.Booking;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class BookingsController {
    private IDBDataProvider<Booking> bookingDataProvider;

    @Autowired
    public BookingsController(IDBDataProvider<Booking> bookingDataProvider){
        this.bookingDataProvider = bookingDataProvider;
    }

    @PostMapping("/bookings")
    public Booking createBooking(@RequestBody Booking booking) {
        booking.setBookingId(UUID.randomUUID().toString());
        booking.setCreatedTime(DateTime.now());

        this.bookingDataProvider.insert(booking);

        return booking;
    }
}

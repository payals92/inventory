package dataProvider;

import dataproviders.DynamoDBDataProvider;
import models.Booking;
import org.joda.time.DateTime;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DynamoDBDataProviderTest {

    @Test
    public void testDynamoDB() {
        DynamoDBDataProvider<Booking> db = new DynamoDBDataProvider<>();
        Date travelDate = new GregorianCalendar(2014, Calendar.FEBRUARY, 11).getTime();
        Booking booking = new Booking("ABC123", "Payal", DateTime.now(), "EK121", travelDate);
        db.insert(booking);
    }
}

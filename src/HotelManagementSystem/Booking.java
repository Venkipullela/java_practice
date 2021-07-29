package HotelManagementSystem;

import java.time.ZonedDateTime;
import java.util.List;

public class Booking {
    Integer id;
    Integer roomNumber;
    User user;
    List<Person> guests;
    BookingStatus status;
    ZonedDateTime scheduledCheckIn;
    ZonedDateTime scheduledCheckOut;
    ZonedDateTime actualCheckIn;
    ZonedDateTime actualCheckOut;
    Float charge;
    Float additionalCharge;
    List<Payment> payments;
    String reasonForStay;
}

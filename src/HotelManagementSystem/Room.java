package HotelManagementSystem;

import java.util.List;

public class Room {
    Integer roomNumber;
    RoomType roomType;
    List<Booking> scheduledBookings;
    Booking ongoingBooking;
}

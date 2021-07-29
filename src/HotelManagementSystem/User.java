package HotelManagementSystem;

import java.time.ZonedDateTime;
import java.util.List;

public class User {
    String userId;
    Integer age;
    String address;

    public List<Room> getAvailableRooms(RoomType roomType, ZonedDateTime checkIn, ZonedDateTime checkOut){
        return null;
    }

    public Integer bookRoom(Integer roomNumber, ZonedDateTime checkIn, ZonedDateTime checkOut, List<Person> guests){
        return null;
    }

    public Integer rescheduleBooking(Integer bookingId, ZonedDateTime newCheckIn, ZonedDateTime newCheckOut){
        return null;
    }

    public Integer cancelBooking(Integer bookingId) {
        // return refundId;
        return null;
    }

    public void checkIn(Integer bookingId) {

    }

    public Float checkOut(Integer booking) {
        return 0f;
    }
}

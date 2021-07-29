package AirlineManagementSystem;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Map;

public class Booking {
    Integer id;
    List<Integer> flightId;
    Integer userId;
    Map<Integer, Map<Integer, Integer>> passengerSeatsMap;
    ZonedDateTime bookedOn;
    Integer paymentId;
}

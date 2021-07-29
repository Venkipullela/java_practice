package AirlineManagementSystem;

import java.time.Instant;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Map;

public class Flight {
    Integer id;
    Integer aircraftId;
    Person captain;
    Person coPilot;
    List<Person> crewMembers;
    City source;
    City destination;
    ZonedDateTime scheduledDeparture;
    ZonedDateTime scheduledArrival;
    ZonedDateTime actualDeparture;
    ZonedDateTime actualArrival;
    Map<Integer, Integer> seatAndPassengerMap;
    List<Integer> emptySeats;
    FlightStatus status;
}

package AirlineManagementSystem;

// Flight
// City
// User
// Booking
// Seat
// Aircraft


import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.Map;

public class ManagementSystem {
    ManagementSystem managementSystem = new ManagementSystem();
    private ManagementSystem(){}


    Map<Integer, Flight> flightMap = new HashMap<>();
    Map<Integer, Aircraft> aircraftMap = new HashMap<>();

    public Integer scheduleAFlight(Integer aircraftId, City source, City destination, ZonedDateTime departure, ZonedDateTime arrival) {
        // Schedule an aircraft
        return 0;
    }

    public void reScheduleAFlight(Integer flightId, ZonedDateTime newDeparture, ZonedDateTime newArrival) {
        // reschedule and notify passengers
    }

    public void cancelFlight(Integer flightId) {
        // update flight status and notify users and also mark the aircraft available for scheduling other flights
    }

    public void assignCrewToFlight(Integer flight) {
        // logic to assign flight and pilots based on their availability for the flight in the source city
    }

    public Integer bookFlight() {

        return 0;
    }

}

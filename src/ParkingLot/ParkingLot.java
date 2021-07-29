package ParkingLot;

import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.Queue;

public class ParkingLot {
    String name;

    Queue<ParkingSlot> largeSlotsLeft;
    Queue<ParkingSlot> mediumSlotsLeft;
    Queue<ParkingSlot> smallSlotsLeft;
    final Integer totalLargeSlots;
    final Integer totalMediumSlots;
    final Integer totalSmallSlots;

    HashMap<Integer, Booking> activeBooking;
    HashMap<Integer, Floor> floors;

    public ParkingLot(){
        //read from database
        totalLargeSlots = 100;
        totalMediumSlots = 100;
        totalSmallSlots = 100;
        populateQueues();
    }
    public void populateQueues(){
        // this initialises all queues
    }

    public synchronized Booking bookASlot(Vehicle vehicle) throws Exception{
        if(isFull(vehicle)) {
            throw new Exception("Parking Slots are full");
        }
        Booking booking = new Booking();
        booking.vehicle = vehicle;
        booking.startTime = ZonedDateTime.now();

        if(vehicle.vehicleType.equals(Vehicle.VehicleType.CAR)) {
            booking.parkingSlot = mediumSlotsLeft.poll();
        }
        if(vehicle.vehicleType.equals(Vehicle.VehicleType.BIKE)) {
            booking.parkingSlot = smallSlotsLeft.poll();
        }
        if(vehicle.vehicleType.equals(Vehicle.VehicleType.TRUCK)) {
            booking.parkingSlot = largeSlotsLeft.poll();
        }
        assert booking.parkingSlot != null;
        booking.parkingSlot.isEmpty = false;
        return booking;
    }

    public boolean isFull(Vehicle vehicle) {
        if(vehicle.vehicleType.equals(Vehicle.VehicleType.CAR)) {
            return mediumSlotsLeft.size() == 0;
        }
        if(vehicle.vehicleType.equals(Vehicle.VehicleType.BIKE)) {
            return smallSlotsLeft.size() == 0;
        }
        if(vehicle.vehicleType.equals(Vehicle.VehicleType.TRUCK)) {
            return largeSlotsLeft.size() == 0;
        }
        return false;
    }



}

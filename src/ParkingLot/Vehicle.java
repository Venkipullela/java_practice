package ParkingLot;

public abstract class Vehicle {
    Integer vehicleNumber;
    VehicleType vehicleType;

    public Vehicle(VehicleType type) {
        this.vehicleType = type;
    }

    public enum VehicleType {
        CAR,
        BIKE,
        TRUCK,
    }
}


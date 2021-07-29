package ParkingLot;

public class ParkingSlot {
    Integer id;
    Integer floorId;
    SlotType slotType;
    Boolean isEmpty;

    public enum SlotType {
        MEDIUM,
        SMALL,
        LARGE
    }
}


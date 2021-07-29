package HotelManagementSystem;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
    String name;
    String address;
    Integer rating;
    List<Level> levels = new ArrayList<>();
    List<Person> staffMembers;
}

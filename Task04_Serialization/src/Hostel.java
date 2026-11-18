import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Hostel implements Serializable {
    private static final long serialVersionUID = 1L;

    private String hostelName;
    private List<Room> rooms = new ArrayList<>();

    public Hostel(String hostelName) {
        this.hostelName = hostelName;
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    @Override
    public String toString() {
        return "Hostel: " + hostelName + "\n" + rooms;
    }
}
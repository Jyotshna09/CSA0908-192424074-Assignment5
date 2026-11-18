import java.io.*;

public class SerializationDemo {

    public static void main(String[] args) {

        String file = "Task04_Serialization/output/hostel.dat";

        Hostel hostel = new Hostel("SIMATS Hostel");

        Room room1 = new Room(101);
        room1.addResident(
            new Resident("Rahul", "192424001", "pass123"));
        room1.addResident(
            new Resident("Priya", "192424002", "pass456"));

        Room room2 = new Room(102);
        room2.addResident(
            new Resident("Arun", "192424003", "pass789"));

        hostel.addRoom(room1);
        hostel.addRoom(room2);

        // Serialize hostel object
        try (ObjectOutputStream out =
                 new ObjectOutputStream(new FileOutputStream(file))) {

            out.writeObject(hostel);
            System.out.println("Hostel data saved successfully.");

        } catch (IOException e) {
            System.out.println("Saving error: " + e.getMessage());
        }

        // Deserialize hostel object
        try (ObjectInputStream in =
                 new ObjectInputStream(new FileInputStream(file))) {

            Hostel loadedHostel = (Hostel) in.readObject();

            System.out.println("\nLOADED HOSTEL DATA");
            System.out.println(loadedHostel);

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Loading error: " + e.getMessage());
        }
    }
}
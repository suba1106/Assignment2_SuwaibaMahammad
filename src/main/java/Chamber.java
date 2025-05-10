import java.util.Collection;
import java.util.List;
import java.util.ArrayList;

public class Chamber {
    Chamber chamber;
    List<Door> doors = new ArrayList<>();
    List<Item> items = new ArrayList<>();

    public Chamber() {

    }

    public Chamber(Item item) {
        // TODO implement chamber
    }

    public List<Door> getDoors() {
        return doors;
    }

    public List<Item> getItems() {
        return items;
    }

    public void addDoor(Door door) { //adds doors to the lost of doors in the chamber
        doors.add(door);
    }
}
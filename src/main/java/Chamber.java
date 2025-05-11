import java.util.List;
import java.util.ArrayList;

public class Chamber {
    Chamber chamber;
    List<Door> doors = new ArrayList<>();
    Item items;

    public Chamber() {
    }

    public Chamber(Item item) {
        this.items = item;
    }

    public List<Door> getDoors() {
        return doors;
    }

    public Item getItems() {
        return items;
    }

    public void addDoor(Door door) { // adds doors to the lost of doors in the chamber
        doors.add(door);
    }

    public boolean hasMonster() {
        for (Door door : doors) {
            if (door.getMonster() != null) {
                return true;
            }
        }
        return false;
    }

    public Monster getMonster() {
        for (Door door : doors) {
            if (door.getMonster() != null) {
                System.out.print("Monster Name: " + door.getMonster().name());
            }
        }
    }
}

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

    public List<Monster> getMonster() {
        List<Monster> list = new ArrayList<>();
        for (Door door : doors) {
            if (door.getMonster() != null) {
                list.add(door.getMonster());
            }
        }
        return list;
    }
}

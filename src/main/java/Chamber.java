import java.util.List;
import java.util.ArrayList;

public class Chamber {
    Chamber chamber;
    List<Door> doors = new ArrayList<>();
    List<Item> items;

    public Chamber() {
        items = new ArrayList<>();
    }

    public Chamber(Item item) {
        items = new ArrayList<>();
        this.items.add(item);
    }

    protected List<Door> getDoors() {
        return doors;
    }

    protected List<Item> getItems() {
        return items;
    }

    protected void addDoor(Door door) { // adds doors to the list of doors in the chamber
        doors.add(door);
    }

    protected boolean hasMonster() {
        for (Door door : doors) {
            if (door.getMonster() != null) {
                return true;
            }
        }
        return false;
    }

    protected List<Monster> getMonster() {
        List<Monster> list = new ArrayList<>();
        for (Door door : doors) {
            if (door.getMonster() != null) {
                list.add(door.getMonster());
            }
        }
        return list;
    }
}

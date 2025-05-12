import java.util.List;
import java.util.ArrayList;

public class Chamber {
    List<Door> doors = new ArrayList<>();
    List<Item> items;

    /**
     * constructs Chamber by initializing items list
     */
    public Chamber() {
        items = new ArrayList<>();
    }

    /**
     * constructs Chamber by initializing items list and adding item in to the list
     * @param item the item you want in the chamber
     */
    public Chamber(Item item) {
        items = new ArrayList<>();
        this.items.add(item);
    }

    /**
     *
     * @return list of Doors in the chamber
     */
    protected List<Door> getDoors() {
        return doors;
    }

    /**
     *
     * @return list of items in the Chamber
     */
    protected List<Item> getItems() {
        return items;
    }

    /**
     * adds a door to the Chamber
     * @param door the door you want added
     */
    protected void addDoor(Door door) { // adds doors to the list of doors in the chamber
        doors.add(door);
    }

    /**
     * Checks if the door has monster
     * @return boolean, true if the door has a monster, false otherwise
     */
    protected boolean hasMonster() {
        for (Door door : doors) {
            if (door.getMonster() != null) {
                return true;
            }
        }
        return false;
    }

    /**
     * gives a list of monsters by iterating through the doors
     * @return a list of monsters in the chamber
     */
    protected List<Monster> getMonster() {
        List<Monster> list = new ArrayList<>();
        for (Door door : doors) {
            if (door.getMonster() != null) {
                list.add(door.getMonster());
            }
        }
        return list;
    }

    /**
     * removes an item from the items list
     * @param item item wanting removal
     */
    protected void removeItem(Item item){
        items.remove(item);
    }
}

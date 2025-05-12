public class Door {
    private final Chamber chamber1;
    private final Chamber chamber2;
    protected Monster monster;

    /**
     * Door constructor with monster
     * @param ch1 first chamber
     * @param ch2 second chamber
     * @param mons the monster guarding the door
     */
    protected Door(Chamber ch1, Chamber ch2, Monster mons) {
        this.chamber1 = ch1;
        this.chamber2 = ch2;
        this.monster = mons;
    }

    /**
     * door constructor without monster
     * @param ch1 first chamber
     * @param ch2 second chamber
     */
    protected Door(Chamber ch1, Chamber ch2) {
        this(ch1, ch2, null);
    }

    /**
     * connects two chambers by door, adds them to door list in chamber
     * @param ch1 first chamber
     * @param ch2 second chamber
     */
    public static void connect(Chamber ch1, Chamber ch2) {
        Door door = new Door(ch1, ch2);
        ch1.addDoor(door);
        ch2.addDoor(door);
    }

    /**
     * connects two chambers by door, adds them to door list in chamber,
     * and adds monster
     * @param ch1 first door
     * @param ch2 second door
     * @param monster monster guarding door
     */
    public static void connect(Chamber ch1, Chamber ch2, Monster monster) {
        Door door = new Door(ch1, ch2, monster);
        ch1.addDoor(door);
        ch2.addDoor(door);
    }

    /**
     * gets the chamber the door is leading to
     * @param current the  chamber the character is in
     * @return the other chamber
     * @exception IllegalArgumentException if the chamber is not being connected by the door
     */
    protected Chamber getConnectionChamber(Chamber current) {
        if (current == chamber1) {
            return chamber2;
        } else if (current == chamber2)
            return chamber1;
        else
            throw new IllegalArgumentException();
    }

    /**
     * returns the monster guarding the door
     * @return Monster
     */
    protected Monster getMonster() {
        return monster;
    }

    /**
     * checks if there is a monster guarding the door
     * @return true if there is a  monster false otherwise
     */
    protected boolean hasMonster() {
        return monster != null;
    }

    /**
     * removes the monster from the door
     */
    protected void removeMonster() {
        monster = null;
    }
}

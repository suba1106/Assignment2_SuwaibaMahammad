public class Door {
    private final Chamber chamber1;
    private final Chamber chamber2;
    protected Monster monster;

    protected Door(Chamber ch1, Chamber ch2, Monster mons) {
        this.chamber1 = ch1;
        this.chamber2 = ch2;
        this.monster = mons;
    }

    protected Door(Chamber ch1, Chamber ch2) {
        this(ch1, ch2, null);
    }

    // connects 2 chambers by door
    public static void connect(Chamber ch1, Chamber ch2) {
        Door door = new Door(ch1, ch2);
        ch1.addDoor(door);
        ch2.addDoor(door);
    }

    public static void connect(Chamber ch1, Chamber ch2, Monster monster) {
        Door door = new Door(ch1, ch2, monster);
        ch1.addDoor(door);
        ch2.addDoor(door);
    }

    public Door getDoor() {
        return this;
    }

    protected Chamber getConnectionChamber(Chamber current) {
        if (current == chamber1) {
            return chamber2;
        } else if (current == chamber2)
            return chamber2;
        else
            throw new IllegalArgumentException();
    }

    public Monster getMonster() {
        return monster;
    }

    public boolean hasMonster() {
        return monster != null;
    }

    public void removeMonster() {
        monster = null;
    }
}

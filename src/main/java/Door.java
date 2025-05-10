public class Door {
    private Chamber chamber1;
    private Chamber chamber2;
    protected Monster monster;

    private Door(Chamber ch1, Chamber ch2, Monster mons) {
        this.chamber1 = ch1;
        this.chamber2 = ch2;
        this.monster = mons;
    }

    private Door(Chamber ch1, Chamber ch2) {
        this(ch1, ch2, null);
    }

    //connects 2 chambers by door
    public void connect(Chamber ch1, Chamber ch2){
        Door door = new Door(ch1, ch2);
        ch1.addDoor(this);
        ch2.addDoor(this);
    }

    public void connect(Chamber ch1, Chamber ch2, Monster monster){
        Door door = new Door(ch1, ch2, monster);
        ch1.addDoor(this);
        ch2.addDoor(this);
    }

    public Door getDoor() {
        return this;
    }

    public int size() {
        //todo
        return 1234;
    }

    protected Chamber getConnectionChamber(Chamber current){
        if(current == chamber1){return chamber2;}
        else if(current == chamber2)return chamber2;
        else throw new IllegalArgumentException();
    }
}

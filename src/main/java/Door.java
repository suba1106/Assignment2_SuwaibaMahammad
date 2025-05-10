public class Door {
    private Chamber chamber1;
    private Chamber chamber2;
    private Monster monster;

    //connects 2 chambers by door
    public void connect(Chamber ch1, Chamber ch2){
        this.chamber1 = ch1;
        this.chamber2 = ch2;
        ch1.addDoor(this);
        ch2.addDoor(this);
    }

    public void connect(Chamber ch1, Chamber ch2, Monster monster){
        this.chamber1 = ch1;
        this.chamber2 = ch2;
        this.monster = monster;
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
}

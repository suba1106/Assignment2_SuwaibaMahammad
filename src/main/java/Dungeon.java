import java.util.List;

class Dungeon {
    Chamber current;
    Chamber start;
    Chamber end;

    public Dungeon(Character player, Chamber entry, Chamber goal) {
        // todo
    }

    public List<Action> getActions() {
        return current.actions();
    }

    public Chamber getCurrentChamber() {
        return current;
    }

    public boolean isFinished() {
        if(current == end){
            return true;
        }return false;
    }
    protected void setCurrentChamber(Chamber chamber){
        this.current = chamber;
    }
}

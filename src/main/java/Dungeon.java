import java.util.List;
import java.util.ArrayList;

class Dungeon {
    Chamber current;
    Chamber start;
    Chamber end;

    public Dungeon(Character player, Chamber entry, Chamber goal) {
        // todo
    }

    public List<Action> getActions() {
        List<Action> actions = new ArrayList<>();
        actions.add(new Move());
        if(current.hasMonster()){
            actions.add(new Fight());
        }
        if(current.hasItem()){
            actions.add(new Pick());
        }
        return actions;
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

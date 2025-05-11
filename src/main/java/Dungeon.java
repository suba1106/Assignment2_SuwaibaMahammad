import java.util.ArrayList;
import java.util.List;

class Dungeon {
    Chamber current;
    Chamber start;
    Chamber end;

    public Dungeon(Character player, Chamber entry, Chamber goal) {
        // todo
    }

    public List<Action> getActions() {
        List<Action> actions = new ArrayList<>();
        actions.add(new Move(this));
        if (current.hasMonster()) {
            actions.add(new Fight(this));
        }
        if (current.hasItem()) {
            actions.add(new Pick(this));
        }
        return actions;
    }

    public Chamber getCurrentChamber() {
        return current;
    }

    public boolean isFinished() {
        if (current == end) {
            return true;
        }
        return false;
    }

    protected void setCurrentChamber(Chamber chamber) {
        this.current = chamber;
    }

    public Character getPlayer() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPlayer'");
    }
}

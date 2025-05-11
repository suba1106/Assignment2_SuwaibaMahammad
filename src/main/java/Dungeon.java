import java.util.ArrayList;
import java.util.List;

class Dungeon {
    Chamber current;
    Chamber start;
    Chamber end;
    Character player;

    public Dungeon(Character player, Chamber entry, Chamber goal) {
        this.player = player;
        this.start = entry;
        this.end = goal;
    }

    public List<Action> getActions() {
        List<Action> actions = new ArrayList<>();
        actions.add(new Move(this));
        if (current.hasMonster()) {
            actions.add(new Fight(player, current.getMonster()));
        }
        if (current.getItems() != null) {
            actions.add(new Pick(current.getItems()));
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
        return player;
    }
}

import java.util.ArrayList;
import java.util.List;

class Dungeon {
    Chamber current;
    Chamber start;
    Chamber end;
    Character player;

    /**
     * Dungeon constructor
     * @param player the player
     * @param entry the starting chamber
     * @param goal end chamber
     */
    public Dungeon(Character player, Chamber entry, Chamber goal) {
        this.player = player;
        this.start = entry;
        this.end = goal;
        this.current = entry;
    }

    /**
     * gets a possible list of actions at the position
     * @return List of actions possible
     */
    protected List<Action> getActions() {
        List<Action> actions = new ArrayList<>();
        actions.add(new Move(this));
        if (current.hasMonster()) {
            actions.add(new Fight(current, player, current.getMonster()));
        }
        if (current.getItems() != null) {
            actions.add(new Pick(this, current.getItems()));
        }
        return actions;
    }

    /**
     * gets the current position of the character
     * @return Chamber the player is at
     */
    protected Chamber getCurrentChamber() {
        return current;
    }

    /**
     * checks if the game is finished
     * @return true if current chamber == end chamber and prints a messgae to playe
     * false otherwise
     */
    protected boolean isFinished() {
        if (current == end) {
            System.out.println("Congratulations! You've made it out alive!");
            return true;
        }
        return false;
    }

    /**
     * sets the current chamber
     * @param chamber the chamber you want to be your new current chamber
     */
    protected void setCurrentChamber(Chamber chamber) {
        this.current = chamber;
    }

    /**
     * gets the player
     * @return Character representing the player
     */
    protected Character getPlayer() {
        return player;
    }
}

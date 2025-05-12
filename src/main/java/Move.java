import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

class Move extends Action {
    private final Dungeon dungeon;

    /**
     * Move constructor
     * @param dungeon the dungeon the player is in
     */
    public Move(Dungeon dungeon) {
        this.dungeon = dungeon;
    }

    /**
     * asks the user which door they want to move through. If there is a
     * monster guarding the door they choose, a fight sequence is initiated
     * if player wins they move through the door
     * if there is no monster the player just moves through
     */
    @Override
    public void execute() {
        Chamber current = dungeon.getCurrentChamber();
        List<Door> doors = current.getDoors();

        System.out.println("Choose a door to move through:");
        for (int i = 0; i < doors.size(); i++) {
            System.out.println(i + ": Door " + (i + 1));
        }

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            int choice = Integer.parseInt(reader.readLine());
            Door selectedDoor = doors.get(choice);

            Monster monster = selectedDoor.getMonster();
            if (monster != null) {
                System.out.println("A " + monster.getName() + " jumps out and blocks your path!");
                // trigger fight here
                Fight fight = new Fight(selectedDoor, dungeon.getPlayer(), monster);
                fight.execute();

                if (monster.isAlive()) {
                    System.out.println("You couldn't defeat the monster. You remain in the current chamber.");
                    return;
                } else {
                    System.out.println("You defeated the monster! Proceeding through the door...");
                }
            }

            dungeon.setCurrentChamber(selectedDoor.getConnectionChamber(current));
        } catch (IOException e) {
            System.out.println("Invalid input. Please try again.");
        }
    }

    /**
     * overriding method to string
     * @return String saying Move
     */
    @Override
    public String toString() {
        return "Move";
    }
}

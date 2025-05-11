import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class TextUI {
    public void play(Dungeon d) {
        while (!d.isFinished()) {
            print(d);
            Action a = ask(d);
            a.execute();
        }
    }

    /** Print the current room of the dungeon. */
    private void print(Dungeon d) {
        Chamber r = d.getCurrentChamber();
        StringBuilder s = new StringBuilder();
        s.append("You are in a chamber with " + r.getDoors().size() + " doors\n");
        s.append("There are " + r.getItems().size() + " items in the chamber\n");
        s.append("Here is the list of monsters in the room with you:\n");
        List<Door> doors = r.getDoors();
        for (int i = 0; i < doors.size(); i++) {
            if (doors.get(i).hasMonster())
                s.append(i + ": Door: " + doors.get(i).getMonster().getName() + "\n  Strength: " +
                        doors.get(i).getMonster().getStrength() + "\n  Craft: " +
                        doors.get(i).getMonster().getCraft() + "\n  Health: " +
                        doors.get(i).getMonster().getHealth());
            else {
                s.append(i + ": Door: has no monsters\n");
            }
        }
        System.out.println(s.toString());
    }

    /** Asks the user for an action. */
    private Action ask(Dungeon d) {
        StringBuilder s = new StringBuilder();
        s.append("Here are your options:\n");
        List<Action> actions = d.getActions();
        for (int i = 0; i < actions.size(); i++) {
            Action a = actions.get(i);
            s.append("\t" + i + ": " + a.toString() + "\n");
        }
        System.out.println(s.toString());
        // ask for action
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            int command = Integer.parseInt(reader.readLine());
            return actions.get(command);
        } catch (IOException e) {
            return new PrintError(d, e);
        }
    }
}
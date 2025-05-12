import java.io.IOException;

public class PrintError extends Action {
    Dungeon dungeon;
    IOException e;

    /**
     * prints the error
     * @param d the dungeon the player is in
     * @param e the error message
     */
    public PrintError(Dungeon d, IOException e) {
        this.dungeon = d;
        this.e = e;
    }

    /**
     * prints the error
     */
    @Override
    protected void execute() {
        System.err.println("Error reading input: " + e.getMessage());
    }

    /**
     * overriding method from parent
     * @return "PrintError"
     */
    @Override
    public String toString() {
        return "PrintError";
    }
}

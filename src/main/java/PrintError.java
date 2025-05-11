import java.io.IOException;

public class PrintError extends Action {
    Dungeon dungeon;
    IOException e;

    public PrintError(Dungeon d, IOException e) {
        this.dungeon = d;
        this.e = e;
    }

    public void execute() {
        System.err.println("Error reading input: " + e.getMessage());
    }

    @Override
    public String toString() {
        return "PrintError";
    }
}

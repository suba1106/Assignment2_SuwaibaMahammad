import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DungeonTest {
    private Character player;
    private Chamber entry;
    private Chamber goal;
    private Chamber middle;
    private Dungeon dungeon;

    @BeforeEach
    void setUp() {
        player = new Warrior("Thor");
        entry = new Chamber();
        middle = new Chamber();
        goal = new Chamber();

        Door.connect(entry, middle);
        Door.connect(middle, goal);

        dungeon = new Dungeon(player, entry, goal);
    }

    @Test
    void testCreation(){
        assertNotNull(dungeon);
    }

    @Test
    void getActions() {

    }

    @Test
    void getCurrentChamber() {
        assertEquals(entry, dungeon.getCurrentChamber());
    }

    @Test
    void isFinished() {
        assertFalse(dungeon.isFinished());

        Dungeon dun = new Dungeon(player, entry, entry);
        assertTrue(dun.isFinished());
    }

    @Test
    void setCurrentChamber() {
        dungeon.setCurrentChamber(middle);
        assertEquals(middle, dungeon.getCurrentChamber());
    }

    @Test
    void getPlayer() {
        assertEquals(player, dungeon.getPlayer());
    }
}
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DoorTest {
    private Chamber chamber1;
    private Chamber chamber2;
    private Monster monster;
    private Door doorWithoutMonster;
    private Door doorWithMonster;

    @BeforeEach
    void setUp() {
        chamber1 = new Chamber();
        chamber2 = new Chamber();
        monster = new Monster("Goblin", 10, 2, 1);
        doorWithoutMonster = new Door(chamber1, chamber2);
        doorWithMonster = new Door(chamber1, chamber2, monster);
    }

    @Test
    void getConnectionChamber() {
        assertEquals(chamber2, doorWithMonster.getConnectionChamber(chamber1));
        assertEquals(chamber1, doorWithoutMonster.getConnectionChamber(chamber2));
    }

    @Test
    void testConnect() {

    }

    @Test
    void getMonster() {
    }

    @Test
    void hasMonster() {
    }

    @Test
    void removeMonster() {
    }
}
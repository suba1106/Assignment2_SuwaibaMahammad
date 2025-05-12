import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

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
        assertEquals(chamber1, doorWithMonster.getConnectionChamber(chamber2));
        assertEquals(chamber1, doorWithoutMonster.getConnectionChamber(chamber2));
        assertEquals(chamber2, doorWithoutMonster.getConnectionChamber(chamber1));
    }

    @Test
    void testConnect() {
        Chamber c1 = new Chamber();
        Chamber c2 = new Chamber();
        List<Monster> monsterList = new ArrayList<>();
        monsterList.add(monster);

        Door.connect(c1, c2);
        assertEquals(1, c1.getDoors().size());
        assertEquals(1, c1.getDoors().size());

        Door.connect(c1, c2, monster);
        assertEquals(monsterList, c1.getMonster());
        assertEquals(2, c1.getDoors().size());
        assertEquals(2, c1.getDoors().size());
    }

    @Test
    void getMonster() {
        assertEquals(monster, doorWithMonster.getMonster());
    }

    @Test
    void hasMonster() {
        assertTrue(doorWithMonster.hasMonster());
    }

    @Test
    void removeMonster() {
        doorWithMonster.removeMonster();
        assertFalse(doorWithMonster.hasMonster());
    }
}
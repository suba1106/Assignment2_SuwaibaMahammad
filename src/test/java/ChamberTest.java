import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

public class ChamberTest {
    private Chamber chamber;
    private Item axe;
    private Door door;
    private Door doorWithMonster;
    private Chamber otherChamber;
    private Monster monster;

    @BeforeEach
    void setUp() {
        chamber = new Chamber();
        otherChamber = new Chamber();
        axe = new Axe();
        monster = new Monster("Goblin", 2, 0, 4);
        doorWithMonster = new Door(chamber, otherChamber, monster);
        door = new Door(chamber, otherChamber);
    }

    @Test
    void testEmptyChamberCreation() {
        assertTrue(chamber.getItems().isEmpty());
        assertTrue(chamber.getDoors().isEmpty());
    }

    @Test
    void testChamberWithItemCreation() {
        Chamber chamberWithItem = new Chamber(axe);
        assertEquals(1, chamberWithItem.getItems().size());
        assertTrue(chamberWithItem.getItems().contains(axe));
    }

    @Test
    void testAddDoor() {
        chamber.addDoor(door);
        assertEquals(1, chamber.getDoors().size());
        assertTrue(chamber.getDoors().contains(door));
    }

    @Test
    void testHasMonster(){
        chamber.addDoor(doorWithMonster);
        assertEquals(1, chamber.getMonster().size());
        assertTrue(chamber.getMonster().contains(monster));
    }
}
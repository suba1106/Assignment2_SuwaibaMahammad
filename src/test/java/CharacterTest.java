import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CharacterTest {
    private Character warrior;
    private Character wizard;
    private Item axe;
    private Item shield;
    private Monster monster;
    private MagicWand wand;

    @BeforeEach
    void setUp() {
        warrior = new Warrior("Thor");
        wizard = new Wizard("Gandalf");
        axe = new Axe();
        wand = new MagicWand();
        shield = new Shield();
        monster = new Monster("Goblin", 10, 2, 1);
    }

    @Test
    void testCharacterCreation() {
        assertEquals("Thor", warrior.getName());
        assertTrue(warrior.getHealth() > 0);
        assertTrue(warrior.getCraft() >= 0);
        assertTrue(warrior.getStrength() >= 0);

        assertEquals("Gandalf", wizard.getName());
        assertTrue(wizard.getHealth() > 0);
        assertTrue(wizard.getCraft() > 0);
        assertTrue(wizard.getStrength() >= 0);

        assertEquals("Goblin", monster.getName());
        assertTrue(monster.getHealth() > 0);
        assertTrue(monster.getCraft() > 0);
        assertTrue(monster.getStrength() >= 0);
    }

    @Test
    void testAddItemToInventory() {
        warrior.addInventory(axe);
        assertEquals(1, warrior.getInventory().size());
        assertTrue(warrior.getInventory().contains(axe));
    }

    @Test
    void testTakeDamage() {
        int initialHealth = warrior.getHealth();
        warrior.takeDamage(5);
        assertEquals(initialHealth - 5, warrior.getHealth());
    }

    @Test
    void testUse() {
        wizard.addInventory(axe);
        wizard.addInventory(shield);
        assertEquals(true, wizard.use(axe, shield));

        boolean expecteded = false;
        assertEquals(expecteded, wizard.use(axe, wand));
    }

    @Test
    void testUse1() {
        boolean expected = true;
        wizard.addInventory(axe);
        wizard.addInventory(shield);
        assertEquals(expected, wizard.use(axe));
    }

    @Test
    void testGetEquipped() {
        Item[] expected = { axe, shield };
        wizard.addInventory(axe);
        wizard.addInventory(shield);
        wizard.use(axe, shield);
        wizard.showEquipped();
        assertArrayEquals(expected, wizard.getEquipped());
    }

    @Test
    void removeItem() {
        wizard.addInventory(axe);
        wizard.removeItem(axe);
        assertEquals(0, wizard.getInventory().size());
    }
}

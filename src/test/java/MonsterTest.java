import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MonsterTest {
    private Monster monster;
    private Monster monster2;

    @BeforeEach
    void setUp() {
        monster = new Monster("Goblin", 10, 2, 1);
        monster2 = new Monster("Pterodactyl", 10, 2, 0);
    }

    @Test
    void isAlive() {
        assertTrue(monster.isAlive());
        assertFalse(monster2.isAlive());
    }

    @Test
    void getName() {
        assertEquals("Goblin", monster.getName());
        assertEquals("Pterodactyl", monster2.getName());
    }
}
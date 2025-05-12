import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemTest {

    @Test
    void getStrength() {
        Item axe = new Axe();
        Item wand = new MagicWand();
        assertEquals(8, axe.getStrength());
        assertEquals(1, wand.getStrength());
    }

    @Test
    void getCraft() {
        Item axe = new Axe();
        Item wand = new MagicWand();
        assertEquals(0, axe.getCraft());
        assertEquals(7, wand.getCraft());
    }
}
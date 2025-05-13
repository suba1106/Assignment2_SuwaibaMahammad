public class Game {
    //------------------------------------------------------
    // Assignment 2
    // Written by: Suwaiba Mahammad 2144851
    // For SES350 Section (305) – Spring 2025
    // --------------------------------------------------------
    // this ia DUNGEONS AND DRAGONS game type progra. it has a tex based ui
    public static void main(String[] args) {
        // initialize some chambers
        Chamber[] chambers = new Chamber[] {
                new Chamber(),
                new Chamber(new Axe()),
                new Chamber(new Shield()),
                new Chamber(new MagicWand()),
                new Chamber(), new Chamber()
        };
        // connect the chambers with doors
        Door.connect(chambers[0], chambers[1]);
        Door.connect(chambers[1], chambers[2], new Monster("Goblin", 1, 0, 3));
        Door.connect(chambers[2], chambers[3], new Monster("Spider", 3, 0, 5));
        Door.connect(chambers[3], chambers[4]);
        Door.connect(chambers[4], chambers[5], new Monster("Boss", 0, 6, 7));
        Character player = new Wizard("Gandalf");
        // initialize the dungeon with player, entry chamber, and goal chamber
        Dungeon d = new Dungeon(player, chambers[0], chambers[5]);
        TextUI ui = new TextUI(); ui.play(d);
    }
}
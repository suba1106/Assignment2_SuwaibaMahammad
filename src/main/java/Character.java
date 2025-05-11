import java.util.ArrayList;

public abstract class Character {
    int strength;
    int craft;
    int health;
    String name;
    Item[] hand = new Item[2];
    ArrayList<Item> inventory = new ArrayList<>();

    // creates a Character and sets the initial strength, craft and health
    protected Character(String name, int strength, int craft, int health) {
        this.strength = strength;
        this.craft = craft;
        this.health = health;
        this.name = name;
    }

    // sets the two weapons that are in the hands
    public boolean use(Item item1, Item item2) {
        if (inventory.contains(item1) && inventory.contains(item2)) {
            hand[0] = item1;
            hand[1] = item2;
            return true;
        } else {
            System.out.println("Both items must be in inventory.");
            return false;
        }
    }

    // shows the inventory
    public void showInventory() {
        System.out.println("Inventory:");
        for (Item item : inventory) {
            System.out.println("- " + item.name);
        }
    }

    // shows the equipped
    public void showEquipped() {
        System.out.println("Equipped:");
        for (Item item : hand) {
            System.out.println(item + " /n");
        }
    }

    protected int getCraft() {
        return craft;
    }

    protected int getHealth() {
        return health;
    }

    protected int getStrength() {
        return strength;
    }

    protected String getName() {
        return name;
    }

}

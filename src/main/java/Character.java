import java.util.ArrayList;
import java.util.List;

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

    public boolean use(Item item1) {
        if (hand[0] == null) {
            hand[0] = item1;
            return true;
        } else if (hand[1] == null) {
            hand[1] = item1;
            return true;
        } else {
            System.out.println("You can only have 2 items in hand");
            return false;
        }
    }

    // shows the inventory
    public void showInventory() {
        System.out.println("Inventory:");
        for (int i = 0; i < inventory.size(); i++) {
            System.out.println(i + ": " + inventory.get(i).name);
        }
    }

    // shows the equipped
    public void showEquipped() {
        System.out.println("Equipped:");
        for (int i = 0; i < hand.length; i++) {
            System.out.println(i + ": " + hand[i].name);
        }
    }

    public Item[] getEquipped() {
        return hand;
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

    protected void takeDamage(int damage) {
        health -= damage;
    }

    public List<Item> getInventory() {
        return inventory;
    }

    public boolean swap(Item inventoryItem, Item handItem) {
        for (int i = 0; i < equipped.length; i++) {
            if (equipped[i] == inventoryItem) {
                equipped[i] = handItem;
                return true;
        }
    }return false;
    }

    // Item not found in equipped list
    return false;
}

}

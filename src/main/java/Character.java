import java.util.ArrayList;
import java.util.List;

public abstract class Character {
    int strength;
    int craft;
    int health;
    String name;
    Item[] hand = new Item[2];
    ArrayList<Item> inventory = new ArrayList<>();

    /**
     * creates a Character and sets the initial strength, craft and health
     * 
     * @param name     the name of your character
     * @param strength how strong your character is
     * @param craft    how crafty your character is
     * @param health   initial hp of the character
     */
    protected Character(String name, int strength, int craft, int health) {
        this.strength = strength;
        this.craft = craft;
        this.health = health;
        this.name = name;
    }

    /**
     * sets the two weapons that are in the hands and removes from inventory
     * 
     * @param item1 the first weapon you want to equip
     * @param item2 second weapon you want to equip
     */
    public boolean use(Item item1, Item item2) {
        if (inventory.contains(item1) && inventory.contains(item2)) {
            hand[0] = item1;
            hand[1] = item2;
            inventory.remove(item1);
            inventory.remove(item2);
            return true;
        } else {
            System.out.println("Both items must be in inventory.");
            return false;
        }
    }

    /**
     * sets the weapon that are in the hands and removes from inventory
     * 
     * @param item1 the item you want equipped
     * @return true if task completed successfully, false otherwise
     */
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

    /**
     * prints the inventory to the console
     */
    public void showInventory() {
        System.out.println("Inventory:");
        for (int i = 0; i < inventory.size(); i++) {
            System.out.println(i + ": " + inventory.get(i).name);
        }
    }

    /**
     * prints the weapons in hand to console
     */
    public void showEquipped() {
        System.out.println("Equipped:");
        for (int i = 0; i < hand.length; i++) {
            if (hand[i] != null) {
                System.out.println(i + ": " + hand[i].name);
            } else {
                System.err.println("There is nothing in this hand");
            }
        }
    }

    /**
     * gets the weapons in hand
     * 
     * @return array of items in hand
     */
    public Item[] getEquipped() {
        return hand;
    }

    /**
     * gets craft value of the character
     * 
     * @return int representing craft value
     */
    protected int getCraft() {
        return craft;
    }

    /**
     * gets health value of the character
     * 
     * @return int representing health value
     */
    protected int getHealth() {
        return health;
    }

    /**
     * gets strength value of the character
     * 
     * @return int representing strength value
     */
    protected int getStrength() {
        return strength;
    }

    /**
     * gets name of the character
     * 
     * @return string representing name
     */
    protected String getName() {
        return name;
    }

    /**
     * subtracts damage from the character's hp
     * 
     * @param damage the amount of damage done to the character
     */
    protected void takeDamage(int damage) {
        health -= damage;
    }

    /**
     * gets inventory
     * 
     * @return list of items representing inventory
     */
    public List<Item> getInventory() {
        return inventory;
    }

    /**
     * swaps an item from the inventory and equips it
     * 
     * @param inventoryItem the item from the inventory
     * @param handItem      the already equipped item
     * @return true if task completed successfully, false otherwise
     */
    public boolean swap(Item inventoryItem, Item handItem) {
        if (hand[0] == handItem) {
            hand[0] = inventoryItem;
            inventory.remove(inventoryItem);
            inventory.add(handItem);
            return true;
        } else if (hand[1] == handItem) {
            hand[1] = inventoryItem;
            inventory.remove(inventoryItem);
            inventory.add(handItem);
            return true;
        }
        return false;
    }

    /**
     * adds item to inventory
     * 
     * @param choose1 the item oyu want added
     */
    public void addInventory(Item choose1) {
        inventory.add(choose1);
    }

    /**
     * removes an item from the items list
     * 
     * @param item item wanting removal
     */
    protected void removeItem(Item item) {
        inventory.remove(item);
    }
}

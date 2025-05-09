import java.util.ArrayList;


class Character {
    int strength;
    int craft;
    int health;
    Item[] hand = new Item[2];
    ArrayList<Item> inventory = new ArrayList<>();

    //sets the two weapons that are in the hands
    private boolean use(Item item1, Item item2){
        if (inventory.contains(item1) && inventory.contains(item2)) {
            hand[0] = item1;
            hand[1] = item2;
            return true;
        } else {
            System.out.println("Both items must be in inventory.");
            return false;
        }
    }

    //shows the inventory
    public void showInventory() {
        System.out.println("Inventory:");
        for (Item item : inventory) {
            System.out.println("- " + item.name);
        }
    }

    //shows the equipped
    public void showEquipped() {
        System.out.println("Equipped:");
        for (Item item : hand) {
            System.out.println(item + " /n");
        }
    }
}

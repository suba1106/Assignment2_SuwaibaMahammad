import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

class Pick extends Action {
    List<Item> items;
    Dungeon dungeon;

    /**
     * pick constructor
     * @param dungeon the dungeon the player is in
     * @param items the list of items in the chamber
     */
    public Pick(Dungeon dungeon, List<Item> items) {
        this.items = items;
        this.dungeon = dungeon;
    }

    /**
     * gives the player 3 options. Pick something off the ground,
     * pick something from the inventory to equip,
     * pick something from the inventory to swap into hand
     * depending on the choice the function is called
     * @exception IOException e if the player inputs something wrong
     */
    @Override
    public void execute() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Choose what to do:");
        System.out.println("0: Pick an item from the chamber");
        System.out.println("1: Swap an item from your inventory to your hand");
        System.out.println("2. Pick something from your inventory to your hand");

        try {
            int choice = Integer.parseInt(reader.readLine());
            if (choice == 0) {
                pickFloor();
            } else if (choice == 1) {
                swapHand();
            } else if (choice == 2) {
                pickFromInvetory();
            } else {
                System.out.println("Invalid choice. Please enter 0, 1, or 2.");
            }
        } catch (IOException e) {
            System.out.println("Invalid input. Please try again.");
        }
    }

    /**
     * prints the inventory adn asks the user to choose the item they want to equip
     * if the hand already has 2 items, the system tells the user to choose the
     * other option
     */
    private void pickFromInvetory() {
        System.out.println("You have " + dungeon.getPlayer().getInventory().size() + " items in your iventory");
        dungeon.getPlayer().showInventory();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please input the number to equip: ");
        Item choose = null;
        try {
            int choice = Integer.parseInt(reader.readLine());
            choose = dungeon.getPlayer().getInventory().get(choice);
        } catch (IOException e) {
            System.out.println("Invalid input. Please try again.");
        }

        Item[] hand = dungeon.getPlayer().getEquipped();
        boolean worked = false;
        for (Item item : hand) {
            if (item == null) {
                worked = dungeon.getPlayer().use(choose);
                break;
            }
        }
        if (!worked) {
            System.out.println("The hand is full please use the swaphand method");
        }

    }

    /**
     * prints the inventory and prints the items in hand
     * asks the user to choose an item in hand and an item
     * from inventory
     * then the items are swapped
     */
    private void swapHand() {
        System.out.println("You have " + dungeon.getPlayer().inventory.size() + " items in your inventory\n");
        dungeon.getPlayer().showInventory();
        System.out.println("You have the following in hand right now: ");
        dungeon.getPlayer().showEquipped();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please input the number to equip: ");
        Item choose1 = null;

        try {
            int choice = Integer.parseInt(reader.readLine());
            choose1 = dungeon.getPlayer().getInventory().get(choice);
        } catch (IOException e) {
            System.out.println("Invalid input. Please try again.");
        }

        System.out.println("Please input the number in hand to swap: ");
        Item choose2 = null;

        try {
            int choice = Integer.parseInt(reader.readLine());
            choose2 = dungeon.getPlayer().getEquipped()[choice];
        } catch (IOException e) {
            System.out.println("Invalid input. Please try again.");
        }

        if (dungeon.getPlayer().swap(choose1, choose2)) {
            System.out.println("Success");
        } else {
            System.err.println("Swap failed");
        }
    }

    /**
     * picks an item off the chamber floor and adds ot inventory
     * asks the user to choose which object to pick up after
     * printing everything in the chamber
     */
    private void pickFloor() {
        List<Item> items = dungeon.getCurrentChamber().getItems();
        System.out.println("Items in chamber:");

        for (int i = 0; i < items.size(); i++) {
            System.out.println(i + ": " + items.get(i).name);
        }

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please input the number to pickup: ");
        Item choose1 = null;
        try {
            int choice = Integer.parseInt(reader.readLine());
            choose1 = items.get(choice);
        } catch (IOException e) {
            System.out.println("Invalid input. Please try again.");
        }

        dungeon.getPlayer().addInventory(choose1);
    }

    /**
     * overriding method from parent
     * @return "Pick"
     */
    @Override
    public String toString() {
        return "Pick";
    }
}

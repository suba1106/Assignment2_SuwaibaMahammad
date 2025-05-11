import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

class Pick extends Action {
    List<Item> items;
    Dungeon dungeon;

    public Pick(Dungeon dungeon, List<Item> items) {
        this.items = items;
        this.dungeon = dungeon;
    }

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
                swaphand();
            } else if (choice == 2) {
                pickFromInvetory();
            } else {
                System.out.println("Invalid choice. Please enter 0, 1, or 2.");
            }
        } catch (IOException e) {
            System.out.println("Invalid input. Please try again.");
        }
    }

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
        Boolean worked = false;
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

    private void swaphand() {
        System.out.println("You have " + dungeon.getPlayer().inventory.size() + " items in your iventory");
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
}

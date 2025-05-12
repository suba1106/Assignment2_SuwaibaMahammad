import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Random;

class Fight extends Action {
    private Character player;
    private Monster monster;
    private List<Monster> monsterList = null;
    private Random rand = new Random();
    private Door door;
    private Chamber ch;

    public Fight(Door d, Character player, Monster monster) {
        this.player = player;
        this.monster = monster;
        this.door = d;
    }

    public Fight(Chamber ch, Character player, List<Monster> monster) { // if multiple monsters in chamber ask which
        this.player = player;
        this.monsterList = monster;
        this.ch = ch;
    }

    private static Monster chooseMonster(List<Monster> monster) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            try {
                System.out.println("Choose a monster:");
                for (int i = 0; i < monster.size(); i++) {
                    System.out.println(i + ": " + monster.get(i).getName());
                }
                int choice = Integer.parseInt(reader.readLine());
                return monster.get(choice);
            } catch (IOException e) {
                System.out.println("Invalid input. Please try again.");
            }
        }

    }

    public void execute() {
        if (monster == null && monsterList != null) {
            monster = chooseMonster(monsterList); // choose only now
        }
        for (Door doo : ch.getDoors()) {
            if (doo.hasMonster() && monster == doo.getMonster()) {
                door = doo;
            }
        }

        System.out.println("A fight begins!");

        while (player.getHealth() > 0 && monster.getHealth() > 0) {
            int playerRoll = rand.nextInt(6) + 1;
            int monsterRoll = rand.nextInt(6) + 1;

            int playerStat = 0;
            int monsterStat = 0;
            int itemBonus = 0;

            if (!(monster.getCraft() == 0)) {
                playerStat = player.getStrength();
                monsterStat = monster.getStrength();
                itemBonus = sumItemStrength(player.getEquipped());
            }

            if (!(monster.getStrength() == 0)) {
                playerStat = player.getCraft();
                monsterStat = monster.getCraft();
                itemBonus = sumItemCraft(player.getEquipped());
            }

            int playerTotal = playerRoll + playerStat + itemBonus;
            int monsterTotal = monsterRoll + monsterStat;

            System.out.println("You rolled: " + playerRoll + ", Monster rolled: " + monsterRoll);
            System.out.println("Player total: " + playerTotal + ", Monster total: " + monsterTotal);

            if (playerTotal > monsterTotal) {
                int damage = playerTotal - monsterTotal;
                monster.takeDamage(damage);
                System.out.println("You hit the monster for " + damage + " damage! Monster HP: " + monster.getHealth());
            } else if (monsterTotal > playerTotal) {
                int damage = monsterTotal - playerTotal;
                player.takeDamage(damage);
                System.out.println("The monster hits you for " + damage + " damage! Your HP: " + player.getHealth());
            } else {
                System.out.println("It's a tie! No one takes damage.");
            }
        }

        if (monster.getHealth() <= 0) {
            System.out.println("You defeated the monster!");
            door.removeMonster();
        } else {
            System.out.println("You were defeated...");
        }
    }

    private int sumItemStrength(Item[] items) {
        int bonus = 0;
        for (Item item : items) {
            if (item != null)
                bonus += item.getStrength();
        }
        return bonus;
    }

    private int sumItemCraft(Item[] items) {
        int bonus = 0;
        for (Item item : items) {
            if (item != null)
                bonus += item.getCraft();
        }
        return bonus;
    }

    @Override
    public String toString() {
        return "Fight";
    }
}

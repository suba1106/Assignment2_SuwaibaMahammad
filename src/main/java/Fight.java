import java.util.List;
import java.util.Random;

class Fight extends Action {
    private Character player;
    private Monster monster;
    private Random rand = new Random();

    public Fight(Character player, Monster monster) {
        this.player = player;
        this.monster = monster;
    }

    public Fight(Character player, List<Monster> monster) {
        // TODO Auto-generated constructor stub
    }

    public void execute() {
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
            monster.setDefeated(true); // optional
        } else {
            System.out.println("You were defeated...");
        }
    }

    private int sumItemStrength(Item[] items) {
        int bonus = 0;
        for (Item item : items) {
            bonus += item.getStrength();
        }
        return bonus;
    }

    private int sumItemCraft(Item[] items) {
        int bonus = 0;
        for (Item item : items) {
            bonus += item.getCraft();
        }
        return bonus;
    }
}

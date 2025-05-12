public abstract class Item {
    String name = "";
    int craft;
    int strength;

    /**
     * Item constructor
     * @param name name of weapon
     * @param craft craft value of weapon
     * @param strength strength value of weapon
     */
    protected Item(String name, int craft, int strength) {
        this.name = name;
        this.craft = craft;
        this.strength = strength;
    }

    /**
     * returns strength value of item
     * @return int representing strength
     */
    protected int getStrength() {
        return strength;
    }

    /**
     * returns craft value of item
     * @return int representing craft value
     */
    protected int getCraft() {
        return craft;
    }
}

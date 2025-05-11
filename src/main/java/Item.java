public abstract class Item {
    String name = "";
    int craft;
    int strength;

    protected Item(String name, int craft, int strength) {
        this.name = name;
        this.craft = craft;
        this.strength = strength;
    }

    protected int getStrength() {
        return strength;
    }

    protected int getCraft() {
        return craft;
    }
}

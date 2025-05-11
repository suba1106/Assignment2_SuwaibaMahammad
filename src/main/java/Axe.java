class Axe extends Item {
    Axe() {
        super("Axe", 0, 8);
    }

    @Override
    protected int getStrength() {
        return 8;
    }

    @Override
    protected int getCraft() {
        return 0;
    }

}

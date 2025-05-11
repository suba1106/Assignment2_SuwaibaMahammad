class MagicWand extends Item {
    MagicWand() {
        super("Axe", 7, 1);
    }

    @Override
    protected int getStrength() {
        return 1;
    }

    @Override
    protected int getCraft() {
        return 7;
    }
}

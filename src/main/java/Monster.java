class Monster extends Character {
    public Monster(String name, int str, int crf, int hea) {
        super(name, str, crf, hea);
    }

    public boolean isAlive() {
        return health > 0;
    }

    public String getName() {
        return name;
    }
}

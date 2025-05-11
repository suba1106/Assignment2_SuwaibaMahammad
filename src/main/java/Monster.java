class Monster extends Character {
    public Monster(String name, int str, int crf, int hea) {
        super(name, str, crf, hea);
    }

    public boolean isAlive() {
        if (health > 0)
            return true;
        return false;
    }

    public String getName() {
        return name;
    }
}

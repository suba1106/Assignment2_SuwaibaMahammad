class Monster extends Character {
    /**
     * monster constructor
     * @param name name of monster
     * @param str strength value of monster
     * @param crf craft of monster
     * @param hea initial health of monster
     */
    public Monster(String name, int str, int crf, int hea) {
        super(name, str, crf, hea);
    }

    /**
     * checks if the monster is alive
     * @return true if health > 0, false otherwise
     */
    public boolean isAlive() {
        return health > 0;
    }
}

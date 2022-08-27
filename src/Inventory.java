public class Inventory {
    private boolean food;
    private boolean water;
    private boolean firewood;
    private Weapon weapon;
    private Armor armor;

    public Inventory() {
        this.weapon = new Weapon("Punch", 0, 0, 0);
        this.armor = new Armor("None", 0, 0, 0);
        this.food = false;
        this.water = false;
        this.firewood = false;

    }

    public boolean canWinGame() {
        return isFood() & isWater() & isFirewood();
    }

    public boolean isAward(String awardName) {
        switch (awardName) {
            case "food":
                return isFood();
            case "firewood":
                return isFirewood();
            case "water":
                return isWater();
        }

        return false;
    }

    public void setAward(String awardName) {
        switch (awardName) {
            case "food":
                setFood(true);
                break;
            case "firewood":
                setFirewood(true);
                break;
            case "water":
                setWater(true);
                break;
            default:
                break;
        }
    }

    public boolean isFood() {
        return food;
    }

    public void setFood(boolean food) {
        this.food = food;
    }

    public boolean isWater() {
        return water;
    }

    public void setWater(boolean water) {
        this.water = water;
    }

    public boolean isFirewood() {
        return firewood;
    }

    public void setFirewood(boolean firewood) {
        this.firewood = firewood;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Armor getArmor() {
        return armor;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }
}

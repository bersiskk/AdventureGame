public class GameChar {
    private String name;
    private int id;
    private int damage;
    private int health;
    private int money;
    private static GameChar[] charList = {
            new GameChar("Samurai", 1, 5, 21, 15),
            new GameChar("Archer", 2, 7, 18, 20),
            new GameChar("Knight", 3, 8, 24, 5)
    };

    public GameChar(String name, int id, int damage, int health, int money) {
        this.name = name;
        this.id = id;
        this.damage = damage;
        this.health = health;
        this.money = money;
    }

    public static void printChars() {
        System.out.println("==============================================================================");

        for (GameChar gameChar : getCharList()) {
            System.out.println("Character: " + gameChar.getName() + "\t\t" + "ID: " + gameChar.getId() + "\t\t"
                    + "Damage: " + gameChar.getDamage() + "\t\t" + "Health: " + gameChar.getHealth() + "\t\t"
                    + "Money: " + gameChar.getMoney());
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public static GameChar[] getCharList() {
        return charList;
    }

    public static void setCharList(GameChar[] charList) {
        GameChar.charList = charList;
    }
}

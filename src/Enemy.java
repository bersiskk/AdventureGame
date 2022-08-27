public class Enemy {
    private String name;
    private int id;
    private int damage;
    private int health;
    private int money;
    private static final Enemy[] enemyList = {
            new Enemy("Zombie", 1, 3, 10, 4),
            new Enemy("Vampire", 2, 4, 14, 7),
            new Enemy("Bear", 3, 7, 20, 12),
            new Enemy("Snake", 4, randomNumber(3, 6), 12, 0),
    };

    public Enemy(String name, int id, int damage, int health, int money) {
        this.name = name;
        this.id = id;
        this.damage = damage;
        this.health = health;
        this.money = money;
    }

    public static int randomNumber(int from, int to) {
        return from + (int) Math.round(Math.random() * (to - from));
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
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

    public static Enemy[] getEnemyList() {
        return enemyList;
    }

}

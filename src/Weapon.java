public class Weapon {
    private String name;
    private int id;
    private int damage;
    private int price;
    private static final Weapon[] weaponList = {
            new Weapon("Pistol", 1, 2, 15),
            new Weapon("Sword", 2, 3, 35),
            new Weapon("Rifle", 3, 7, 45)
    };

    public Weapon(String name, int id, int damage, int price) {
        this.name = name;
        this.id = id;
        this.damage = damage;
        this.price = price;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public static Weapon[] getWeaponList() {
        return weaponList;
    }

}

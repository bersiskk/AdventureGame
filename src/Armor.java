public class Armor {
    private String name;
    private int id;
    private int block;
    private int price;
    private static final Armor[] armorList = {
            new Armor("Light", 1, 1, 15),
            new Armor("Medium", 2, 3, 25),
            new Armor("High", 3, 5, 40)
    };

    public Armor(String name, int id, int block, int price) {
        this.name = name;
        this.id = id;
        this.block = block;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getBlock() {
        return block;
    }

    public int getPrice() {
        return price;
    }

    public static Armor[] getArmorList() {
        return armorList;
    }

}

import java.util.Scanner;

public class Player {
    private String name;
    private int damage;
    private int health;
    private int money;
    private int rootDamage;
    private int rootHealth;
    private Inventory inventory;
    private Scanner scan = new Scanner(System.in);

    public Player(String name) {
        this.name = name;
        this.inventory = new Inventory();
    }

    public void selectChar() {
        GameChar.printChars();
        System.out.print("\nInput id to select your character: ");
        String charChoice = scan.nextLine();

        while (!(charChoice.equals("1") || charChoice.equals("2") || charChoice.equals("3"))) {
            System.out.print("Please input a valid id! : ");
            charChoice = scan.nextLine();
        }

        int charID = Integer.parseInt(charChoice);

        createPlayer(GameChar.getCharList()[charID - 1]);
    }

    public void createPlayer(GameChar gameChar) {
        this.damage = gameChar.getDamage();
        this.health = gameChar.getHealth();
        this.money = gameChar.getMoney();
        this.rootDamage = gameChar.getDamage();
        this.rootHealth = gameChar.getHealth();

        System.out.println("Your Character: " + gameChar.getName() + "\t\t" + "Damage: " + this.getDamage() + "\t\t"
                + "Health: " + this.getHealth() + "\t\t" + "Money: " + this.getMoney());
    }

    public int getDamage() {
        return this.damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return this.health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMoney() {
        return this.money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public int getRootDamage() {
        return rootDamage;
    }

    public int getRootHealth() {
        return rootHealth;
    }

    public Inventory getInventory() {
        return inventory;
    }

}

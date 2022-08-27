public class ToolStore extends NormalLoc {
    private String buyChoice;
    private int buyID;

    public ToolStore(Player player) {
        super(player, "Tool Store");
    }

    public boolean onLocation() {
        this.menu();
        return true;
    }

    public void menu() {
        System.out.println("Welcome to Store!");

        while (true) {
            System.out.print("\n1 - Weapons\n" + "2 - Armors\n" + "0 - Exit\n" + "Please make a choice: ");
            String menuChoice = scan.nextLine();

            while (!(menuChoice.equals("0") || menuChoice.equals("1") || menuChoice.equals("2"))) {
                System.out.print("Please input a proper number! : ");
                menuChoice = scan.nextLine();
            }

            if (menuChoice.equals("0")) break;

            while (true) {
                System.out.println();
                if (menuChoice.equals("1")) {
                    printWeapon();
                    if (buyID != 0) buyWeapon();
                } else {
                    printArmor();
                    if (buyID != 0) buyArmor();
                }

                if (buyID == 0) break;
            }
        }
    }

    public void printWeapon() {
        for (Weapon w : Weapon.getWeaponList()) {
            System.out.println(w.getId() + " - " + w.getName() + "\t" + "Damage: " + w.getDamage() + "\t" +
                    "Price: " + w.getPrice());
        }

        System.out.print("0 - Back\n" + "Equipped weapon: " + getPlayer().getInventory().getWeapon().getName()
                + "\t\tBalance: " + getPlayer().getMoney() + "\t\tSelect to buy: ");

        buyChoice = scan.nextLine();

        while (!(buyChoice.equals("0") || buyChoice.equals("1") || buyChoice.equals("2") || buyChoice.equals("3"))) {
            System.out.print("Please input a proper number! : ");
            buyChoice = scan.nextLine();
        }

        buyID = Integer.parseInt(buyChoice);
    }

    public void buyWeapon() {
        if (Weapon.getWeaponList()[buyID - 1].getName().equals(getPlayer().getInventory().getWeapon().getName())) {
            System.out.println("You already have this weapon!");
        } else if (Weapon.getWeaponList()[buyID - 1].getPrice() > getPlayer().getMoney()) {
            System.out.println("Your balance is not enough to buy this item!\n");
        } else {
            Weapon weapon = Weapon.getWeaponList()[buyID - 1];
            getPlayer().getInventory().setWeapon(weapon);
            getPlayer().setDamage(getPlayer().getRootDamage() + weapon.getDamage());
            getPlayer().setMoney(getPlayer().getMoney() - weapon.getPrice());
            System.out.println("->" + weapon.getName() + " is equipped. New balance is: " + getPlayer().getMoney());
        }
    }

    public void printArmor() {
        for (Armor a : Armor.getArmorList()) {
            System.out.println(a.getId() + " - " + a.getName() + "\t" + "Block: " + a.getBlock() + "\t" +
                    "Price: " + a.getPrice());
        }

        System.out.print("0 - Back\n" + "Equipped armor: " + getPlayer().getInventory().getArmor().getName()
                + "\t\tBalance: " + getPlayer().getMoney() + "\t\tSelect to buy: ");

        buyChoice = scan.nextLine();

        while (!(buyChoice.equals("0") || buyChoice.equals("1") || buyChoice.equals("2") || buyChoice.equals("3"))) {
            System.out.print("Please input a proper number! : ");
            buyChoice = scan.nextLine();
        }

        buyID = Integer.parseInt(buyChoice);
    }

    public void buyArmor() {
        if (Armor.getArmorList()[buyID - 1].getName().equals(getPlayer().getInventory().getArmor().getName())) {
            System.out.println("You already have this armor!");
        } else if (Armor.getArmorList()[buyID - 1].getPrice() > getPlayer().getMoney()) {
            System.out.println("Your balance is not enough to buy this item!\n");
        } else {
            Armor a = Armor.getArmorList()[buyID - 1];
            getPlayer().getInventory().setArmor(a);
            getPlayer().setMoney(getPlayer().getMoney() - a.getPrice());
            System.out.println("-> " + a.getName() + " is equipped. New balance is: " + getPlayer().getMoney());
        }
    }

}

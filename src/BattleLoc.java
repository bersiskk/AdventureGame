public abstract class BattleLoc extends Location {
    private Enemy enemy;
    private String award;
    String battleChoice;
    private int enemyNumber;
    private int enemyHealth;
    public boolean isDead;

    public BattleLoc(Player player, String name, Enemy enemy, String award) {
        super(player, name);
        this.enemy = enemy;
        this.award = award;

        if (name.equals("Mine")) {
            enemyNumber = Enemy.randomNumber(1, 5);
        } else {
            enemyNumber = Enemy.randomNumber(1, 3);
        }
    }

    public void battle() {
        while (enemyNumber > 0) {
            enemyHealth = this.enemy.getHealth();
            printPlayerStats();
            printEnemyStats();

            while (true) {
                System.out.print(getPlayer().getName() + "'s health: " + getPlayer().getHealth() + "\t\t" + this.enemy.getName()
                        + "'s health: " + enemyHealth + "\t\t" + "  Press 'r' to run or 'a' to attack: ");
                battleChoice = scan.nextLine();

                while (!(battleChoice.equals("r") || battleChoice.equals("a"))) {
                    System.out.print("Please make a valid choice! : ");
                    battleChoice = scan.nextLine();
                }

                if (battleChoice.equals("r")) break;

                if (Math.random() < 0.5) {
                    if (attackPlayer()) break;
                    if (attackEnemy()) break;
                } else {
                    if (attackEnemy()) break;
                    if (attackPlayer()) break;
                }

                System.out.println("-----------");
            }

            if (battleChoice.equals("r") || isDead) break;
        }
    }

    public boolean attackPlayer() {
        enemyHealth -= getPlayer().getDamage();
        System.out.println(getPlayer().getName() + " hit the " + this.enemy.getName() + " by " + getPlayer().getDamage());

        if (enemyHealth <= 0) {
            System.out.println(getPlayer().getName() + " killed a " + this.enemy.getName() + "!!");
            getPlayer().setMoney(getPlayer().getMoney() + this.enemy.getMoney());
            enemyNumber--;

            takeAward();

            return true;
        }
        return false;
    }

    public boolean attackEnemy() {
        int enemyHit = Math.max(0, (enemy.getDamage() - getPlayer().getInventory().getArmor().getBlock()));

        getPlayer().setHealth(getPlayer().getHealth() - enemyHit);

        System.out.println(this.enemy.getName() + " hit " + getPlayer().getName() + " by " + enemyHit);

        if (getPlayer().getHealth() <= 0) {
            System.out.println("\n********* YOU ARE DEAD!! GAME IS OVER *********");
            isDead = true;
            return true;
        }
        return false;
    }

    public void takeAward() {
        if (enemyNumber == 0) {
            System.out.println("\nAll " + this.enemy.getName() + "s are dead.");

            if (!(getPlayer().getInventory().isAward(this.award))) {
                getPlayer().getInventory().setAward(this.award);
                System.out.println("=== " + getPlayer().getName() + " has taken the " + this.award);
            }
        }
    }

    public void printPlayerStats() {
        System.out.println("------------------------------------------------");
        System.out.print(justify(getPlayer().getName() + " info:"));
        System.out.print("Damage: " + getPlayer().getDamage());
        System.out.print("\t\tHealth: " + getPlayer().getHealth());
        System.out.print("\t\tMoney: " + getPlayer().getMoney());
        System.out.println("\t\tBlock: " + getPlayer().getInventory().getArmor().getBlock());
    }

    private String justify(String str) {
        while (str.length() < 25) {
            str += " ";
        }
        return str;
    }

    public void printEnemyStats() {
        System.out.print(justify(this.enemy.getName() + "'s info:"));
        System.out.print("Damage: " + this.enemy.getDamage());
        System.out.print("\t\tHealth: " + this.enemy.getHealth());
        System.out.print("\t\tMoney: " + this.enemy.getMoney());
        System.out.println("\t\tAward: " + (getPlayer().getInventory().isAward(this.award) ? "-" : this.award) + "\n");
    }

    @Override
    public boolean onLocation() {
        System.out.println("Be careful! " + enemy.getName() + " number in here is: " + enemyNumber);
        System.out.print("Press 'r' to run or 'f' to fight: ");
        battleChoice = scan.nextLine();

        while (!(battleChoice.equals("r") || battleChoice.equals("f"))) {
            System.out.print("Please make a valid choice! : ");
            battleChoice = scan.nextLine();
        }

        if (battleChoice.equals("f")) {
            battle();
        }

        return true;
    }
}

public class Mine extends BattleLoc {
    public Mine(Player player) {
        super(player, "Mine", Enemy.getEnemyList()[3], "random");
    }

    @Override
    public boolean onLocation() {
        super.onLocation();
        return true;
    }

    @Override
    public void takeAward() {
        double awardChance = Math.random();

        if (awardChance <= 0.15) {
            Weapon awardWeapon;
            awardChance = Math.random();

            if (awardChance <= 0.50) {
                awardWeapon = Weapon.getWeaponList()[0];
            } else if (awardChance >= 0.80) {
                awardWeapon = Weapon.getWeaponList()[1];
            } else {
                awardWeapon = Weapon.getWeaponList()[2];
            }

            System.out.println("Award from the snake is: Weapon - " + awardWeapon.getName());
            
            if (awardWeapon.getDamage() > getPlayer().getInventory().getWeapon().getDamage()) {
                getPlayer().getInventory().setWeapon(awardWeapon);
                System.out.println(awardWeapon.getName() + " is equipped.");
            }

        } else if (awardChance >= 0.85) {
            Armor awardArmor;
            awardChance = Math.random();

            if (awardChance <= 0.50) {
                awardArmor = Armor.getArmorList()[0];
            } else if (awardChance >= 0.70) {
                awardArmor = Armor.getArmorList()[1];
            } else {
                awardArmor = Armor.getArmorList()[2];
            }

            System.out.println("Award from the snake is: Armor - " + awardArmor.getName());

            if (awardArmor.getBlock() > getPlayer().getInventory().getArmor().getBlock()) {
                getPlayer().getInventory().setArmor(awardArmor);
                System.out.println(awardArmor.getName() + " armor is equipped.");
            }

        } else if (awardChance < 0.40){
            int awardMoney;
            awardChance = Math.random();

            if (awardChance <= 0.50) {
                awardMoney = 1;
            } else if (awardChance >= 0.70) {
                awardMoney = 5;
            } else {
                awardMoney = 10;
            }

            getPlayer().setMoney(getPlayer().getMoney() + awardMoney);
            System.out.println("Award from the snake is: " + awardMoney + " money");
        } else {
            System.out.println("There is no award from the snake.");
        }
    }
}

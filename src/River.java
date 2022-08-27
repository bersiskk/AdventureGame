public class River extends BattleLoc {
    public River(Player player) {
        super(player, "River", Enemy.getEnemyList()[2], "water");
    }

    @Override
    public boolean onLocation() {
        super.onLocation();
        return true;
    }
}

public class Forest extends BattleLoc {
    public Forest(Player player) {
        super(player, "Forest", Enemy.getEnemyList()[1], "firewood");
    }

    @Override
    public boolean onLocation() {
        super.onLocation();
        return true;
    }
}

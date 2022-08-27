public class Cave extends BattleLoc {
    public Cave(Player player) {
        super(player, "Cave", Enemy.getEnemyList()[0], "food");
    }

    @Override
    public boolean onLocation() {
        super.onLocation();
        return true;
    }
}

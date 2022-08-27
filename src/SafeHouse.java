public class SafeHouse extends NormalLoc {
    public SafeHouse(Player player) {
        super(player, "Safe House");
    }

    public boolean onLocation() {
        System.out.println("Health is fulled!");
        getPlayer().setHealth(getPlayer().getRootHealth());
        return true;
    }

}

import java.util.Scanner;

public abstract class Location {
    private Player player;
    private String name;
    protected Scanner scan = new Scanner(System.in);

    public Location(Player player, String name) {
        this.player = player;
        this.name = name;
        System.out.println("==============================================================================");
        System.out.println("You are at the " + "'" + this.name + "'");
    }

    public abstract boolean onLocation();

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

import java.util.Scanner;
public class Game {
    Location location;
    private boolean quitGame = false;
    String locChoice;
    int locNo;
    private Scanner scan = new Scanner(System.in);

    public void start() {
        System.out.println("Welcome to Adventure Game!");
        System.out.print("Please input the player name having at most 15 characters: ");

        String playerName = scan.nextLine();

        while (playerName.length() > 15) {
            System.out.println("Your input has more than 15 characters! Please try again: ");
            playerName = scan.nextLine();
        }

        Player player = new Player(playerName);
        System.out.println("Welcome " + player.getName());

        player.selectChar();

        while (player.getHealth() > 0) {
            location = null;
            selectLocation(player);

            if (player.getInventory().canWinGame() && locNo == 1) {
                System.out.println("\n========== CONGRATULATIONS!! YOU WIN ==========");
                break;
            }

            if (quitGame) {
                System.out.println("\n---------- GAME IS OVER!! GOODBYE ----------");
                break;
            }
        }
    }

    public void selectLocation(Player player) {
        System.out.println("==============================================================================");
        System.out.println("Locations:"
                + "\n1 - Safe House\t->\t<No enemies>\t<Health gets fulled>"
                + "\n2 - Tool Store\t->\t<No enemies>\t<Weapon & Armor can be purchased>"
                + "\n3 - Cave\t\t->\t<1-3 zombies>\t<Available Award: " + (player.getInventory().isFood() ? "- >" : "food>")
                + "\n4 - Forest\t\t->\t<1-3 vampires>\t<Available Award: " + (player.getInventory().isFirewood() ? "- >" : "firewood>")
                + "\n5 - River\t\t->\t<1-3 bears>\t\t<Available Award: " + (player.getInventory().isWater() ? "- >" : "water>")
                + "\n6 - Mine\t\t->\t<1-5 snakes>\t<Award: random>"
                + "\n0 - Quit game");

        if (player.getInventory().canWinGame()) {
            System.out.println("\n*=*=*= You collected all the awards! You will win the game if you go to Safe House.");
        }
        System.out.print("Select a location to go: ");

        locChoice = scan.nextLine();

        while (!(locChoice.equals("0") || locChoice.equals("1") || locChoice.equals("2") || locChoice.equals("3")
                || locChoice.equals("4") || locChoice.equals("5") || locChoice.equals("6"))) {
            System.out.print("Please select a proper location! : ");
            locChoice = scan.nextLine();
        }

        locNo = Integer.parseInt(locChoice);

        switch (locNo) {
            case 0:
                System.out.print("Do you want to quit? If yes, press 'y' : ");
                if (scan.nextLine().equals("y")) {
                    quitGame = true;
                }
                break;
            case 1:
                if (!player.getInventory().canWinGame()) {
                    location = new SafeHouse(player);
                }
                break;
            case 2:
                location = new ToolStore(player);
                break;
            case 3:
                if (player.getInventory().isAward("food")) {
                    System.out.println("--- Food is already collected so you cannot go there!");
                } else {
                    location = new Cave(player);
                }
                break;
            case 4:
                if (player.getInventory().isAward("firewood")) {
                    System.out.println("--- Firewood is already collected so you cannot go there!");
                } else {
                    location = new Forest(player);
                }
                break;
            case 5:
                if (player.getInventory().isAward("water")) {
                    System.out.println("--- Water is already collected so you cannot go there!");
                } else {
                    location = new River(player);
                }
                break;
            case 6:
                location = new Mine(player);
                break;
            default:
                break;
        }

        if (location != null) {
            location.onLocation();
        }
    }
}

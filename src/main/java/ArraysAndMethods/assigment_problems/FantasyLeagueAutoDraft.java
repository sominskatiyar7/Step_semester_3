import java.util.Arrays;
import java.util.Scanner;

class Player implements Comparable<Player> {

    private String name;
    private int matchesPlayed;
    private double battingAverage;
    private boolean injured;

    public Player(String name, int matchesPlayed, double battingAverage, boolean injured) {
        this.name = name;
        this.matchesPlayed = matchesPlayed;
        this.battingAverage = battingAverage;
        this.injured = injured;
    }

    static boolean isDraftable(int matchesPlayed) {
        return matchesPlayed >= 10;
    }

    static boolean isDraftable(int matchesPlayed, boolean injured) {
        return matchesPlayed >= 5 && !injured;
    }

    int getMatchesPlayed() {
        return matchesPlayed;
    }

    boolean isInjured() {
        return injured;
    }

    @Override
    public int compareTo(Player other) {
        return Double.compare(other.battingAverage, this.battingAverage);
    }

    String getName() {
        return name;
    }
}

public class FantasyLeagueAutoDraft {

    static String draftAndRank(Player[] players) {

        Player[] draftable = new Player[players.length];
        int count = 0;

        for (Player player : players) {
            if (Player.isDraftable(player.getMatchesPlayed()) ||
                Player.isDraftable(player.getMatchesPlayed(), player.isInjured())) {

                draftable[count] = player;
                count++;
            }
        }

        Player[] finalList = new Player[count];

        for (int i = 0; i < count; i++) {
            finalList[i] = draftable[i];
        }

        Arrays.sort(finalList);

        String result = "";

        for (int i = 0; i < finalList.length; i++) {
            result = result + (i + 1) + ". " + finalList[i].getName();

            if (i < finalList.length - 1) {
                result = result + " | ";
            }
        }

        return result;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of players: ");
        int n = sc.nextInt();
        sc.nextLine();

        Player[] players = new Player[n];

        for (int i = 0; i < n; i++) {

            System.out.print("Enter name: ");
            String name = sc.nextLine();

            System.out.print("Enter matches played: ");
            int matchesPlayed = sc.nextInt();

            System.out.print("Enter batting average: ");
            double battingAverage = sc.nextDouble();

            System.out.print("Is injured? (true/false): ");
            boolean injured = sc.nextBoolean();
            sc.nextLine();

            players[i] = new Player(
                name,
                matchesPlayed,
                battingAverage,
                injured
            );
        }

        System.out.println(draftAndRank(players));
    }
}
import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your choice (rock/paper/scissors): ");
        String player = sc.nextLine().toLowerCase();

        String computer = "rock"; // change this if needed

        System.out.println("Computer chose: " + computer);

        if (player.equals(computer)) {
            System.out.println("Draw");
        } else if ((player.equals("rock") && computer.equals("scissors")) ||
                   (player.equals("paper") && computer.equals("rock")) ||
                   (player.equals("scissors") && computer.equals("paper"))) {
            System.out.println("You win");
        } else {
            System.out.println("Computer wins");
        }

        sc.close();
    }
}
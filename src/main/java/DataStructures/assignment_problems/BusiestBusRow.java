import java.util.Scanner;

public class BusiestBusRow {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int rows = sc.nextInt();
        int cols = sc.nextInt();

        int bestRow = 0;
        int bestTotal = -1;

        for (int i = 0; i < rows; i++) {
            int rowTotal = 0;

            for (int j = 0; j < cols; j++) {
                rowTotal += sc.nextInt();
            }

            if (rowTotal > bestTotal) {
                bestTotal = rowTotal;
                bestRow = i;
            }
        }

        System.out.println("Row " + bestRow + ", Total " + bestTotal);

        sc.close();
    }
}

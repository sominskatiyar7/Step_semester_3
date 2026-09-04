import java.util.Scanner;

public class BestTimeToBuySellStock {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of days: ");
        int n = sc.nextInt();

        int[] prices = new int[n];

        System.out.println("Enter prices:");
        for (int i = 0; i < n; i++) {
            prices[i] = sc.nextInt();
        }

        int min = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < n; i++) {
            if (prices[i] < min) {
                min = prices[i];
            }

            int profit = prices[i] - min;

            if (profit > maxProfit) {
                maxProfit = profit;
            }
        }

        System.out.println("Maximum Profit = " + maxProfit);
    }
}
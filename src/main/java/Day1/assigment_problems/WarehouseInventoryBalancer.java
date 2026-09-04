import java.util.Scanner;

public class WarehouseInventoryBalancer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of items: ");
        int n = sc.nextInt();

        int[] sectionA = new int[n];
        int[] sectionB = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter Section A quantity: ");
            sectionA[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            System.out.print("Enter Section B quantity: ");
            sectionB[i] = sc.nextInt();
        }

        int totalA = 0;
        int totalB = 0;
        int highest = sectionA[0];
        String section = "Section A";
        int index = 0;

        for (int i = 0; i < n; i++) {
            totalA += sectionA[i];
            totalB += sectionB[i];

            if (sectionA[i] > highest) {
                highest = sectionA[i];
                section = "Section A";
                index = i;
            }

            if (sectionB[i] > highest) {
                highest = sectionB[i];
                section = "Section B";
                index = i;
            }
        }

        System.out.print("Section A Total: " + totalA);
        System.out.print(" | Section B Total: " + totalB);

        if (totalA == totalB)
            System.out.print(" | Status: Balanced");
        else
            System.out.print(" | Status: Not Balanced");

        System.out.println(" | Highest Quantity: " + highest
                + " (" + section + ", Item " + (index + 1) + ")");

        sc.close();
    }
}
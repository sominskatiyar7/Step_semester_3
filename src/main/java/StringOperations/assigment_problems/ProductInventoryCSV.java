import java.util.Scanner;

public class ProductInventoryCSV {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter product record: ");
        String record = sc.nextLine();

        String[] data = record.split(",");

        if (data.length != 3) {
            System.out.println("Invalid Record");
        } else {
            System.out.println("Product: " + data[0] +
                    " | SKU: " + data[1] +
                    " | Qty: " + data[2]);
        }

        sc.close();
    }
}
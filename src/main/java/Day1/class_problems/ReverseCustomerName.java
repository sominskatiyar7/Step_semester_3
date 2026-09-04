import java.util.Scanner;

public class ReverseCustomerName {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter customer name: ");
        String name = sc.nextLine();

        String reverse = new StringBuilder(name).reverse().toString();

        System.out.println("Reversed name: " + reverse);

        sc.close();
    }
}
import java.util.Scanner;

public class BankTransactionReference {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter reference: ");
        String reference = sc.nextLine().trim();

        if (reference.length() != 14) {
            System.out.println("Invalid: wrong length");
            sc.close();
            return;
        }

        String bankCode = reference.substring(0, 3).toUpperCase();
        String rest = reference.substring(3);

        for (int i = 0; i < bankCode.length(); i++) {
            if (!Character.isLetter(bankCode.charAt(i))) {
                System.out.println("Invalid: bank code must be 3 letters");
                sc.close();
                return;
            }
        }

        for (int i = 0; i < rest.length(); i++) {
            if (!Character.isDigit(rest.charAt(i))) {
                System.out.println("Invalid: body must contain digits");
                sc.close();
                return;
            }
        }

        String date = rest.substring(0, 6);
        String sequence = rest.substring(6);

        StringBuilder result = new StringBuilder();
        result.append("[");
        result.append(bankCode);
        result.append("] DATE: ");
        result.append(date.substring(0, 2));
        result.append("/");
        result.append(date.substring(2, 4));
        result.append("/");
        result.append(date.substring(4, 6));
        result.append(" | SEQ: ");
        result.append(sequence);

        System.out.println(result);

        sc.close();
    }
}
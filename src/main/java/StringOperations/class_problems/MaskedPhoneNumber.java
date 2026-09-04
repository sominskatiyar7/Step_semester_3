import java.util.Scanner;

public class MaskedPhoneNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter phone number: ");
        String phone = sc.nextLine();

        boolean valid = phone.length() == 10;

        for (int i = 0; i < phone.length(); i++) {
            if (!Character.isDigit(phone.charAt(i))) {
                valid = false;
                break;
            }
        }

        if (valid) {
            StringBuilder result = new StringBuilder("XXXXXX");
            result.insert(6, "-" + phone.substring(6));

            System.out.println(result);
        } else {
            System.out.println("Invalid phone number");
        }

        sc.close();
    }
}
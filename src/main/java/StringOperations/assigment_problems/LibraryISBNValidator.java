import java.util.Scanner;

public class LibraryISBNValidator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter ISBN code: ");
        String code = sc.nextLine().trim();

        if (code.length() != 13) {
            System.out.println("Invalid: wrong length");
            sc.close();
            return;
        }

        String publisher = code.substring(0, 3).toUpperCase();
        String body = code.substring(3);

        for (int i = 0; i < publisher.length(); i++) {
            if (!Character.isLetter(publisher.charAt(i))) {
                System.out.println("Invalid: publisher code must be 3 letters");
                sc.close();
                return;
            }
        }

        for (int i = 0; i < body.length(); i++) {
            if (!Character.isDigit(body.charAt(i))) {
                System.out.println("Invalid: body must contain digits");
                sc.close();
                return;
            }
        }

        String year = body.substring(0, 4);
        String catalog = body.substring(4);

        StringBuilder result = new StringBuilder();
        result.append("[");
        result.append(publisher);
        result.append("] YEAR: ");
        result.append(year);
        result.append(" | CATALOG: ");
        result.append(catalog);

        System.out.println(result);

        sc.close();
    }
}
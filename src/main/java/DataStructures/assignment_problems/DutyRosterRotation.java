import java.util.Scanner;
import java.util.Arrays;

public class DutyRosterRotation {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String[] names = new String[n];

        for (int i = 0; i < n; i++)
            names[i] = sc.next();

        long k = sc.nextLong();
        int shift = (int) (k % n);

        String[] rotated = new String[n];

        for (int i = 0; i < n; i++) {
            int newIndex = (i + shift) % n;
            rotated[newIndex] = names[i];
        }

        System.out.println(Arrays.toString(rotated));

        sc.close();
    }
}

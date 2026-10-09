import java.util.Scanner;

abstract class LibraryFineItem {
    String title;
    int daysLate;

    LibraryFineItem(String title, int daysLate) {
        this.title = title;
        this.daysLate = daysLate;
    }

    abstract double getFine();
}

class FineBook extends LibraryFineItem {
    FineBook(String title, int daysLate) {
        super(title, daysLate);
    }

    double getFine() {
        return daysLate * 2;
    }
}

class FineDVD extends LibraryFineItem {
    FineDVD(String title, int daysLate) {
        super(title, daysLate);
    }

    double getFine() {
        return Math.min(daysLate * 5, 50);
    }
}

class FineMagazine extends LibraryFineItem {
    FineMagazine(String title, int daysLate) {
        super(title, daysLate);
    }

    double getFine() {
        return daysLate;
    }
}

public class LibraryLateFine {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String title = sc.next();
            int daysLate = sc.nextInt();

            LibraryFineItem item;

            if (type.equals("BOOK")) {
                item = new FineBook(title, daysLate);
            } else if (type.equals("DVD")) {
                item = new FineDVD(title, daysLate);
            } else {
                item = new FineMagazine(title, daysLate);
            }

            double fine = item.getFine();

            System.out.printf("%s: %.2f%n", title, fine);
            total += fine;
        }

        System.out.printf("Total Fines: %.2f%n", total);
        sc.close();
    }
}
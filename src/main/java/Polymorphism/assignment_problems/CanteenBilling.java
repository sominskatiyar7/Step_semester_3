import java.util.Scanner;

abstract class Customer {
    double amount;

    Customer(double amount) {
        this.amount = amount;
    }

    abstract double getFinalAmount();
}

class StudentCustomer extends Customer {

    StudentCustomer(double amount) {
        super(amount);
    }

    double getFinalAmount() {
        return amount - (amount * 0.10);
    }
}

class StaffCustomer extends Customer {

    StaffCustomer(double amount) {
        super(amount);
    }

    double getFinalAmount() {
        return amount - (amount * 0.05);
    }
}

class GuestCustomer extends Customer {

    GuestCustomer(double amount) {
        super(amount);
    }

    double getFinalAmount() {
        return amount + 10;
    }
}

public class CanteenBilling {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            double amount = sc.nextDouble();

            Customer customer;

            if (type.equals("STUDENT")) {
                customer = new StudentCustomer(amount);
            } else if (type.equals("STAFF")) {
                customer = new StaffCustomer(amount);
            } else {
                customer = new GuestCustomer(amount);
            }

            double finalAmount = customer.getFinalAmount();

            System.out.printf("%s: %.2f%n", type, finalAmount);

            total += finalAmount;
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}
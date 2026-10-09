import java.util.Scanner;

abstract class ElectricityConnection {
    int units;

    ElectricityConnection(int units) {
        this.units = units;
    }

    abstract double getBill();
}

class HomeConnection extends ElectricityConnection {
    HomeConnection(int units) {
        super(units);
    }

    double getBill() {
        if (units <= 100) {
            return units * 5;
        }
        return 100 * 5 + (units - 100) * 7;
    }
}

class ShopConnection extends ElectricityConnection {
    ShopConnection(int units) {
        super(units);
    }

    double getBill() {
        return units * 8 + 100;
    }
}

class FactoryConnection extends ElectricityConnection {
    FactoryConnection(int units) {
        super(units);
    }

    double getBill() {
        return Math.max(units * 6, 1000);
    }
}

public class ElectricityBilling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int units = sc.nextInt();

            ElectricityConnection connection;

            if (type.equals("HOME")) {
                connection = new HomeConnection(units);
            } else if (type.equals("SHOP")) {
                connection = new ShopConnection(units);
            } else {
                connection = new FactoryConnection(units);
            }

            double bill = connection.getBill();

            System.out.printf("%s: %.2f%n", type, bill);
            total += bill;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
import java.util.Scanner;

interface NightService {
    double getNightFare(double fare);
}

abstract class Cab {
    double km;

    Cab(double km) {
        this.km = km;
    }

    abstract double getRate();

    double getFare() {
        return Math.max(km * getRate(), 100);
    }
}

class MiniCab extends Cab {
    MiniCab(double km) {
        super(km);
    }

    double getRate() {
        return 10;
    }
}

class SedanCab extends Cab implements NightService {
    SedanCab(double km) {
        super(km);
    }

    double getRate() {
        return 14;
    }

    public double getNightFare(double fare) {
        return fare * 1.20;
    }
}

class SUVCab extends Cab implements NightService {
    SUVCab(double km) {
        super(km);
    }

    double getRate() {
        return 18;
    }

    public double getNightFare(double fare) {
        return fare * 1.20;
    }
}

public class CityCabFare {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double km = sc.nextDouble();
            String time = sc.next();

            Cab cab;

            if (type.equals("MINI")) {
                cab = new MiniCab(km);
            } else if (type.equals("SEDAN")) {
                cab = new SedanCab(km);
            } else {
                cab = new SUVCab(km);
            }

            if (time.equals("NIGHT") &&
                !(cab instanceof NightService)) {
                System.out.println(
                    type + ": night service not available"
                );
                continue;
            }

            double fare = cab.getFare();

            if (time.equals("NIGHT")) {
                fare = ((NightService) cab).getNightFare(fare);
            }

            System.out.printf("%s: %.2f%n", type, fare);
            total += fare;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
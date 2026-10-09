import java.util.Scanner;

interface SaverMode {
    double getSaverUnits(double hours);
}

abstract class Appliance {
    double power;

    Appliance(double power) {
        this.power = power;
    }

    double getUnits(double hours) {
        return power * hours / 1000;
    }
}

class Fridge extends Appliance {
    Fridge() {
        super(150);
    }
}

class AirConditioner extends Appliance implements SaverMode {
    AirConditioner() {
        super(1500);
    }

    public double getSaverUnits(double hours) {
        return getUnits(hours) * 0.75;
    }
}

class Television extends Appliance {
    Television() {
        super(100);
    }
}

class WashingMachine extends Appliance implements SaverMode {
    WashingMachine() {
        super(500);
    }

    public double getSaverUnits(double hours) {
        return getUnits(hours) * 0.75;
    }
}

public class ApplianceEnergyReport {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double totalCost = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double hours = sc.nextDouble();

            boolean saver = sc.hasNext("SAVER");
            if (saver) {
                sc.next();
            }

            Appliance appliance;

            if (type.equals("FRIDGE")) {
                appliance = new Fridge();
            } else if (type.equals("AC")) {
                appliance = new AirConditioner();
            } else if (type.equals("TV")) {
                appliance = new Television();
            } else {
                appliance = new WashingMachine();
            }

            if (saver && !(appliance instanceof SaverMode)) {
                System.out.println(
                    type + ": saver mode not supported"
                );
                continue;
            }

            double units;

            if (saver) {
                units = ((SaverMode) appliance).getSaverUnits(hours);
            } else {
                units = appliance.getUnits(hours);
            }

            double cost = units * 8;

            System.out.printf(
                "%s: Units=%.2f Cost=%.2f%n",
                type, units, cost
            );

            totalCost += cost;
        }

        System.out.printf("Total Cost: %.2f%n", totalCost);
        sc.close();
    }
}
import java.util.Scanner;

interface BusUser {
    double getTransportFee();
}

abstract class StudentFee {
    String name;

    StudentFee(String name) {
        this.name = name;
    }

    abstract double getTuition();

    double getTotalFee() {
        double total = getTuition();

        if (this instanceof BusUser) {
            total += ((BusUser) this).getTransportFee();
        }

        return total;
    }
}

class DayScholar extends StudentFee implements BusUser {
    DayScholar(String name) {
        super(name);
    }

    double getTuition() {
        return 40000;
    }

    public double getTransportFee() {
        return 12000;
    }
}

class Hosteller extends StudentFee {
    Hosteller(String name) {
        super(name);
    }

    double getTuition() {
        return 40000 + 60000;
    }
}

class ScholarshipStudent extends StudentFee implements BusUser {
    ScholarshipStudent(String name) {
        super(name);
    }

    double getTuition() {
        return 20000;
    }

    public double getTransportFee() {
        return 12000;
    }
}

public class CollegeFeeCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();

            StudentFee student;

            if (type.equals("DAY_SCHOLAR")) {
                student = new DayScholar(name);
            } else if (type.equals("HOSTELLER")) {
                student = new Hosteller(name);
            } else {
                student = new ScholarshipStudent(name);
            }

            double fee = student.getTotalFee();

            System.out.printf("%s: %.2f%n", name, fee);
            total += fee;
        }

        System.out.printf("Total Collected: %.2f%n", total);
        sc.close();
    }
}
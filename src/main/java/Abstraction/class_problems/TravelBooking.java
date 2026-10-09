import java.util.Scanner;

abstract class BookingMode {
    double distance;

    static final double BOOKING_FEE = 50;

    BookingMode(double distance) {
        this.distance = distance;
    }

    abstract double getBaseFare();

    double getTotalFare() {
        return getBaseFare() + BOOKING_FEE;
    }
}

class BusTravel extends BookingMode {
    BusTravel(double distance) {
        super(distance);
    }

    double getBaseFare() {
        return distance * 2;
    }
}

class TrainTravel extends BookingMode {
    TrainTravel(double distance) {
        super(distance);
    }

    double getBaseFare() {
        return distance * 1.5;
    }
}

class FlightTravel extends BookingMode {
    FlightTravel(double distance) {
        super(distance);
    }

    double getBaseFare() {
        return 2500 + distance * 4;
    }
}

public class TravelBooking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String mode = sc.next();
            double distance = sc.nextDouble();

            BookingMode booking;

            if (mode.equals("BUS")) {
                booking = new BusTravel(distance);
            } else if (mode.equals("TRAIN")) {
                booking = new TrainTravel(distance);
            } else {
                booking = new FlightTravel(distance);
            }

            System.out.printf("%s: %.2f%n",
                    mode, booking.getTotalFare());
        }

        sc.close();
    }
}
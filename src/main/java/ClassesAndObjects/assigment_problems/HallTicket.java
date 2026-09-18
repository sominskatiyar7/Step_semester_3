class Ticket {
    String studentName;
    int seatNumber;

    Ticket(String studentName, int seatNumber) {
        this.studentName = studentName;
        this.seatNumber = seatNumber;
    }
}

public class HallTicket {
    public static void main(String[] args) {

        Ticket priya = new Ticket("Priya", 0);

        Ticket copy = priya;

        copy.seatNumber = 45;

        Ticket separate = new Ticket("Priya", 45);

        System.out.println(
            "Priya's seatNumber (via first variable): "
            + priya.seatNumber
        );

        System.out.println("copy == priya: " + (copy == priya));

        System.out.println("separate == priya: " + (separate == priya));
    }
}
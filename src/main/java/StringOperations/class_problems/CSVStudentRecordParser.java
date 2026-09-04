import java.util.Scanner;

public class CSVStudentRecordParser {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter student record: ");
        String record = sc.nextLine();

        String[] data = record.split(",");

        if (data.length != 3) {
            System.out.println("Invalid Record");
        } else {
            System.out.println("Name: " + data[0] +
                    " | Roll No: " + data[1] +
                    " | Dept: " + data[2]);
        }

        sc.close();
    }
}
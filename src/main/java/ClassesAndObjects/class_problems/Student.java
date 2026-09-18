class StudentDetails {
    String name;
    double attendance;

    static String collegeName =
        "SRM Institute of Science and Technology";

    static int studentCount = 0;

    StudentDetails(String name, double attendance) {
        this.name = name;
        this.attendance = attendance;
        studentCount++;
    }

    static void printCollegeInfo() {
        System.out.println(collegeName);
        System.out.println("Students created: " + studentCount);
    }
}

public class Student {
    public static void main(String[] args) {

        StudentDetails student1 =
            new StudentDetails("Ravi", 85.0);

        StudentDetails student2 =
            new StudentDetails("Anitha", 90.0);

        System.out.println("2 Student objects created");

        StudentDetails.printCollegeInfo();
    }
}
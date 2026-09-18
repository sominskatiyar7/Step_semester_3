class CourseDetails {
    String code;
    String title;
    int credits;
    int labCredits;

    public CourseDetails(String code, String title, int credits, int labCredits) {
        this.code = code;
        this.title = title;
        this.credits = credits;
        this.labCredits = labCredits;
    }

    public CourseDetails(String code, String title, int credits) {
        this(code, title, credits, 0);
    }

    int totalCredits() {
        return credits + labCredits;
    }
}

public class Course {
    public static void main(String[] args) {

        CourseDetails theoryCourse =
            new CourseDetails("21CSC201J", "Data Structures", 4);

        CourseDetails labCourse =
            new CourseDetails("21CSC205L", "DSA Lab", 3, 1);

        System.out.println(
            theoryCourse.code + " total credits: " +
            theoryCourse.totalCredits()
        );

        System.out.println(
            labCourse.code + " total credits: " +
            labCourse.totalCredits()
        );
    }
}
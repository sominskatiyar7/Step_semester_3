import java.util.Scanner;

abstract class Question {
    String correctAnswer;
    String studentAnswer;
    double points;

    Question(String correctAnswer, String studentAnswer, double points) {
        this.correctAnswer = correctAnswer;
        this.studentAnswer = studentAnswer;
        this.points = points;
    }

    abstract double getScore();
}

class MCQQuestion extends Question {

    MCQQuestion(String correctAnswer, String studentAnswer, double points) {
        super(correctAnswer, studentAnswer, points);
    }

    double getScore() {
        if (studentAnswer.equals(correctAnswer)) {
            return points;
        }
        return 0;
    }
}

class TFQuestion extends Question {

    TFQuestion(String correctAnswer, String studentAnswer, double points) {
        super(correctAnswer, studentAnswer, points);
    }

    double getScore() {
        if (studentAnswer.equals(correctAnswer)) {
            return points;
        }
        return 0;
    }
}

class EssayQuestion extends Question {

    EssayQuestion(String correctAnswer, String studentAnswer, double points) {
        super(correctAnswer, studentAnswer, points);
    }

    double getScore() {

        String[] keywords = correctAnswer.split(",");
        String answer = studentAnswer.toLowerCase();

        int count = 0;

        for (String keyword : keywords) {
            if (answer.contains(keyword.trim().toLowerCase())) {
                count++;
            }
        }

        if (count >= 2) {
            return points * 0.75;
        } else if (count == 1) {
            return points * 0.50;
        }

        return 0;
    }
}

public class ExaminationGrader {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        double total = 0;

        for (int i = 0; i < n; i++) {

            String line = sc.nextLine();

            String[] parts = line.split("\"");

            String type = parts[0].trim();

            String questionText = parts[1];
            String correctAnswer = parts[3];
            String studentAnswer = parts[5];

            double points = Double.parseDouble(
                parts[6].trim()
            );

            Question question;

            if (type.equals("MCQ")) {
                question = new MCQQuestion(
                    correctAnswer, studentAnswer, points
                );
            } else if (type.equals("TF")) {
                question = new TFQuestion(
                    correctAnswer, studentAnswer, points
                );
            } else {
                question = new EssayQuestion(
                    correctAnswer, studentAnswer, points
                );
            }

            double score = question.getScore();

            System.out.printf("%s: %.2f%n", type, score);

            total += score;
        }

        System.out.printf("Total Score: %.2f%n", total);

        sc.close();
    }
}
class QuizScore {
    private boolean[] results;
    private int answerCount;

    QuizScore(int numberOfQuestions) {
        results = new boolean[numberOfQuestions];
        answerCount = 0;
    }

    void recordAnswer(boolean correct) {
        if (answerCount < results.length) {
            results[answerCount] = correct;
            answerCount++;
        } else {
            System.out.println("All answers have already been recorded");
        }
    }

    int getScore() {
        int score = 0;

        for (int i = 0; i < answerCount; i++) {
            if (results[i]) {
                score++;
            }
        }

        return score;
    }
}

public class Scorecard {
    public static void main(String[] args) {

        QuizScore sc = new QuizScore(4);

        sc.recordAnswer(true);
        sc.recordAnswer(true);
        sc.recordAnswer(false);
        sc.recordAnswer(true);

        System.out.println("Score: " + sc.getScore());
    }
}
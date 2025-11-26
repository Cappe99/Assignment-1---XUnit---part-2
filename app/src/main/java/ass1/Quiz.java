package ass1;

import java.util.ArrayList;
import java.util.List;

public class Quiz {
    private List<Question> questions = new ArrayList<>();
    private int score = 0;

    public Quiz() {
        this.questions = new ArrayList<>();
        this.score = 0;
    }

    public void addQuestion(Question question) {
        questions.add(question);
    }

    public List<Question> getTotalQuestions() {
        return questions;
    }

    public int getScore() {
        return score;
    }

    public void increaseScore() {
        score++;
    }

    public String getLetterGrade() {
        int total = questions.size();

        double percent = 100.0 * score / total;

        if (percent >= 90) {
            return "A";
        } else if (percent >= 80) {
            return "B";
        } else if (percent >= 70) {
            return "C";
        } else if (percent >= 50) {
            return "D";
        } else if (percent >= 40) {
            return "E";
        }
        return "F";

    }

}

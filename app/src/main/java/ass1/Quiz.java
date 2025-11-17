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

}

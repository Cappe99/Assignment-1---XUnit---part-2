package ass1;

import java.util.ArrayList;
import java.util.List;

public class Quiz {
    private List<Question> questions = new ArrayList<>();

    public void addQuestion(Question question) {
        questions.add(question);
    }

    public List<Question> getTotalQuestions() {
        return questions;
    }

}

package ass1;

public class QuizController {
    private Quiz quiz;

    public QuizController(Quiz quiz) {
        this.quiz = quiz;
    }

    public void answerQuestion(Question question, int answerIndex) {
        if (question.isCorrect(answerIndex)) {
            quiz.increaseScore();
        }
    }
}

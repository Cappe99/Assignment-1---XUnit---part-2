package ass1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class QuizTest {

    @Test
    void shouldAddQuestionToQuiz() {

        Quiz quiz = new Quiz();

        Question question = new Question("What is 2+2?", List.of("3", "4", "5"), 1);

        quiz.addQuestion(question);

        assertEquals(1, quiz.getTotalQuestions().size());
    }

    @Test
    void shouldIncreaseScoreWhenAnswerISCorrect() {
        Quiz quiz = new Quiz();

        assertEquals(0, quiz.getScore());
        quiz.increaseScore();
        assertEquals(1, quiz.getScore());

    }

    @Test
    void shouldGetTotalQuestions() {
        Quiz quiz = new Quiz();

        Question question1 = new Question("What is 2+2?", List.of("3", "4", "5"), 1);
        Question question2 = new Question("What is the capital of France?", List.of("Berlin", "London", "Paris"), 2);

        quiz.addQuestion(question1);
        quiz.addQuestion(question2);

        List<Question> totalQuestions = quiz.getTotalQuestions();

        assertEquals(2, totalQuestions.size());
        assertTrue(totalQuestions.contains(question1));
        assertTrue(totalQuestions.contains(question2));
    }
}

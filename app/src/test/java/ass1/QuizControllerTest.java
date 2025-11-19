package ass1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class QuizControllerTest {
    @Test
    void shouldRunQuizAndUpdateScore() {
        Quiz quiz = new Quiz();
        Question question = new Question("What is 2+2?", List.of("3", "4", "5"), 1);
        quiz.addQuestion(question);

        QuizController controller = new QuizController(quiz);

        controller.answerQuestion(question, 1);

        assertEquals(1, quiz.getScore());
    }

    @Test
    void quizControllerShouldLoadTenQuestions() {
        Quiz quiz = new Quiz();
        QuizController controller = new QuizController(quiz);

        controller.loadDefaultQuestions();

        assertEquals(10, quiz.getTotalQuestions().size());
    }
}

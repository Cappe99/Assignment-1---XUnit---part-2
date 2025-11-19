package ass1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class QuizControllerTest {

    private Quiz quiz;
    private QuizController controller;

    @BeforeEach
    void setUp() {
        quiz = new Quiz();
        controller = new QuizController(quiz);
    }

    @Test
    void shouldRunQuizAndUpdateScore() {
        Question question = new Question("What is 2+2?", List.of("3", "4", "5"), 1);
        quiz.addQuestion(question);

        controller.answerQuestion(question, 1);

        assertEquals(1, quiz.getScore());
    }

    @Test
    void quizControllerShouldLoadTenQuestions() {
        controller.loadDefaultQuestions();

        assertEquals(10, quiz.getTotalQuestions().size());
    }
}

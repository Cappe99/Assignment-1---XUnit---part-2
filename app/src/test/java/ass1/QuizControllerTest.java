package ass1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class QuizControllerTest {

    private Quiz quiz;
    private QuizController controller;
    private Question simpleQuestion;

    @BeforeEach
    void setUp() {
        quiz = new Quiz();
        controller = new QuizController(quiz);
        simpleQuestion = new Question("What is 2+2?", List.of("3", "4", "5"), 1);
    }

    @Test
    void shouldRunQuizAndUpdateScore() {
        quiz.addQuestion(simpleQuestion);
        controller.answerQuestion(simpleQuestion, 1);
        assertEquals(1, quiz.getScore());
    }

    @Test
    void quizControllerShouldLoadTenQuestions() {
        controller.loadDefaultQuestions();

        assertEquals(10, quiz.getTotalQuestions().size());
    }

    @Test
    void shouldThrowExceptionIfAnswerIndexIsNegative() {
        quiz.addQuestion(simpleQuestion);
        assertThrows(IllegalArgumentException.class, () -> controller.answerQuestion(simpleQuestion, -1));
    }

    @Test
    void shouldThrowExceptionIfAnswerIndexIsTooLarge() {
        quiz.addQuestion(simpleQuestion);
        assertThrows(IllegalArgumentException.class, () -> controller.answerQuestion(simpleQuestion, 5));
    }

    @Test
    void scoreShouldNotIncreaseWhenAnswerIsInvalid() {
        quiz.addQuestion(simpleQuestion);

        try {
            controller.answerQuestion(simpleQuestion, 5);
        } catch (IllegalArgumentException e) {
        }

        assertEquals(0, quiz.getScore());
    }

    @Test
    void scoreShouldNotIncreaseWhenAnswerIsIncorrect() {
        quiz.addQuestion(simpleQuestion);
        controller.answerQuestion(simpleQuestion, 0);
        assertEquals(0, quiz.getScore());
    }
}

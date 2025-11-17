package ass1;

import org.junit.jupiter.api.BeforeEach;
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
}

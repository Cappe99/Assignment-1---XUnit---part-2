package ass1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class QuestionTest {

    private Question question;

    @BeforeEach
    void setUp() {
        question = new Question("What is 2+2?", List.of("3", "4", "5"), 1);
    }

    @Test
    void shouldReturnTrueIfAnswerIsCorrect() {
        assertTrue(question.isCorrect(1));
    }

    @Test
    void shouldReturnFalseIfAnswerIsWrong() {
        assertFalse(question.isCorrect(0));

    }

    @Test
    void shouldReturnQuestionText() {
        assertEquals("What is 2+2?", question.getText());
    }

    @Test
    void shouldReturnAnswerOptions() {
        assertEquals(List.of("3", "4", "5"), question.getOptions());
    }
}

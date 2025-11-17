package ass1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class QuestionTest {

    @Test
    void shouldReturnTrueIfAnswerIsCorrect() {

        // Arrange
        Question question = new Question(
                "What is 2 + 2?",
                List.of("3", "4", "5"),
                1);

        // Act
        boolean result = question.isCorrect(1);

        // Assert
        assertTrue(result);
    }

}

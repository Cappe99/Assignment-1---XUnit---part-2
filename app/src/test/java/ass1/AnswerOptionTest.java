package ass1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AnswerOptionTest {

    @Test
    void shouldReturnTrueIfOptionIsCorrect() {
        AnswerOption opt = new AnswerOption("4", true);
        assertTrue(opt.isCorrect());
    }
}

package ass1;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class AppTest {

    @Test
    void mainShouldRunWithoutException() {

        String simulatedInput = "1\n1\n1\n1\n1\n1\n1\n1\n1\n1\nq\n";
        ByteArrayInputStream in = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(in);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        assertDoesNotThrow(() -> App.main(new String[] {}));

        String output = out.toString();
        assertTrue(output.contains("Question") || output.contains("Quiz"),
                "Output should contain quiz content");
    }
}

// This is not my code!
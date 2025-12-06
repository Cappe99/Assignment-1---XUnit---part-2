package ass1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Collections;

public class QuizUITest {
    private QuizController mockController;
    private Quiz mockQuiz;
    private QuizUI quizUI;

    private final InputStream originalIn = System.in;
    private final PrintStream originalOut = System.out;
    private ByteArrayOutputStream outputStream;

    @BeforeEach
    void setUp() {
        mockController = mock(QuizController.class);
        mockQuiz = mock(Quiz.class);
        when(mockController.getQuiz()).thenReturn(mockQuiz);
    }

    @AfterEach
    void tearDown() {
        System.setIn(originalIn);
    }

    @Test
    void testQuizDisplaysWelcomeAndFinishMessages() {
        when(mockQuiz.getTotalQuestions()).thenReturn(Collections.emptyList());
        when(mockQuiz.getScore()).thenReturn(0);

        quizUI = new QuizUI(mockController);
        quizUI.run();

        verify(mockController).loadDefaultQuestions();
    }

    @Test
    void testQuestionIsDisplayedWithOptions() {
        Question mockQuestion = mock(Question.class);
        when(mockQuestion.getText()).thenReturn("Vad är 2+2?");
        when(mockQuestion.getOptions()).thenReturn(Arrays.asList("3", "4", "5"));

        when(mockQuiz.getTotalQuestions()).thenReturn(Arrays.asList(mockQuestion));
        when(mockQuiz.getScore()).thenReturn(1);

        String input = "1\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        quizUI = new QuizUI(mockController);
        quizUI.run();

        verify(mockController).answerQuestion(mockQuestion, 1);
    }

    @Test
    void testAnswerQuestionIsCalledWithUserInput() {
        Question mockQuestion = (Question) mock(Question.class);
        when(mockQuestion.getText()).thenReturn("Test?");
        when(mockQuestion.getOptions()).thenReturn(Arrays.asList("A", "B"));

        when(mockQuiz.getTotalQuestions()).thenReturn(Arrays.asList(mockQuestion));
        when(mockQuiz.getScore()).thenReturn(0);

        String input = "1\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        quizUI = new QuizUI(mockController);
        quizUI.run();

        verify(mockController).answerQuestion(mockQuestion, 1);
    }

    @Test
    void testScoreIsDisplayedCorrectly() {
        Question mockQuestion = mock(Question.class);
        when(mockQuestion.getText()).thenReturn("Q?");
        when(mockQuestion.getOptions()).thenReturn(Arrays.asList("A"));

        when(mockQuiz.getTotalQuestions()).thenReturn(Arrays.asList(mockQuestion));
        when(mockQuiz.getScore()).thenReturn(1);

        String input = "0\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        quizUI = new QuizUI(mockController);
        quizUI.run();

        assertEquals(1, mockQuiz.getScore());
    }

    @Test
    void testLetterGradeA() {
        when(mockQuiz.getTotalQuestions()).thenReturn(Collections.emptyList());
        when(mockQuiz.getScore()).thenReturn(9);
        when(mockQuiz.getLetterGrade()).thenReturn("A");

        quizUI = new QuizUI(mockController);
        quizUI.run();

        assertEquals("A", mockQuiz.getLetterGrade());
    }

    @Test
    void testLetterGradeB() {
        when(mockQuiz.getTotalQuestions()).thenReturn(Collections.emptyList());
        when(mockQuiz.getScore()).thenReturn(8);
        when(mockQuiz.getLetterGrade()).thenReturn("B");

        quizUI = new QuizUI(mockController);
        quizUI.run();

        assertEquals("B", mockQuiz.getLetterGrade());
    }

    @Test
    void testLetterGradeC() {
        when(mockQuiz.getTotalQuestions()).thenReturn(Collections.emptyList());
        when(mockQuiz.getScore()).thenReturn(7);
        when(mockQuiz.getLetterGrade()).thenReturn("C");

        quizUI = new QuizUI(mockController);
        quizUI.run();

        assertEquals("C", mockQuiz.getLetterGrade());
    }

    @Test
    void testLetterGradeD() {
        when(mockQuiz.getTotalQuestions()).thenReturn(Collections.emptyList());
        when(mockQuiz.getScore()).thenReturn(5);
        when(mockQuiz.getLetterGrade()).thenReturn("D");

        quizUI = new QuizUI(mockController);
        quizUI.run();

        assertEquals("D", mockQuiz.getLetterGrade());
    }

    @Test
    void testLetterGradeE() {
        when(mockQuiz.getTotalQuestions()).thenReturn(Collections.emptyList());
        when(mockQuiz.getScore()).thenReturn(4);
        when(mockQuiz.getLetterGrade()).thenReturn("E");

        quizUI = new QuizUI(mockController);
        quizUI.run();

        assertEquals("E", mockQuiz.getLetterGrade());
    }

    @Test
    void testLetterGradeF() {
        when(mockQuiz.getTotalQuestions()).thenReturn(Collections.emptyList());
        when(mockQuiz.getScore()).thenReturn(3);
        when(mockQuiz.getLetterGrade()).thenReturn("F");

        quizUI = new QuizUI(mockController);
        quizUI.run();

        assertEquals("F", mockQuiz.getLetterGrade());
    }

    @Test
    void testReadIntHandlesInvalidInput() {
        Question mockQuestion = mock(Question.class);
        when(mockQuestion.getText()).thenReturn("Q?");
        when(mockQuestion.getOptions()).thenReturn(Arrays.asList("A", "B"));

        when(mockQuiz.getTotalQuestions()).thenReturn(Arrays.asList(mockQuestion));
        when(mockQuiz.getScore()).thenReturn(0);

        String input = "hej\n1\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        quizUI = new QuizUI(mockController);
        quizUI.run();

        verify(mockController).answerQuestion(mockQuestion, 1);

    }

    @Test
    void testAskQuestionHandlesInvalidChoice() {
        Question mockQuestion = mock(Question.class);
        when(mockQuestion.getText()).thenReturn("Q?");
        when(mockQuestion.getOptions()).thenReturn(Arrays.asList("A", "B"));

        when(mockQuiz.getTotalQuestions()).thenReturn(Arrays.asList(mockQuestion));
        when(mockQuiz.getScore()).thenReturn(0);

        String input = "5\n1\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        quizUI = new QuizUI(mockController);
        quizUI.run();

        verify(mockController).answerQuestion(mockQuestion, 1);
    }

    @Test
    void testAskQuestionInvalidThenValidInput() {
        Question mockQuestion = mock(Question.class);
        when(mockQuestion.getText()).thenReturn("Q?");
        when(mockQuestion.getOptions()).thenReturn(Arrays.asList("A", "B"));

        when(mockQuiz.getTotalQuestions()).thenReturn(Arrays.asList(mockQuestion));
        when(mockQuiz.getScore()).thenReturn(0);

        String input = "-1\n1\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        quizUI = new QuizUI(mockController);
        quizUI.run();

        verify(mockController).answerQuestion(mockQuestion, 1);
    }
}

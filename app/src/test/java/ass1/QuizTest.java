package ass1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class QuizTest {

    private Quiz createQuizWithQuestions(int numQuestions) {
        Quiz quiz = new Quiz();
        for (int i = 1; i <= numQuestions; i++) {
            quiz.addQuestion(new Question("Q" + i, List.of("A", "B"), 0));
        }
        return quiz;
    }

    private void increaseScoreNTimes(Quiz quiz, int times) {
        for (int i = 0; i < times; i++) {
            quiz.increaseScore();
        }
    }

    @Test
    void shouldAddQuestionToQuiz() {
        // Arrange - förbereda testdata
        Quiz quiz = new Quiz();

        Question question = new Question("What is 2+2?", List.of("3", "4", "5"), 1);

        // Act - utför handlingen
        quiz.addQuestion(question);

        // Assert - verifiera resultatet
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

    @Test
    void nineAndMoreSholdReturnA() {
        Quiz quiz = new Quiz();

        quiz = createQuizWithQuestions(10);
        increaseScoreNTimes(quiz, 9);
        assertEquals("A", quiz.getLetterGrade());
    }

    @Test
    void eightShouldReturnB() {
        Quiz quiz = new Quiz();

        quiz = createQuizWithQuestions(10);
        increaseScoreNTimes(quiz, 8);
        assertEquals("B", quiz.getLetterGrade());
    }

    @Test
    void sevenShouldReturnC() {
        Quiz quiz = new Quiz();

        quiz = createQuizWithQuestions(10);
        increaseScoreNTimes(quiz, 7);
        assertEquals("C", quiz.getLetterGrade());
    }

    @Test
    void fiveShouldReturnD() {
        Quiz quiz = new Quiz();

        quiz = createQuizWithQuestions(10);
        increaseScoreNTimes(quiz, 5);
        assertEquals("D", quiz.getLetterGrade());
    }

    @Test
    void fourShouldReturnE() {
        Quiz quiz = new Quiz();

        quiz = createQuizWithQuestions(10);
        increaseScoreNTimes(quiz, 4);
        assertEquals("E", quiz.getLetterGrade());
    }

    @Test
    void treeAndLessShouldReturnF() {
        Quiz quiz = new Quiz();

        quiz = createQuizWithQuestions(10);
        increaseScoreNTimes(quiz, 3);
        assertEquals("F", quiz.getLetterGrade());
    }

}

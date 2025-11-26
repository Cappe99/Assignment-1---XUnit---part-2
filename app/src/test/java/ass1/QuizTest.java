package ass1;

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
        quiz.addQuestion(new Question("Q1", List.of("A", "B"), 0));
        quiz.addQuestion(new Question("Q2", List.of("A", "B"), 0));

        quiz.increaseScore();
        quiz.increaseScore();

        assertEquals("A", quiz.getLetterGrade());

    }

    @Test
    void eightShouldReturnB() {
        Quiz quiz = new Quiz();

        quiz.addQuestion(new Question("Q1", List.of("A", "B"), 0));
        quiz.addQuestion(new Question("Q2", List.of("A", "B"), 0));
        quiz.addQuestion(new Question("Q3", List.of("A", "B"), 0));
        quiz.addQuestion(new Question("Q4", List.of("A", "B"), 0));
        quiz.addQuestion(new Question("Q5", List.of("A", "B"), 0));
        quiz.addQuestion(new Question("Q6", List.of("A", "B"), 0));
        quiz.addQuestion(new Question("Q7", List.of("A", "B"), 0));
        quiz.addQuestion(new Question("Q8", List.of("A", "B"), 0));
        quiz.addQuestion(new Question("Q9", List.of("A", "B"), 0));
        quiz.addQuestion(new Question("Q10", List.of("A", "B"), 0));

        quiz.increaseScore();
        quiz.increaseScore();
        quiz.increaseScore();
        quiz.increaseScore();
        quiz.increaseScore();
        quiz.increaseScore();
        quiz.increaseScore();
        quiz.increaseScore();

        assertEquals("B", quiz.getLetterGrade());
    }

    @Test
    void sevenAndSixShouldReturnC() {
        Quiz quiz = new Quiz();

        quiz.addQuestion(new Question("Q1", List.of("A", "B"), 0));
        quiz.addQuestion(new Question("Q2", List.of("A", "B"), 0));
        quiz.addQuestion(new Question("Q3", List.of("A", "B"), 0));
        quiz.addQuestion(new Question("Q4", List.of("A", "B"), 0));
        quiz.addQuestion(new Question("Q5", List.of("A", "B"), 0));
        quiz.addQuestion(new Question("Q6", List.of("A", "B"), 0));
        quiz.addQuestion(new Question("Q7", List.of("A", "B"), 0));
        quiz.addQuestion(new Question("Q8", List.of("A", "B"), 0));
        quiz.addQuestion(new Question("Q9", List.of("A", "B"), 0));
        quiz.addQuestion(new Question("Q10", List.of("A", "B"), 0));

        quiz.increaseScore();
        quiz.increaseScore();
        quiz.increaseScore();
        quiz.increaseScore();
        quiz.increaseScore();
        quiz.increaseScore();

        assertEquals("C", quiz.getLetterGrade());
    }

    @Test
    void fiveShouldReturnD() {
        Quiz quiz = new Quiz();

        quiz.addQuestion(new Question("Q1", List.of("A", "B"), 0));
        quiz.addQuestion(new Question("Q2", List.of("A", "B"), 0));
        quiz.addQuestion(new Question("Q3", List.of("A", "B"), 0));
        quiz.addQuestion(new Question("Q4", List.of("A", "B"), 0));
        quiz.addQuestion(new Question("Q5", List.of("A", "B"), 0));
        quiz.addQuestion(new Question("Q6", List.of("A", "B"), 0));
        quiz.addQuestion(new Question("Q7", List.of("A", "B"), 0));
        quiz.addQuestion(new Question("Q8", List.of("A", "B"), 0));
        quiz.addQuestion(new Question("Q9", List.of("A", "B"), 0));
        quiz.addQuestion(new Question("Q10", List.of("A", "B"), 0));

        quiz.increaseScore();
        quiz.increaseScore();
        quiz.increaseScore();
        quiz.increaseScore();
        quiz.increaseScore();

        assertEquals("D", quiz.getLetterGrade());
    }

    @Test
    void fourShouldReturnE() {
        Quiz quiz = new Quiz();

        quiz.addQuestion(new Question("Q1", List.of("A", "B"), 0));
        quiz.addQuestion(new Question("Q2", List.of("A", "B"), 0));
        quiz.addQuestion(new Question("Q3", List.of("A", "B"), 0));
        quiz.addQuestion(new Question("Q4", List.of("A", "B"), 0));
        quiz.addQuestion(new Question("Q5", List.of("A", "B"), 0));
        quiz.addQuestion(new Question("Q6", List.of("A", "B"), 0));
        quiz.addQuestion(new Question("Q7", List.of("A", "B"), 0));
        quiz.addQuestion(new Question("Q8", List.of("A", "B"), 0));
        quiz.addQuestion(new Question("Q9", List.of("A", "B"), 0));
        quiz.addQuestion(new Question("Q10", List.of("A", "B"), 0));

        quiz.increaseScore();
        quiz.increaseScore();
        quiz.increaseScore();
        quiz.increaseScore();

        assertEquals("E", quiz.getLetterGrade());
    }

    @Test
    void treeAndLessShouldReturnF() {
        Quiz quiz = new Quiz();

        quiz.addQuestion(new Question("Q1", List.of("A", "B"), 0));
        quiz.addQuestion(new Question("Q2", List.of("A", "B"), 0));
        quiz.addQuestion(new Question("Q3", List.of("A", "B"), 0));
        quiz.addQuestion(new Question("Q4", List.of("A", "B"), 0));
        quiz.addQuestion(new Question("Q5", List.of("A", "B"), 0));
        quiz.addQuestion(new Question("Q6", List.of("A", "B"), 0));
        quiz.addQuestion(new Question("Q7", List.of("A", "B"), 0));
        quiz.addQuestion(new Question("Q8", List.of("A", "B"), 0));
        quiz.addQuestion(new Question("Q9", List.of("A", "B"), 0));
        quiz.addQuestion(new Question("Q10", List.of("A", "B"), 0));

        quiz.increaseScore();
        quiz.increaseScore();
        quiz.increaseScore();

        assertEquals("F", quiz.getLetterGrade());
    }
}

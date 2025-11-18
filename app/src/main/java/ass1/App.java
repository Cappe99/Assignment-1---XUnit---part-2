/*
Questions klass - Representarar en fråga med svarsalternativ
Quiz klass - Lista med frågor och hålla poäng
Quiz Contrioller - Interagerar med spelaren - systemIn()
ScoreBoeard Klass - show scores 
 */
package ass1;

import java.util.List;

public class App {
    public String getGreeting() {
        return "Hello World!";
    }

    public static void main(String[] args) {

        Quiz quiz = new Quiz();
        quiz.addQuestion(new Question(
                "What is 2 + 2?",
                List.of("3", "4", "5"),
                1));

        QuizController controller = new QuizController(quiz);
        QuizUI ui = new QuizUI(controller);
        ui.run();
    }
}

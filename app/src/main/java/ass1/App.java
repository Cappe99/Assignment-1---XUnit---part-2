/*
Questions klass - Representarar en fråga med svarsalternativ
Quiz klass - Lista med frågor och hålla poäng
Quiz Contrioller - Interagerar med spelaren - systemIn()
ScoreBoeard Klass - show scores 
 */
package ass1;

public class App {
    public static void main(String[] args) {

        Quiz quiz = new Quiz();
        QuizController controller = new QuizController(quiz);
        QuizUI ui = new QuizUI(controller);

        ui.run();
    }
}

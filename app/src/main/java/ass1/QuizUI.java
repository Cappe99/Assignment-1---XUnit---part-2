package ass1;

import java.util.List;
import java.util.Scanner;

public class QuizUI {
    private QuizController controller;
    private Scanner scanner = new Scanner(System.in);

    public QuizUI(QuizController controller) {
        this.controller = controller;
    }

    public void run() {
        for (Question q : controller.getQuiz().getTotalQuestions()) {
            System.out.println(q.getText());

            List<String> opts = q.getOptions();
            for (int i = 0; i < opts.size(); i++) {
                System.out.println((i + 1) + ". " + opts.get(i));
            }

            int input = scanner.nextInt() - 1;

            controller.answerQuestion(q, input);
        }

        System.out.println("Score: " + controller.getQuiz().getScore());
    }
}

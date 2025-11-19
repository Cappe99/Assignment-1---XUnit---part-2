package ass1;

import java.util.Scanner;

public class QuizUI {
    private QuizController controller;
    private Scanner scanner = new Scanner(System.in);

    public QuizUI(QuizController controller) {
        this.controller = controller;
    }

    public void run() {
        controller.loadDefaultQuestions();

        System.out.println("=== Welcome to the Quiz! ===\n");

        for (Question question : controller.getQuiz().getTotalQuestions()) {
            askQuestion(question);
        }

        System.out.println("\n=== Quiz finished! ===");
        System.out.println("Your score: " + controller.getQuiz().getScore()
                + "/" + controller.getQuiz().getTotalQuestions().size());
    }

    private void askQuestion(Question question) {
        System.out.println(question.getText());

        for (int i = 0; i < question.getOptions().size(); i++) {
            System.out.println("  " + i + ": " + question.getOptions().get(i));
        }

        System.out.print("Your answer: ");
        int answer = readInt();

        controller.answerQuestion(question, answer);
        System.out.println();
    }

    private int readInt() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.print("Enter a number: ");
            }
        }
    }
}

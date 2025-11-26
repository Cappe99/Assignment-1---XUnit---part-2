package ass1;

import java.util.Scanner;

public class QuizUI {
    private QuizController controller;
    private Scanner scanner = new Scanner(System.in);

    private static final String WELCOME_MESSAGE = "=== Welcome to the Quiz! ===";
    private static final String FINISHED_MESSAGE = "=== Quiz finished! ===";

    public QuizUI(QuizController controller) {
        this.controller = controller;
    }

    public void run() {
        controller.loadDefaultQuestions();

        System.out.println(WELCOME_MESSAGE + "\n");

        Quiz quiz = controller.getQuiz();

        for (Question question : quiz.getTotalQuestions()) {
            askQuestion(question);
        }

        printFinalScore(quiz);

    }

    private void printFinalScore(Quiz quiz) {
        System.out.println("\n" + FINISHED_MESSAGE);
        System.out.println("Your score: " + quiz.getScore()
                + "/" + quiz.getTotalQuestions().size()
                + " (" + quiz.getLetterGrade() + ")");
    }

    private void askQuestion(Question question) {
        System.out.println(question.getText());

        for (int i = 0; i < question.getOptions().size(); i++) {
            System.out.println("  " + i + ": " + question.getOptions().get(i));
        }

        int answer;

        while (true) {
            System.out.print("Your answer: ");

            answer = readInt();

            if (answer >= 0 && answer < question.getOptions().size()) {
                break;
            }

            System.out.println("Invalid choice. Please enter a number between 0 and "
                    + (question.getOptions().size() - 1) + ".");
        }

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

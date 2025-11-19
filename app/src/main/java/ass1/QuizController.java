package ass1;

import java.util.List;

public class QuizController {
    private Quiz quiz;

    public QuizController(Quiz quiz) {
        this.quiz = quiz;
    }

    public void answerQuestion(Question question, int answerIndex) {
        if (question.isCorrect(answerIndex)) {
            quiz.increaseScore();
        }
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void loadDefaultQuestions() {
        quiz.addQuestion(new Question("What is 2 + 2?",
                List.of("3", "4", "5"),
                1));

        quiz.addQuestion(new Question("What is the capital of Sweden?",
                List.of("Oslo", "Stockholm", "Copenhagen"),
                1));

        quiz.addQuestion(
                new Question("Which planet is known as the Red Planet?",
                        List.of("Earth", "Mars", "Jupiter"),
                        1));

        quiz.addQuestion(new Question(
                "What is the largest ocean?",
                List.of("Atlantic", "Indian", "Pacific"),
                2));

        quiz.addQuestion(new Question(
                "What is the chemical symbol for water?",
                List.of("CO2", "H2O", "O2"),
                1));

        quiz.addQuestion(new Question(
                "How many days are there in a week?",
                List.of("5", "7", "10"),
                1));

        quiz.addQuestion(new Question(
                "What is the fastest land animal?",
                List.of("Cheetah", "Horse", "Lion"),
                0));

        quiz.addQuestion(new Question(
                "Which gas do plants breathe in?",
                List.of("Oxygen", "Carbon Dioxide", "Nitrogen"),
                1));

        quiz.addQuestion(new Question(
                "What is the boiling point of water?",
                List.of("50°C", "100°C", "150°C"),
                1));

        quiz.addQuestion(new Question(
                "Which language is used for Android development?",
                List.of("C#", "Java", "Swift"),
                1));

    }
}

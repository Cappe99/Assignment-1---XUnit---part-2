package ass1;

public class AnswerOption {
    private String text;
    private boolean correctAnswer;

    public AnswerOption(String text, boolean correctAnswer) {
        this.text = text;
        this.correctAnswer = correctAnswer;
    }

    public boolean isCorrect() {
        return correctAnswer;
    }

    public String getText() {
        return text;
    }
}

public class Answer {

    private final boolean isCorrect;
    private final String text;

    public Answer(boolean isCorrect, String text) {
        this.isCorrect = isCorrect;
        this.text = text;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return text;
    }
}

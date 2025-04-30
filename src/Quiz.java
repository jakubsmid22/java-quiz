import java.util.ArrayList;

public class Quiz {

    private final String name;
    private final ArrayList<Question> questions = new ArrayList<>();
    private int correctAnswers = 0;

    public Quiz(String name) {
        this.name = name;
    }

    public int getCorrectAnswers() {
        return correctAnswers;
    }

    public void setCorrectAnswers(int correctAnswers) {
        this.correctAnswers = correctAnswers;
    }

    public ArrayList<Question> getQuestions() {
        return questions;
    }

    public void addQuestion(Question question) {
        this.questions.add(question);
    }

    public String getName() {
        return name;
    }

    public void getFinalMessage() {
        System.out.println("You had " + this.correctAnswers + "/" + this.questions.size() + " answers correct");
    }

    @Override
    public String toString() {
        return "\nWelcome to quiz " + this.name +
                "\nThis quiz has " + this.questions.size() + " questions.\n";
    }
}

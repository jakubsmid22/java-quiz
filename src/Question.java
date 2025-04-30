import java.util.ArrayList;

public class Question {

    private final String text;
    private final ArrayList<Answer> answers = new ArrayList<>();
    private boolean isMultipleAnswer;
    private boolean isOpenAnswer = false;
    private String answer;

    public Question(String text) {
        if (text.charAt(text.length() - 1) != '?') {
            this.text = text + '?';
        } else {
            this.text = text;
        }
    }

    // constructor for open answer
    public Question(String text, String answer) {
        this.isOpenAnswer = true;
        if (text.charAt(text.length() - 1) != '?') {
            this.text = text + '?';
        } else {
            this.text = text;
        }
        this.answer = answer;
    }

    public ArrayList<Answer> getAnswers() {
        return answers;
    }

    public void getUsersAnswer(String answer, Quiz quiz) {
        if (isOpenAnswer) {
            if (answer.equalsIgnoreCase(this.answer)) {
                quiz.setCorrectAnswers(quiz.getCorrectAnswers() + 1);
                System.out.println("Correct!");
            } else {
                System.out.println("Wrong!");
            }

        } else if (isMultipleAnswer) {
            boolean isCorrect = true;
            String[] userAnswers = answer.split(",");
            for (String usersAnser : userAnswers) {
                if (!this.answers.get(Integer.parseInt(usersAnser)).isCorrect()) {
                    isCorrect = false;
                    break;
                }
            }

            if (isCorrect) {
                quiz.setCorrectAnswers(quiz.getCorrectAnswers() + 1);
                System.out.println("Correct!");
            } else {
                System.out.println("Wrong!");
            }

        } else {
            if (answers.get(Integer.parseInt(answer)).isCorrect()) {
                quiz.setCorrectAnswers(quiz.getCorrectAnswers() + 1);
                System.out.println("Correct!");
            } else {
                System.out.println("Wrong!");
            }
        }
    }


    public void addAnswer(Answer answer) {
        answers.add(answer);
        int correctAnswerCount = 0;
        for (Answer oneAnswer : this.answers) {
            if (oneAnswer.isCorrect()) correctAnswerCount++;
        }
        if (correctAnswerCount > 1) this.isMultipleAnswer = true;
    }

    @Override
    public String toString() {
        return this.text + " (Question with " + (isOpenAnswer ? "open answer)" : (isMultipleAnswer ? "multiple answers, e.g 0,1 or 1,2)" : "single answer, e.g 0 or 1)"));
    }
}

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {


        boolean isRunning = true;

        while (isRunning) {

            Quiz quiz = createQuiz();

            if (quiz != null) {
                System.out.println(quiz);

                int questionIndex = 1;
                int answerIndex = 0;
                for (Question question : quiz.getQuestions()) {
                    System.out.println(questionIndex + " - " + question.toString());
                    for (Answer answer : question.getAnswers()) {
                        System.out.println(answerIndex + " - " + answer.toString());
                        answerIndex++;
                    }
                    answerIndex = 0;
                    System.out.print("Your answer: ");
                    try {
                        question.getUsersAnswer(scanner.next(), quiz);
                    } catch (Exception e) {
                        System.out.println("Wrong input!");
                    }
                    questionIndex++;
                }

                quiz.getFinalMessage();

            }

            System.out.println("Press q if you want to quit, or anything else if you want to continue.");

            String choice = scanner.next();

            if (choice.equals("q")) {
                isRunning = false;
            }

        }


        scanner.close();
    }

    public static Quiz createQuiz() {

        ArrayList<Quiz> quizes = new ArrayList<>();

        Quiz mathQuiz = new Quiz("Math Quiz");
        Question question1 = new Question("What is 12 + 45?");
        Answer answer1 = new Answer(false, "51");
        Answer answer2 = new Answer(true, "57");
        Answer answer3 = new Answer(false, "60");
        Answer answer4 = new Answer(false, "58");
        question1.addAnswer(answer1);
        question1.addAnswer(answer2);
        question1.addAnswer(answer3);
        question1.addAnswer(answer4);
        mathQuiz.addQuestion(question1);

        Question question2 = new Question("What is 8 * 7?");
        Answer answer5 = new Answer(false, "54");
        Answer answer6 = new Answer(true, "56");
        Answer answer7 = new Answer(false, "64");
        Answer answer8 = new Answer(false, "72");
        question2.addAnswer(answer5);
        question2.addAnswer(answer6);
        question2.addAnswer(answer7);
        question2.addAnswer(answer8);
        mathQuiz.addQuestion(question2);

        Question question3 = new Question("Which of these equals -5");
        Answer answer9 = new Answer(true, "(-10 + 5)");
        Answer answer10 = new Answer(false, "(-5 - 5)");
        Answer answer11 = new Answer(true, "(5 - 10)");
        Answer answer12 = new Answer(false, "(10 - 5)");
        question3.addAnswer(answer9);
        question3.addAnswer(answer10);
        question3.addAnswer(answer11);
        question3.addAnswer(answer12);
        mathQuiz.addQuestion(question3);

        Quiz footballQuiz = new Quiz("Football Quiz");

        Question question4 = new Question("What are the colours of Slavia Prague?");
        Answer answer13 = new Answer(true, "Red & White");
        Answer answer14 = new Answer(false, "Red & Black");
        Answer answer15 = new Answer(false, "Red & Blue");
        Answer answer16 = new Answer(false, "Red & Orange");
        question4.addAnswer(answer13);
        question4.addAnswer(answer14);
        question4.addAnswer(answer15);
        question4.addAnswer(answer16);
        footballQuiz.addQuestion(question4);

        Question question5 = new Question("Who was the first WC winner?", "Uruguay");
        footballQuiz.addQuestion(question5);

        Question question6 = new Question("Which of the following players have won the Ballon d'Or at least once?");
        Answer answer18 = new Answer(true, "Cristiano Ronaldo");
        Answer answer19 = new Answer(true, "Lionel Messi");
        Answer answer20 = new Answer(false, "Robert Lewandowski");
        Answer answer21 = new Answer(true, "Kaka");
        question6.addAnswer(answer18);
        question6.addAnswer(answer19);
        question6.addAnswer(answer20);
        question6.addAnswer(answer21);
        footballQuiz.addQuestion(question6);

        quizes.add(mathQuiz);
        quizes.add(footballQuiz);

        showAvaibleQuizes(quizes);

        System.out.print("Your choice (0 - " + (quizes.size() - 1) + "): ");

        try {
            int quizIndex = scanner.nextInt();
            return quizes.get(quizIndex);
        } catch (Exception e) {
            System.out.println("Quiz number does not exist!");
            scanner.nextLine();
            return null;
        }
    }

    public static void showAvaibleQuizes(ArrayList<Quiz> quizzes) {
        System.out.println("\nWhat quiz you want to chose?");
        int i = 0;
        for (Quiz quiz : quizzes) {
            System.out.println(i + " - " + quiz.getName());
            i++;
        }
    }


}
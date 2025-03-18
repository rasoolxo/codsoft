import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

class QuizApplication {
    private static final int QUESTION_TIME_LIMIT = 15;
    private static int score = 0;
    private static int currentQuestionIndex = 0;
    private static boolean answered = false;

    private static String[] questions = {
        "1. What is the capital of India?",
        "2. Which programming language is used for Android development?",
        "3. What is the chemical symbol for water?"
    };

    private static String[][] options = {
        {"a. Mumbai", "b. Delhi", "c. Kolkata", "d. Chennai"},
        {"a. Python", "b. Java", "c. C++", "d. Swift"},
        {"a. O2", "b. H2O", "c. CO2", "d. NaCl"}
    };

    private static char[] answers = {'b', 'b', 'b'};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Timer timer = new Timer();

        System.out.println("Welcome to the Quiz Application!");
        System.out.println("Let's begin!\n");

        for (currentQuestionIndex = 0; currentQuestionIndex < questions.length; currentQuestionIndex++) {
            answered = false;

            System.out.println(questions[currentQuestionIndex]);
            for (String option : options[currentQuestionIndex]) {
                System.out.println(option);
            }

            TimerTask task = new TimerTask() {
                @Override
                public void run() {
                    if (!answered) {
                        System.out.println("\nTime's up! Moving to the next question.");
                        currentQuestionIndex++;
                        if (currentQuestionIndex < questions.length) {
                            System.out.println("\nNext Question:\n");
                        }
                    }
                    this.cancel();
                }
            };
            timer.schedule(task, QUESTION_TIME_LIMIT * 1000);

            System.out.print("Enter your answer (a/b/c/d): ");
            char userAnswer = scanner.next().toLowerCase().charAt(0);

            if (!answered) {
                if (userAnswer == answers[currentQuestionIndex]) {
                    System.out.println("Correct!");
                    score++;
                } else {
                    System.out.println("Wrong! The correct answer is " + answers[currentQuestionIndex] + ".");
                }
                answered = true;
            }
        }

        System.out.println("\nQuiz Completed!");
        System.out.println("Your final score is: " + score + " out of " + questions.length);
        scanner.close();
        timer.cancel();
    }
}


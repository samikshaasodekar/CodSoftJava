/*
TASK 4
1.Quiz Questions and Options: Store quiz questions along with multiple-choice options and correct
answers.
2.Timer: Implement a timer for each question to limit the time to answer.
3.Question Display: Present one question at a time with multiple-choice options.
4.Answer Submission: Allow users to select an option and submit their answer within the given
time.
5.Score Calculation: Keep track of the user's score based on correct answers.
Result Screen: Display the final score and a summary of correct/incorrect answers.
*/

package task4;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Quiz {

    private static Scanner scanner = new Scanner(System.in);
    private static int score = 0;

    public static void main(String[] args) {
        QuizQuestion[] questions = {
            new QuizQuestion("What is the capital of France?", new String[]{"1. Berlin", "2. Madrid", "3. Paris", "4. Rome"}, 3),
            new QuizQuestion("Which of the following is a not a fruit?", new String[]{"1. Banana", "2. Ruby", "2. Cherry", "4. Apple"}, 2)
        };

        for (QuizQuestion question : questions) {
            askQuestion(question);
        }
        
        System.out.println();

        System.out.println("Quiz completed!");
        System.out.println("Your final score is: " + score);
    }

    private static void askQuestion(QuizQuestion question) {
        System.out.println(question.getQuestion());
        String[] options = question.getOptions();
        for (int i = 0; i < options.length; i++) {
            System.out.println(options[i]);
        }

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
            	System.out.println();
                System.out.println("Time is up!");
                System.out.println("The correct answer was: " + question.getCorrectAnswer());
                timer.cancel();
                System.exit(0);
            }
        }, 10000); 
        
        System.out.println();

        System.out.print("Enter your answer (1-4): ");
        int answer = scanner.nextInt();
        timer.cancel();
        
        System.out.println();

        if (answer == question.getCorrectAnswer()) {
            System.out.println("Correct!");
            score++;
        } else {
            System.out.println("Incorrect. The correct answer is: " + question.getCorrectAnswer());
        }
    }
}

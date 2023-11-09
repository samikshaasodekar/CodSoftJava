/* 
TASK 1
1. Generate a random number within a specified range, such as 1 to 100.
2. Prompt the user to enter their guess for the generated number.
3. Compare the user's guess with the generated number and provide feedback on whether the guess
   is correct, too high, or too low.
4. Repeat steps 2 and 3 until the user guesses the correct number.
*You can incorporate additional details as follows:
5. Limit the number of attempts the user has to guess the number.
6. Add the option for multiple rounds, allowing the user to play again.
7. Display the user's score, which can be based on the number of attempts taken or rounds won.
*/

import java.util.Random;
import java.util.Scanner;

public class NumberGame {

    public static void main(String[] args) throws InterruptedException {
        Random r = new Random();
        int targetNumber = r.nextInt(100) + 1;
       
        
        Scanner sc = new Scanner(System.in); 
 
        while (true) {
            System.out.print("Enter your guess number from 1 to 100: ");
            int userInput = sc.nextInt();
            
            if (userInput == targetNumber) {
                System.out.println("It is correct number.");
                break;
            } else if (userInput > targetNumber) {
                System.out.println("The given number is too high.");
            } else {
                System.out.println("The given number is too low.");
            }
            //Thread.sleep(1050);
            //System.out.println("The generated random number is: " + targetNumber);  
            System.out.println();
            
        }        
        sc.close();    
    }
}


/*
Varun Sureka
10/23/19
Java Period 2
*/
import java.util.Random;
import java.util.Scanner;
public class stuff
{
    public static void main(String[] args)
    {
        Random random = new Random();
        Scanner scan = new Scanner(System.in);
        System.out.println("I'm thinking of a number between 1 and 20 ");

        int randomNum = random.nextInt(10)+1;

        for (int x = 0; x<3; x++)
        {
            System.out.println("Can you guess what number I'm thinking of?");
            int guess = scan.nextInt();

            if (guess != randomNum)
            {
                System.out.println("That's not the right answer!");
            }
            else if (guess == randomNum)
            {
                System.out.println("That's the right answer!");
                break;
            }
        }
        System.out.print("The correct number is " + randomNum);
    }
}

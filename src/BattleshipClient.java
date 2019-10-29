/*
Varun Sureka
10/22/19
Java Period 2
*/
/*
You must create a project of your own.

You must bring a outline for my approval (10 points)

Flow chart/ Design (15 points)

Document your program (10 Points)
- Comment and add descriptions of your procedures

Use Methods/object classes (25 points)
- If, for, while, methods (mutator, accessor, with or without parameters)

Highlight your Algorithm (10 points)

Produces the right output(40 points)
 */
import java.util.Scanner;
import java.lang.Thread;

public class BattleshipClient
{
    public static void main(String[] args) throws InterruptedException
    {
        Battleship battleship = new Battleship();
        Scanner scan = new Scanner(System.in);
        battleship.clearField();
        battleship.RandomShips();
      System.out.println("Where do you want to shoot?");
      String shoot = scan.next();
      battleship.UserInput(shoot);

    }
}

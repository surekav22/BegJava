/*
Varun Sureka
10/22/19
Java Period 2
*/
/**
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

public class BattleshipClient
{
    public static void main(String[] args) throws InterruptedException
    {
        Battleship battleship = new Battleship();
        Scanner scan = new Scanner(System.in);


        battleship.clearField(); //clears the arrays
        battleship.RandomShips(); //randomizes the ships and places them on the enemy array
//        battleship.DrawEnemyField(); //draws enemy ships
        battleship.DrawUserField(); //draws the field that you shoot on

//        list to print your ships here
        System.out.println("Where do you want to place your carrier (5 long)? Enter a start point (enter the column then the row. Example: a1 or f8)");
        String CarrierStart = scan.next();
        System.out.println("Enter a direction (\u001B[31m1\u001B[0m is vertical and goes up. \u001B[31m2\u001B[0m is horizontal and goes to the right)");
        int CarrierDirection = scan.nextInt();
        battleship.UserCarrier(CarrierStart, CarrierDirection);

        // these do-while loops test to see if you have doubled up on your ships and tells you that you are cheating
        //battleship
        String BattleshipStart = "";
        int BattleshipDirection = 0;
        do
        {
            System.out.println("Where do you want to place your battleship (4 long)? Enter a start point (enter the column then the row. Example: a1 or f8)");
            BattleshipStart = scan.next();
            System.out.println("Enter a direction (\u001B[31m1\u001B[0m is vertical and goes up. \u001B[31m2\u001B[0m is horizontal and goes to the right)"); //the escape sequences are for color
            BattleshipDirection = scan.nextInt();
        } while (!battleship.UserBattleship(BattleshipStart, BattleshipDirection));
        battleship.DrawUserField(); //these print out the field after you place the ship so you cna see how and where it placed

        //submarine
        String SubmarineStart = "";
        int SubmarineDirection = 0;
        do
        {
            System.out.println("Where do you want to place your submarine (3 long)? Enter a start point (enter the column then the row. Example: a1 or f8)");
            SubmarineStart = scan.next();
            System.out.println("Enter a direction (\u001B[31m1\u001B[0m is vertical and goes up. \u001B[31m2\u001B[0m is horizontal and goes to the right)");
            SubmarineDirection = scan.nextInt();
        } while (!battleship.UserSubmarine(SubmarineStart, SubmarineDirection));
        battleship.DrawUserField();

        //cruiser
        String CruiserStart = "";
        int CruiserDirection = 0;
        do
        {
            System.out.println("Where do you want to place your cruiser (3 long)? Enter a start point (enter the column then the row. Example: a1 or f8)");
            CruiserStart = scan.next();
            System.out.println("Enter a direction (\u001B[31m1\u001B[0m is vertical and goes up. \u001B[31m2\u001B[0m is horizontal and goes to the right)");
            CruiserDirection = scan.nextInt();
        } while(!battleship.UserCruiser(CruiserStart, CruiserDirection));
        battleship.DrawUserField();

        //destroyer
        String DestroyerStart = "";
        int DestroyerDirection = 0;
        do
        {
            System.out.println("Where do you want to place your destroyer (2 long)? Enter a start point (enter the column then the row. Example: a1 or f8)");
            DestroyerStart = scan.next();
            System.out.println("Enter a direction (\u001B[31m1\u001B[0m is vertical and goes up. \u001B[31m2\u001B[0m is horizontal and goes to the right)");
            DestroyerDirection = scan.nextInt();
        } while (!battleship.UserDestroyer(DestroyerStart, DestroyerDirection));
        battleship.DrawUserField();

        Thread.sleep(1000); //this is to provide breaks in the code so that it is not so rushed
        battleship.DrawShootingRange();

        // these test to see if you have sunk their ships or if the Ai has sunk yours
        boolean EnemyShipsRemaining = true;
        boolean MyShipsRemaining = true;

        while (EnemyShipsRemaining && MyShipsRemaining)
        {
            int EnemyShipHitCounter = 0;
            int MyShipHitCounter = 0;

            System.out.println("Where do you want to shoot?"); //asks you to shoot somewhere
            String shoot = scan.next();
            battleship.UserInput(shoot);

            Thread.sleep(500); //delay for shooting so that it is not as rushed
            System.out.print("AI is shooting ");
            System.out.print(".");
            Thread.sleep(1000);
            System.out.print(".");
            Thread.sleep(1000);
            System.out.print(".");
            Thread.sleep(1000);
            System.out.print('\n');

            battleship.AIShoots();

            for (int i =0; i<100; i ++) //this scans the board and determines if you win or if the ai wins
            {
                if (battleship.ShotBoard[i] == 'X')
                {
                    EnemyShipHitCounter++;
                    if (EnemyShipHitCounter == 17)
                    {
                        EnemyShipsRemaining = false;
                        System.out.println("You have won!");
                    }
                }
                if (battleship.MyBoard[i] == 'X')
                {
                    MyShipHitCounter++;
                    if (MyShipHitCounter == 17)
                    {
                        MyShipsRemaining = false;
                        System.out.println("You have lost!");
                    }
                }
            }
        }
    }
}

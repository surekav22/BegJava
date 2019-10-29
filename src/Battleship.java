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

//        System.out.print("...");
//        System.out.print('\n');
//        System.out.print(". .");
//        System.out.print('\n');
//        System.out.print("...");


/*
each of the spaces is a spot for either an x or an o
//make it so that it randomizes where the battle ships are and then has you guess what they are.
 */
import sun.lwawt.macosx.CSystemTray;

import java.util.Random;
public class Battleship
{
    private static Random rand = new Random();
    private static char[] board = new char[100]; //array with 100 values

    public static void clearField() //this clears the board.
    {
        for(int i =0; i<100;i++)
        {
            board[i] = ' ';
        }
    }

    public static void DrawField() //the field is a 10x10 and is A-J on the top and 1-10 on the left
    {
        System.out.println("  .a.b.c.d.e.f.g.h.i.j.");
        for (int i =0; i<100; i++)
        {
            if (i%10==0)
            {
                if (i!=0)
                {
                    System.out.print('\n');
                }
                for (int dot = 0; dot<23; dot++)
                {
                    System.out.print('-');
                }
                System.out.print('\n');
                if (((i/10)+1)==10)
                {
                    System.out.print((i/10)+1 + "|");
                }
                else
                {
                    System.out.print((i/10)+1 + " |");
                }
            }
            char print = board[i];
                System.out.print(print);
                System.out.print("|");
        }
        System.out.print('\n');
        for (int dot = 0; dot<23; dot++)
        {
            System.out.print('-');
        }
        System.out.print('\n');
    }

    private static int xCoord(char value)
    {
        switch (value)
        {
            case 'a':
                return 1;
            case 'b':
                return 2;
            case 'c':
                return 3;
            case 'd':
                return 4;
            case 'e':
                return 5;
            case 'f':
                return 6;
            case 'g':
                return 7;
            case 'h':
                return 8;
            case 'i':
                return 9;
            case 'j':
                return 10;
            default:
                return 11;
        }
    }

    public static void RandomShips()
    {
        int submarine = rand.nextInt(100)+1;
        int battleship = rand.nextInt(100)+1;
        SubSpots(submarine);
        PlaceBattleship(battleship);
        DrawField();
    }

    public static void SubSpots(int submarine)
    {
        int direction = rand.nextInt(2) + 1; //now it can go in a random direction
        submarine = submarine - 11; //this is the submarine spot in the array. the array is off by 11

        if (submarine < 11)
        {
            submarine+= 11;
        }
//        submarine = 35;
//        direction = 4;

        board[submarine - 1] = 's';

        System.out.println(submarine);
        System.out.println(direction);

        switch (direction)
        {
            case 1: //goes up
                if (submarine > 20) //in rows 3-10
                {
                    board[submarine - 11] = 's';
                    board[submarine - 21] = 's';
                }
                else if (submarine <= 20 && submarine > 10) //in row 2
                {
                    board[submarine - 11] = 's';
                    board[submarine + 9] = 's';
                }
                else if (submarine <= 10) //in row 1
                {
                    board[submarine + 9] = 's';
                    board[submarine + 19] = 's';
                }
                break;
            case 2: //goes right
                if (submarine % 10 != 0)
                {
                    board[submarine - 1] = 's';
                    board[submarine] = 's';
                    if ((submarine + 1) % 10 != 0)
                    {
                        board[submarine + 1] = 's';
                    }
                    else
                    {
                        board[submarine - 2] = 's';
                    }
                }
                else
                {
                    board[submarine - 2] = 's';
                    board[submarine - 3] = 's';
                }
                break;
        }
    }

    public static void PlaceBattleship(int battleship)
    {
        int direction = rand.nextInt(2)+1;

        if (battleship < 11)
        {
            battleship =+ 11;
        }
//        battleship = 35;
        direction = 1;

        System.out.println(battleship);
        System.out.println(direction);

        switch (direction)
        {
            case 1: //goes up

                if (battleship > 30) //in rows 3-10
                {
                    while (board[battleship - 1] != ' ' || board[battleship - 15] != ' ' ||  board[battleship - 25] != ' ' || board[battleship-35] != ' ')
                    {
                        battleship++;
                    }
                    board[battleship - 1] = 'b';
                    board[battleship - 11] = 'b';
                    board[battleship - 21] = 'b';
                    board[battleship - 31] = 'b';
                }
                else if (battleship <= 30 && battleship > 10) //in row 2
                {
                    while (board[battleship - 1] != ' ' || board[battleship - 11] != ' ' ||  board[battleship +9] != ' ' || board[battleship+19] != ' ')
                    {
                        battleship++;
                    }
                    board[battleship - 1] = 'b';
                    board[battleship - 11] = 'b';
                    board[battleship + 9] = 'b';
                    board[battleship + 19] = 'b';
                }
                else if (battleship <= 10) //in row 1
                {
                    while (board[battleship - 1] != ' ' || board[battleship +9] != ' ' ||  board[battleship +19] != ' ' || board[battleship+29] == ' ')
                    {
                        battleship++;
                    }
                    board[battleship - 1] = 'b';
                    board[battleship + 9] = 'b';
                    board[battleship + 19] = 'b';
                    board[battleship + 29] = 'b';
                }
                break;
//            case 2: //goes right
//                if (submarine % 10 != 0)
//                {
//                    board[submarine - 1] = 's';
//                    board[submarine] = 's';
//                    if ((submarine + 1) % 10 != 0)
//                    {
//                        board[submarine + 1] = 's';
//                    }
//                    else
//                    {
//                        board[submarine - 2] = 's';
//                    }
//                }
//                else
//                {
//                    board[submarine - 2] = 's';
//                    board[submarine - 3] = 's';
//                }
//                break;
        }
    }

    public static void UserInput(String Shoot)//takes 2 values, one for the start and one for the end. this way I can place the ships.
    // Also should have a if statement to check if it is diagonal
    {
        //make this thing just to shoot now. no more placing ships

        int x1 = xCoord(Shoot.charAt(0));
        int y1 = Integer.parseInt(Shoot.substring(1));
        shoot(x1, y1,'X');


    }
    private static void shoot( int x1, int y1, char b)
    {
        int position = ((y1-1) * 10) + (x1 - 1); //this is the spot that you shot

        board[position] = b;
        DrawField();
    }
}
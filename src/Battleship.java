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



/*
each of the spaces is a spot for either an x or an o
//make it so that it randomizes where the battle ships are and then has you guess what they are.
 */
import java.util.Random;

class Battleship
{
    private static final String RESET = "\u001B[0m"; //colors for the shooting and all
    private static final String RED = "\u001B[31m";
    private static final String BLUE = "\u001B[34m";

    private static Random rand = new Random();

    private static char[] board = new char[100]; //enemy array. will not be displayed
    public static char[] MyBoard = new char[100]; //board for your ships. will be displayed
    public static char[] ShotBoard = new char[100]; //board for shooting. will be displayed

    private static int submarine = rand.nextInt(100)+1; //picks a random slot on the board for the ships. each ship needs to start at a different point so there are 5 variables
    private static int battleship = rand.nextInt(100)+1;
    private static int carrier = rand.nextInt(100)+1;
    private static int cruiser = rand.nextInt(100)+1;
    private static int destroyer = rand.nextInt(100)+1;

    private static int carrierDirection = rand.nextInt(2)+1; //now it can go in a random direction. 1 is up and vertical, 2 is right and horizontal.
                                                                    // i did 5 different variables because i need as much verity in the direction of the ships as possible
    private static int battleshipDirection = rand.nextInt(2)+1;
    private static int submarineDirection = rand.nextInt(2) + 1;
    private static int cruiserDirection = rand.nextInt(2) + 1;
    private static int destroyerDirection = rand.nextInt(2) + 1;

    private static int CarrierSunk = 0; //these are for testing if you sunk the AI's ship or if the AI sunk your ship. they are declared externally because
                                        // i need them to count and don't want them to reset every time the method is called.
    private static int BattleshipSunk = 0;
    private static int CruiserSunk = 0;
    private static int SubmarineSunk = 0;
    private static int DestroyerSunk = 0;

    private static int UserCarrierSunk = 0;
    private static int UserBattleshipSunk = 0;
    private static int UserCruiserSunk = 0;
    private static int UserSubmarineSunk = 0;
    private static int UserDestroyerSunk = 0;

    public static void clearField() //this clears the board.
    {
        for(int i =0; i<100;i++)
        {
            board[i] = ' ';
            MyBoard[i] = ' ';
            ShotBoard[i] = ' ';
        }
    }

    public static void DrawEnemyField() //this board is for the enemy ships. Is only drawn for testing purposes
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
                if (((i/10)+1)==10) //for the numbers
                {
                    System.out.print((i/10)+1 + "|");
                }
                else
                {
                    System.out.print((i/10)+1 + " |");
                }
            }
            char print = board[i]; //prints the array vales for the boards
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

    public static void DrawUserField() //this board is for the User's Ships. It is displayed every time that you place your ships
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
                if (((i/10)+1)==10) //for the numbers
                {
                    System.out.print((i/10)+1 + "|");
                }
                else
                {
                    System.out.print((i/10)+1 + " |");
                }
            }
            if (MyBoard[i] == 'O') //this is for colors
            {
                System.out.print(BLUE);
            }
            if (MyBoard[i] == 'X')
            {
                System.out.print(RED);
            }
            char print = MyBoard[i]; //prints the array vales for the boards
            System.out.print(print);
            if (MyBoard[i] == 'O' || MyBoard[i] == 'X')
            {
                System.out.print(RESET);
            }
            System.out.print("|");
        }
        System.out.print('\n');
        for (int dot = 0; dot<23; dot++)
        {
            System.out.print('-');
        }
        System.out.print('\n');
    }

    public static void DrawShootingRange() //this board is for where you shoot. It is displayed every time you shoot
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
                if (((i/10)+1)==10) //for the numbers
                {
                    System.out.print((i/10)+1 + "|");
                }
                else
                {
                    System.out.print((i/10)+1 + " |");
                }
            }
            if (ShotBoard[i] == 'O') //this is for colors
            {
                System.out.print(BLUE);
            }
            if (ShotBoard[i] == 'X')
            {
                System.out.print(RED);
            }
            char print = ShotBoard[i]; //prints the array vales for the boards
            System.out.print(print);
            if (ShotBoard[i] == 'O' || ShotBoard[i] == 'X')
            {
                System.out.print(RESET);
            }
            System.out.print("|");
        }
        System.out.print('\n');
        for (int dot = 0; dot<23; dot++)
        {
            System.out.print('-');
        }
        System.out.print('\n');
    }

    public static void RandomShips() //The 5 ships are: Carrier (5), Battleship (4), Cruiser (3), Submarine (3), and Destroyer (2). this is the method used to randomize them.
                                     //I did it this way because it is easier to call in the main class and is more concise. it takes the random values generated above and
                                     // passes them to the specific classes below.
    {
        PlaceCarrier(carrier);
        PlaceBattleship(battleship);
        PlaceSubmarine(submarine);
        PlaceCruiser(cruiser);
        PlaceDestroyer(destroyer);
    }


    private static void PlaceCarrier(int carrier) //this takes the input of the random number and prints in the board based on what number it it.
    {
//        carrier = 34;
//        carrierDirection = 1;

        if (carrier < 5)
        {
            carrier =+ 5;
        }
        else if (carrier > 94)
        {
            submarine -=5;
        }


//        System.out.println(carrier);
//        System.out.println(carrierDirection);

        switch (carrierDirection) //this takes the direction of the ship and determines how the ship prints based on the random direction
        {
            case 1: //goes up

                if (carrier > 41) //these test to see where on the board the carrier is placed. it is necessary because It changes how the ship should print.
                {
                    while (board[carrier - 1] != ' ' || board[carrier - 11] != ' ' ||  board[carrier - 21] != ' ' || board[carrier-31] != ' ' || board[carrier-41] != ' ')
                    {
                        carrier++;
                    } //this while loop tests to see if the spot that the carrier prints is clear
                    board[carrier - 1] = 'C';
                    board[carrier - 11] = 'C';
                    board[carrier - 21] = 'C';
                    board[carrier - 31] = 'C';
                    board[carrier - 41] = 'C';
                }
                else if (carrier <= 41 && carrier > 10)
                {
                    while (board[carrier - 1] != ' ' || board[carrier - 11] != ' ' ||  board[carrier + 9] != ' ' || board[carrier + 19] != ' ' || board[carrier + 29] != ' ')
                    {
                        carrier++;
                    }
                    board[carrier - 1] = 'C';
                    board[carrier - 11] = 'C';
                    board[carrier + 9] = 'C';
                    board[carrier + 19] = 'C';
                    board[carrier + 29] = 'C';
                }
                else if (carrier <= 10)
                {
                    while (board[carrier - 1] != ' ' || board[carrier + 9] != ' ' ||  board[carrier + 19] != ' ' || board[carrier + 29] != ' ' || board[carrier + 39] != ' ')
                    {
                        carrier++;
                    }
                    board[carrier - 1] = 'C';
                    board[carrier + 9] = 'C';
                    board[carrier + 19] = 'C';
                    board[carrier + 29] = 'C';
                    board[carrier + 39] = 'C';
                }
                break;
            case 2: //goes right
                int x =0;
                if (carrier % 10 != 0)
                {
                    while  (board[carrier - 1] != ' ' || board[carrier] != ' ' || board[carrier + 1] != ' ' || board[carrier - 2] != ' '
                            || board[carrier + 2] != ' ' || board[carrier + 3] != ' ' || board[carrier - 3] != ' ' || board[carrier - 4] != ' ')
                    {
                        carrier+=10;
                        if (carrier >= 90)
                        {
                            carrier -=89;
                        }
                        x++;
                        if (x>=10)
                        {
                            carrier++;
                        }
                    }
                    board[carrier - 1] = 'C';
                    board[carrier] = 'C';
                    if ((carrier + 1) % 10 != 0)
                    {
                        board[carrier + 1] = 'C';
                        if ((carrier + 2)%10 !=0)
                        {
                            board[carrier+2] = 'C';
                            if ((carrier + 3)%10 !=0)
                            {
                                board[carrier+3] = 'C';
                            }
                            else
                            {
                                board[carrier-2] = 'C';
                            }
                        }
                        else
                        {
                            board[carrier - 2] = 'C';
                            board[carrier - 3] = 'C';
                        }
                    }
                    else
                    {
                        board[carrier - 2] = 'C';
                        board[carrier - 3] = 'C';
                        board[carrier - 4] = 'C';
                    }
                }
                else //this else statement is if carrier%10 = 0. (if carrier = 10,20,30,40, etc.) it just prints the ship backwards.
                {
                    while (board[carrier - 1] != ' ' || board[carrier - 2] != ' ' || board[carrier -3] != ' ' || board[carrier-4] != ' ' || board[carrier - 5] != ' ')
                    {
                        carrier+=10;
                        if (carrier >= 90)
                        {
                            carrier -=89;
                        }
                        x++;
                        if (x>=10)
                        {
                            carrier++;
                        }
                    }
                    board[carrier - 1] = 'C';
                    board[carrier - 2] = 'C';
                    board[carrier - 3] = 'C';
                    board[carrier - 4] = 'C';
                    board[carrier - 5] = 'C';
                }
                break;
        }
    }



    private static void PlaceBattleship(int battleship) //this method is the same as the carrier method except it prints only 4 spots and prints 'b' instead of 'C' for the battleship
    {
//        battleship = 8;
//        battleshipDirection = 1;

        if (battleship < 4)
        {
            battleship =+ 4;
        }
        else if (battleship > 95)
        {
            battleship -=4;
        }

//        System.out.println(battleship);
//        System.out.println(battleshipDirection);

        switch (battleshipDirection)
        {
            case 1: //goes up

                int g = 0;
                if (battleship > 30)
                {
                    System.out.println("hi1");
                    while (board[battleship - 1] != ' ' || board[battleship - 11] != ' ' ||  board[battleship - 21] != ' ' || board[battleship-31] != ' ')
                    {
                        battleship++;
                    }
                    board[battleship - 1] = 'b';
                    board[battleship - 11] = 'b';
                    board[battleship - 21] = 'b';
                    board[battleship - 31] = 'b';
                }
                else if (battleship <= 30 && battleship > 10)
                {
                    System.out.println("hi2");
                    while (board[battleship - 1] != ' ' || board[battleship - 11] != ' ' ||  board[battleship +9] != ' ' || board[battleship+19] != ' ')
                    {
                        battleship++;
                    }
                    board[battleship - 1] = 'b';
                    board[battleship - 11] = 'b';
                    board[battleship + 9] = 'b';
                    board[battleship + 19] = 'b';
                }
                else if (battleship <= 10)
                {
                    System.out.println("hi3");
                    while (board[battleship - 1] == 'C' || board[battleship +9] == 'C' ||  board[battleship +19] == 'C' || board[battleship+29] == 'C')
                    {
                        g++;
                        battleship++;
                        System.out.println(g);
                    }
                    board[battleship - 1] = 'b';
                    board[battleship + 9] = 'b';
                    board[battleship + 19] = 'b';
                    board[battleship + 29] = 'b';
                }
                break;
            case 2: //goes right
                int x =0;
                if (battleship % 10 != 0)
                {
                    while (board[battleship] != ' ' || board[battleship - 1] != ' ' || board[battleship + 1] != ' ' ||  board[battleship + 2] != ' ' || board[battleship - 2] != ' ')
                    {
                        battleship+=11;
                        if (battleship >= 90)
                        {
                            battleship -=89;
                        }
                        x++;
                        if (x>=10)
                        {
                            battleship++;
                        }
                    }
                    board[battleship - 1] = 'b';
                    board[battleship] = 'b';
                    if ((battleship + 1) % 10 != 0)
                    {
                        board[battleship + 1] = 'b';
                        if ((battleship + 2)%10 !=0)
                        {
                            board[battleship+2] = 'b';
                        }
                        else
                        {
                            board[battleship - 2] = 'b';
                        }
                    }
                    else
                    {
                        board[battleship - 2] = 'b';
                    }
                }
                else
                {
                    while (board[battleship - 1] != ' ' || board[battleship - 2] != ' ' || board[battleship -3] != ' ' || board[battleship-4] != ' ' )
                    {
                        battleship+=10;
                        if (battleship >= 90)
                        {
                            battleship -=89;
                        }
                        x++;
                        if (x>=10)
                        {
                            battleship++;
                        }
                    }
                    board[battleship - 1] = 'b';
                    board[battleship - 2] = 'b';
                    board[battleship - 3] = 'b';
                    board[battleship - 4] = 'b';
                }
                break;
        }
    }

    private static void PlaceSubmarine(int submarine) //this method is the same as the carrier method except it prints only 3 spots and prints 's' instead of 'C' for the submarine
    {
//        submarine = 37;
//        direction = 4;

        if (submarine < 3)
        {
            submarine+= 3;
        }
        else if (submarine > 96)
        {
            submarine -=3;
        }


//        System.out.println(submarine);
//        System.out.println(submarineDirection);

        switch (submarineDirection)
        {
            case 1: //goes up
                if (submarine > 20) //in rows 3-10
                {
                    while (board[submarine - 1] != ' ' || board[submarine - 11] != ' ' ||  board[submarine - 21] != ' ')
                    {
                        submarine++;
                    }
                    board[submarine - 1] = 's';
                    board[submarine - 11] = 's';
                    board[submarine - 21] = 's';
                }
                else if (submarine <= 20 && submarine > 10) //in row 2
                {
                    while (board[submarine - 1] != ' ' || board[submarine - 11] != ' ' ||  board[submarine +9] != ' ')
                    {
                        submarine++;
                    }
                    board[submarine - 1] = 's';
                    board[submarine - 11] = 's';
                    board[submarine + 9] = 's';
                }
                else if (submarine <= 10) //in row 1
                {
                    while (board[submarine - 1] != ' ' || board[submarine +9] != ' ' ||  board[submarine +19] != ' ')
                    {
                        submarine++;
                    }
                    board[submarine - 1] = 's';
                    board[submarine + 9] = 's';
                    board[submarine + 19] = 's';
                }
                break;
            case 2: //goes right
                int x =0;
                if (submarine % 10 != 0)
                {
                    while (board[submarine - 1] != ' ' || board[submarine] != ' ' ||  board[submarine + 1] != ' '|| board[submarine - 2] != ' ')
                    {
                        submarine+=10;
                        if (submarine>=90)
                        {
                            submarine-=89;
                        }
                        x++;
                        if (x>=10)
                        {
                            submarine++;
                        }
                    }
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
                    while (board[submarine - 1] != ' ' || board[submarine-2] != ' ' ||  board[submarine-3] != ' ')
                    {
                        submarine+=10;
                        if (submarine>=90)
                        {
                            submarine-=89;
                        }
                        x++;
                        if (x>=10)
                        {
                            submarine++;
                        }
                    }
                    board[submarine - 1] = 's';
                    board[submarine - 2] = 's';
                    board[submarine - 3] = 's';
                }
                break;
        }
    }

    private static void PlaceCruiser(int cruiser) //this method is the same as the carrier method except it prints only 3 spots and prints 'c' instead of 'C' for the cruiser
    {
//        cruiser = 37;
//        direction = 2;

        if (cruiser < 3)
        {
            cruiser+= 3;
        }
        else if (cruiser > 96)
        {
            cruiser -=3;
        }

//        System.out.println(cruiser);
//        System.out.println(cruiserDirection);

        switch (cruiserDirection)
        {
            case 1: //goes up
                if (cruiser  > 20) //in rows 3-10
                {
                    while (board[cruiser - 1] != ' ' || board[cruiser - 11] != ' ' ||  board[cruiser - 21] != ' ')
                    {
                        cruiser++;
                    }
                    board[cruiser - 1] = 'c';
                    board[cruiser - 11] = 'c';
                    board[cruiser - 21] = 'c';
                }
                else if (cruiser <= 20 && cruiser > 10) //in row 2
                {
                    while (board[cruiser - 1] != ' ' || board[cruiser - 11] != ' ' ||  board[cruiser +9] != ' ')
                    {
                        cruiser++;
                    }
                    board[cruiser - 1] = 'c';
                    board[cruiser - 11] = 'c';
                    board[cruiser + 9] = 'c';
                }
                else if (cruiser <= 10) //in row 1
                {
                    while (board[cruiser - 1] != ' ' || board[cruiser +9] != ' ' ||  board[cruiser +19] != ' ')
                    {
                        cruiser++;
                    }
                    board[cruiser - 1] = 'c';
                    board[cruiser + 9] = 'c';
                    board[cruiser + 19] = 'c';
                }
                break;
            case 2: //goes right
                int x =0;
                if (cruiser % 10 != 0)
                {
                    while (board[cruiser - 1] != ' ' || board[cruiser] != ' ' ||  board[cruiser + 1] != ' '|| board[cruiser - 2] != ' ')
                    {
                        cruiser+=10;
                        if (cruiser>=90)
                        {
                            cruiser-=89;
                        }
                        x++;
                        if (x>=10)
                        {
                            cruiser++;
                        }
                    }
                    board[cruiser - 1] = 'c';
                    board[cruiser] = 'c';
                    if ((cruiser + 1) % 10 != 0)
                    {
                        board[cruiser + 1] = 'c';
                    }
                    else
                    {
                        board[cruiser - 2] = 'c';
                    }
                }
                else
                {
                    while (board[cruiser - 1] != ' ' || board[cruiser-2] != ' ' ||  board[cruiser-3] != ' ')
                    {
                        cruiser+=10;
                        if (cruiser>=90)
                        {
                            cruiser-=89;
                        }
                        x++;
                        if (x>=10)
                        {
                            cruiser++;
                        }
                    }
                    board[cruiser - 1] = 'c';
                    board[cruiser - 2] = 'c';
                    board[cruiser - 3] = 'c';
                }
                break;
        }
    }

    private static void PlaceDestroyer(int destroyer) //this method is the same as the carrier method except it prints only 2 spots and prints 'd' instead of 'C' for the destroyer
    {
//        direction = 2;
//        destroyer = 0;

        if (destroyer < 2)
        {
            destroyer+= 2;
        }
        else if (destroyer > 97)
        {
            destroyer -=2;
        }


//        System.out.println(destroyer);
//        System.out.println(destroyerDirection);

        switch (destroyerDirection)
        {
            case 1: //goes up
                if (destroyer  > 10) //in rows 2-10
                {
                    while (board[destroyer - 1] != ' ' || board[destroyer - 11] != ' ')
                    {
                        destroyer++;
                    }
                    board[destroyer - 1] = 'd';
                    board[destroyer - 11] = 'd';
                }
                else if (destroyer <= 10) //in row 1
                {
                    while (board[destroyer - 1] != ' ' || board[destroyer +9] != ' ')
                    {
                        destroyer++;
                    }
                    board[destroyer - 1] = 'd';
                    board[destroyer + 9] = 'd';
                }
                break;
            case 2: //goes right
                int x =0;
                if (destroyer % 10 != 0)
                {
                    while (board[destroyer - 1] != ' ' || board[destroyer] != ' ')
                    {
                        destroyer+=10;
                        if (destroyer>=90)
                        {
                            destroyer-=89;
                        }
                        x++;
                        if (x>=10)
                        {
                            destroyer++;
                        }
                    }
                    board[destroyer - 1] = 'd';
                    board[destroyer] = 'd';
                }
                else
                {
                    while (board[destroyer - 1] != ' ' || board[destroyer-2] != ' ')
                    {
                        destroyer+=10;
                        if (destroyer>=90)
                        {
                            destroyer-=89;
                        }
                        x++;
                        if (x>=10)
                        {
                            destroyer++;
                        }
                    }
                    board[destroyer - 1] = 'd';
                    board[destroyer - 2] = 'd';
                }
                break;
        }
    }

    private static int xCoord(char XInput) //this takes the first portion of the string that you entered and returns a value based on the letter you entered. if you enter a, it will return 1
    {
        switch (XInput)
        {
            case 'a':
            case 'A':
                return 1;
            case 'b':
            case 'B':
                return 2;
            case 'c':
            case 'C':
                return 3;
            case 'd':
            case 'D':
                return 4;
            case 'e':
            case 'E':
                return 5;
            case 'f':
            case '6':
                return 6;
            case 'g':
            case 'G':
                return 7;
            case 'h':
            case 'H':
                return 8;
            case 'i':
            case 'I':
                return 9;
            case 'j':
            case 'J':
                return 10;
            default:
                return 11;
        }
    }

    public static void UserCarrier(String start, int direction)//this takes the input from the user and prints in the board based on that
    {
        int x = xCoord(start.charAt(0)); //this takes the x value from the user and determines what column the ship prints in
        int y = Integer.parseInt(start.substring(1)); //this takes the number and determines where in the column the ship should be printed
        int position = ((y-1) * 10) + (x - 1); //this is the formula that takes the x and y value and determines where in the grid that is.

//        position = 38;

        if (direction == 1) //this takes the direction that the user prints and prints the ship differently depending on if they want it to be vertical or horizontal
        {
            if (position > 40)
            {
                MyBoard[position] = 'C';
                MyBoard[position - 10] = 'C';
                MyBoard[position - 20] = 'C';
                MyBoard[position - 30] = 'C';
                MyBoard[position - 40] = 'C';
            }
            else if (position <= 40 && position > 10)
            {
                MyBoard[position] = 'C';
                MyBoard[position - 10] = 'C';
                MyBoard[position + 10] = 'C';
                MyBoard[position + 20] = 'C';
                MyBoard[position + 30] = 'C';
            }
            else if (position <= 10)
            {
                MyBoard[position] = 'C';
                MyBoard[position + 10] = 'C';
                MyBoard[position + 20] = 'C';
                MyBoard[position + 30] = 'C';
                MyBoard[position + 40] = 'C';
            }
        }
        else // if direction = 2 makes it horizontal
        {
            if (position % 10 != 0)
            {
                MyBoard[position] = 'C';
                if ((position + 1)% 10 != 0)
                {
                    MyBoard[position+1] = 'C';
                    if ((position + 2) % 10 != 0)
                    {
                        MyBoard[position+2] = 'C';
                        if ((position + 3)%10 !=0)
                        {
                            MyBoard[position+3] = 'C';
                            if ((position+4)%10 != 0)
                            {
                                MyBoard[position+4] = 'C';
                            }
                            else
                            {
                                MyBoard[position-1] = 'C';
                            }
                        }
                        else
                        {
                            MyBoard[position-1] = 'C';
                            MyBoard[position-2] = 'C';
                        }
                    }
                    else
                    {
                        MyBoard[position - 1] = 'C';
                        MyBoard[position - 2] = 'C';
                        MyBoard[position - 3] = 'C';
                    }
                }
                else
                {
                    MyBoard[position - 1] = 'C';
                    MyBoard[position - 2] = 'C';
                    MyBoard[position - 3] = 'C';
                    MyBoard[position - 4] = 'C';
                }
            }
            else
            {
                MyBoard[position] = 'C';
                MyBoard[position + 1] = 'C';
                MyBoard[position + 2] = 'C';
                MyBoard[position + 3] = 'C';
                MyBoard[position + 4] = 'C';
            }
        }
        DrawUserField();
    }

    public static boolean UserBattleship(String start, int direction) //same code as the carrier except it is shorter for the battleship prints 4 instead of 5 ships
                                                                      // these next methods are booleans because they return false if the coordinate that you chose is already taken by another ship
    {
        int x = xCoord(start.charAt(0));
        int y = Integer.parseInt(start.substring(1));
        int position = ((y-1) * 10) + (x - 1);
        boolean BattleshipTrue = true;

            if (direction == 1)
            {
                if (position > 30)
                {
                    if (MyBoard[position] != ' ' || MyBoard[position - 10] != ' ' || MyBoard[position - 20] != ' ' || MyBoard[position - 30] != ' ')
                    {
                        System.out.println("Stop cheating");
                        BattleshipTrue = false;
                    }
                    else
                    {
                        MyBoard[position] = 'b';
                        MyBoard[position - 10] = 'b';
                        MyBoard[position - 20] = 'b';
                        MyBoard[position - 30] = 'b';
                        BattleshipTrue =  true;
                    }
                }
                else if (position <= 30 && position > 10)
                {
                    if (MyBoard[position] != ' ' || MyBoard[position - 10] != ' ' || MyBoard[position + 10] != ' ' || MyBoard[position + 20] != ' ')
                    {
                        System.out.println("Stop cheating");
                        BattleshipTrue = false;
                    }
                    else
                    {
                        MyBoard[position] = 'b';
                        MyBoard[position - 10] = 'b';
                        MyBoard[position + 10] = 'b';
                        MyBoard[position + 20] = 'b';
                        BattleshipTrue =  true;
                    }
                }
                else if (position <= 10)
                {
                    if (MyBoard[position] != ' ' || MyBoard[position + 10] != ' ' || MyBoard[position + 20] != ' ' || MyBoard[position + 30] != ' ')
                    {
                        System.out.println("Stop cheating");
                        BattleshipTrue = false;
                    }
                    else
                    {
                        MyBoard[position] = 'b';
                        MyBoard[position + 10] = 'b';
                        MyBoard[position + 20] = 'b';
                        MyBoard[position + 30] = 'b';
                        BattleshipTrue =  true;
                    }
                }
            }
            else // if direction = 2
            {
                if (position % 10 != 0)
                {
                    if (MyBoard[position] != ' ' || MyBoard[position + 1] != ' ' || MyBoard[position + 2] != ' ' || MyBoard[position + 3] != ' ')
                    {
                        System.out.println("Stop cheating");
                        BattleshipTrue = false;
                    }
                    else
                    {
                        MyBoard[position] = 'b';
                        if ((position + 1)% 10 != 0)
                        {
                            MyBoard[position+1] = 'b';
                            if ((position + 2) % 10 != 0)
                            {
                                MyBoard[position+2] = 'b';
                                if ((position + 3)%10 !=0)
                                {
                                    MyBoard[position+3] = 'b';
                                }
                                else
                                {
                                    if (MyBoard[position - 1] != ' ')
                                    {
                                        System.out.println("Stop cheating");
                                        BattleshipTrue = false;
                                    }
                                    else
                                    {
                                        MyBoard[position-1] = 'b';
                                        BattleshipTrue = true;
                                    }
                                }
                            }
                            else
                            {
                                if (MyBoard[position - 1] != ' ' || MyBoard[position - 2] != ' ')
                                {
                                    System.out.println("Stop cheating");
                                    BattleshipTrue = false;
                                }
                                else
                                {
                                    MyBoard[position - 1] = 'b';
                                    MyBoard[position - 2] = 'b';
                                    BattleshipTrue = true;
                                }
                            }
                        }
                        else
                        {
                            if (MyBoard[position - 1] != ' ' || MyBoard[position - 2] != ' ' || MyBoard[position - 3] != ' ')
                            {
                                System.out.println("Stop cheating");
                                BattleshipTrue = false;
                            }
                            else
                            {
                                MyBoard[position - 1] = 'b';
                                MyBoard[position - 2] = 'b';
                                MyBoard[position - 3] = 'b';
                                BattleshipTrue = true;
                            }
                        }
                    }
                }
                else
                {
                    if (MyBoard[position] != ' ' || MyBoard[position + 1] != ' ' || MyBoard[position + 2] != ' ' || MyBoard[position + 3] != ' ')
                    {
                        System.out.println("Stop cheating");
                        BattleshipTrue = false;
                    }
                    else
                    {
                        MyBoard[position] = 'b';
                        MyBoard[position + 1] = 'b';
                        MyBoard[position + 2] = 'b';
                        MyBoard[position + 3] = 'b';
                        BattleshipTrue =  true;
                    }
                }
            }
        if (BattleshipTrue)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public static boolean UserCruiser(String start, int direction) //same code as the battleship except it is shorter for the cruiser prints 3 instead of 4 ships
    {
        int x = xCoord(start.charAt(0));
        int y = Integer.parseInt(start.substring(1));
        int position = ((y-1) * 10) + (x - 1);
        boolean CruiserTrue = true;

        if (direction == 1)
        {
            if (position > 20)
            {
                if (MyBoard[position] != ' ' || MyBoard[position - 10] != ' ' || MyBoard[position - 20] != ' ')
                {
                    System.out.println("Stop cheating");
                    CruiserTrue = false;
                }
                else
                {
                    MyBoard[position] = 'c';
                    MyBoard[position - 10] = 'c';
                    MyBoard[position - 20] = 'c';
                    CruiserTrue = true;
                }
            }
            else if (position <= 20 && position > 10)
            {
                if (MyBoard[position] != ' ' || MyBoard[position - 10] != ' ' || MyBoard[position + 10] != ' ')
                {
                    System.out.println("Stop cheating");
                    CruiserTrue = false;
                }
                else
                {
                    MyBoard[position] = 'c';
                    MyBoard[position - 10] = 'c';
                    MyBoard[position + 10] = 'c';
                    CruiserTrue = true;
                }
            }
            else if (position <= 10)
            {
                if (MyBoard[position] != ' ' || MyBoard[position + 10] != ' ' || MyBoard[position + 20] != ' ')
                {
                    System.out.println("Stop cheating");
                    CruiserTrue = false;
                }
                else
                {
                    MyBoard[position] = 'c';
                    MyBoard[position + 10] = 'c';
                    MyBoard[position + 20] = 'c';
                    CruiserTrue = true;
                }
            }
        }
        else // if direction = 2
        {
            if (MyBoard[position] != ' ' || MyBoard[position + 1] != ' ' || MyBoard[position + 2] != ' ')
            {
                System.out.println("Stop cheating");
                CruiserTrue = false;
            }
            else
            {
                if (position % 10 != 0)
                {
                    MyBoard[position] = 'c';
                    if ((position + 1)% 10 != 0)
                    {
                        MyBoard[position+1] = 'c';
                        if ((position + 2) % 10 != 0)
                        {
                            MyBoard[position+2] = 'c';
                        }
                        else
                        {
                            if (MyBoard[position - 1] != ' ')
                            {
                                System.out.println("Stop cheating");
                                CruiserTrue = false;
                            }
                            else
                            {
                                MyBoard[position - 1] = 'c';
                                CruiserTrue = true;
                            }
                        }
                    }
                    else
                    {
                        if (MyBoard[position - 1] != ' ' || MyBoard[position - 2] != ' ')
                        {
                            System.out.println("Stop cheating");
                            CruiserTrue = false;
                        }
                        else
                        {
                            MyBoard[position - 1] = 'c';
                            MyBoard[position - 2] = 'c';
                            CruiserTrue = true;
                        }
                    }
                }
                else
                {
                    if (MyBoard[position] != ' ' || MyBoard[position + 1] != ' ' || MyBoard[position + 2] != ' ')
                    {
                        System.out.println("Stop cheating");
                        CruiserTrue = false;
                    }
                    else
                    {
                        MyBoard[position] = 'c';
                        MyBoard[position + 1] = 'c';
                        MyBoard[position + 2] = 'c';
                        CruiserTrue = true;
                    }
                }
            }
        }
        if (CruiserTrue)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public static boolean UserSubmarine(String start, int direction) //same code as the battleship except it is shorter for the submarine prints 3 instead of 4 ships
    {
        int x = xCoord(start.charAt(0));
        int y = Integer.parseInt(start.substring(1));
        int position = ((y-1) * 10) + (x - 1);
        boolean SubmarineTrue = true;

        if (direction == 1)
        {
            if (position > 20)
            {
                if (MyBoard[position] != ' ' || MyBoard[position - 10] != ' ' || MyBoard[position - 20] != ' ')
                {
                    System.out.println("Stop cheating");
                    SubmarineTrue = false;
                }
                else
                {
                    MyBoard[position] = 's';
                    MyBoard[position - 10] = 's';
                    MyBoard[position - 20] = 's';
                    SubmarineTrue = true;
                }
            }
            else if (position <= 20 && position > 10)
            {
                if (MyBoard[position] != ' ' || MyBoard[position - 10] != ' ' || MyBoard[position + 10] != ' ')
                {
                    System.out.println("Stop cheating");
                    SubmarineTrue = false;
                }
                else
                {
                    MyBoard[position] = 's';
                    MyBoard[position - 10] = 's';
                    MyBoard[position + 10] = 's';
                    SubmarineTrue = true;
                }
            }
            else if (position <= 10)
            {
                if (MyBoard[position] != ' ' || MyBoard[position + 10] != ' ' || MyBoard[position + 20] != ' ')
                {
                    System.out.println("Stop cheating");
                    SubmarineTrue = false;
                }
                else
                {
                    MyBoard[position] = 's';
                    MyBoard[position + 10] = 's';
                    MyBoard[position + 20] = 's';
                    SubmarineTrue = true;
                }
            }
        }
        else // if direction = 2
        {
            if (MyBoard[position] != ' ' || MyBoard[position + 1] != ' ' || MyBoard[position + 2] != ' ')
            {
                System.out.println("Stop cheating");
                SubmarineTrue = false;
            }
            else
            {
                if (position % 10 != 0)
                {
                    MyBoard[position] = 's';
                    if ((position + 1)% 10 != 0)
                    {
                        MyBoard[position+1] = 's';
                        if ((position + 2) % 10 != 0)
                        {
                            MyBoard[position+2] = 's';
                        }
                        else
                        {
                            if (MyBoard[position - 1] != ' ')
                            {
                                System.out.println("Stop cheating");
                                SubmarineTrue = false;
                            }
                            else
                            {
                                MyBoard[position - 1] = 's';
                                SubmarineTrue = true;
                            }
                        }
                    }
                    else
                    {
                        if (MyBoard[position - 1] != ' ' || MyBoard[position - 2] != ' ')
                        {
                            System.out.println("Stop cheating");
                            SubmarineTrue = false;
                        }
                        else
                        {
                            MyBoard[position - 1] = 's';
                            MyBoard[position - 2] = 's';
                            SubmarineTrue = true;
                        }
                    }
                }
                else
                {
                    if (MyBoard[position] != ' ' || MyBoard[position + 1] != ' ' || MyBoard[position + 2] != ' ')
                    {
                        System.out.println("Stop cheating");
                        SubmarineTrue = false;
                    }
                    else
                    {
                        MyBoard[position] = 's';
                        MyBoard[position + 1] = 's';
                        MyBoard[position + 2] = 's';
                        SubmarineTrue = true;
                    }
                }
            }
        }

        if (SubmarineTrue)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public static boolean UserDestroyer(String start, int direction) //same code as the submarine except it is shorter for the destroyer prints 2 instead of 3 ships
    {
        int x = xCoord(start.charAt(0));
        int y = Integer.parseInt(start.substring(1));
        int position = ((y-1) * 10) + (x - 1);
        boolean DestroyerTrue = true;

        if (direction == 1)
        {
            if (position > 10)
            {
                if (MyBoard[position] != ' ' || MyBoard[position - 10] != ' ')
                {
                    System.out.println("Stop cheating");
                    DestroyerTrue = false;
                }
                else
                {
                    MyBoard[position] = 'd';
                    MyBoard[position - 10] = 'd';
                    DestroyerTrue = true;
                }
            }
            else if (position <= 10)
            {
                if (MyBoard[position] != ' ' || MyBoard[position + 10] != ' ')
                {
                    System.out.println("Stop cheating");
                    DestroyerTrue = false;
                }
                else
                {
                    MyBoard[position] = 'd';
                    MyBoard[position + 10] = 'd';
                    DestroyerTrue = true;
                }
            }
        }
        else // if direction = 2
        {
            if (position % 10 != 0)
            {
                MyBoard[position] = 'd';
                if ((position + 1)% 10 != 0)
                {
                    MyBoard[position+1] = 'd';
                }
                else
                {
                    if (MyBoard[position - 1] != ' ')
                    {
                        System.out.println("Stop cheating");
                        DestroyerTrue = false;
                    }
                    else
                    {
                        MyBoard[position - 1] = 'd';
                        DestroyerTrue = true;
                    }
                }
            }
            else
            {
                if (MyBoard[position] != ' ' || MyBoard[position + 1] != ' ')
                {
                    System.out.println("Stop cheating");
                    DestroyerTrue = false;
                }
                else
                {
                    MyBoard[position] = 'd';
                    MyBoard[position + 1] = 'd';
                    DestroyerTrue = true;
                }
            }
        }
        if (DestroyerTrue)
        {
            return true;
        }
        else
        {
            return false;
        }
    }


    public static void UserInput(String Shoot) throws InterruptedException //this method is for shooting the AI's ships.
    {
        int x = xCoord(Shoot.charAt(0)); //the user enters a coordinate and this takes the x value of that coordinate
        int y = Integer.parseInt(Shoot.substring(1)); // this takes the y value from the coordinate and shoots there.

        int position = ((y-1) * 10) + (x - 1); //this calculates where on the array the coordinate ids.

        //then it tests to see if you sunk its ships and displays a message if you do
        if (board[position] == 'C')
        {
            ShotBoard[position] = 'X';
            CarrierSunk++;
            if (CarrierSunk == 5)
            {
                System.out.println("You have sunk their Carrier");
                Thread.sleep(1000);
            }
        }
        else if (board[position] == 'b')
        {
            ShotBoard[position] = 'X';
            BattleshipSunk++;
            if (BattleshipSunk == 4)
            {
                System.out.println("You have sunk their Battleship");
                Thread.sleep(1000);
            }
        }
        else if (board[position] == 'c')
        {
            ShotBoard[position] = 'X';
            CruiserSunk++;
            if (CruiserSunk == 3)
            {
                System.out.println("You have sunk the Cruiser");
                Thread.sleep(1000);
            }
        }
        else if (board[position] == 's')
        {
            ShotBoard[position] = 'X';
            SubmarineSunk++;
            if (SubmarineSunk == 3)
            {
                System.out.println("You have sunk the Submarine");
                Thread.sleep(1000);
            }
        }
        else if (board[position] == 'd')
        {
            ShotBoard[position] = 'X';
            DestroyerSunk++;
            if (DestroyerSunk == 2)
            {
                System.out.println("You have sunk the Destroyer");
                Thread.sleep(1000);
            }
        }
        else //this is if you miss
        {
            ShotBoard[position] = 'O';
        }

        DrawShootingRange();
    }

    public static void AIShoots() throws InterruptedException //this is where the AI shoots from
    {
        int shot = 0; //it always shoots at a1 first because the randomize does not shoot that one spot.

        while (MyBoard[shot] == 'X' || MyBoard[shot] == 'O') //it checks if it is shooting a spot that it has already shot and then changes where it shoots until it shoots somewhere new.
        {
            shot = rand.nextInt(100)+1;
            if (shot == 100) //if shoot = 100, then i have an error because that is outside the array.
            {
                shot = shot-1;
            }
        }

        //then it tests to see if it sinks your ships and displays a message if it does
        if (MyBoard[shot] == 'C')
        {
            MyBoard[shot] = 'X';
            UserCarrierSunk++;
            if (UserCarrierSunk == 5)
            {
                System.out.println("The AI has sunk your Carrier");
                Thread.sleep(1000);
            }
        }
        else if (MyBoard[shot] == 'b')
        {
            MyBoard[shot] = 'X';
            UserBattleshipSunk++;
            if (UserBattleshipSunk == 4)
            {
                System.out.println("The AI has sunk your Battleship");
                Thread.sleep(1000);
            }
        }
        else if (MyBoard[shot] == 'c')
        {
            MyBoard[shot] = 'X';
            UserCruiserSunk++;
            if (UserCruiserSunk == 3)
            {
                System.out.println("The AI has sunk your Cruiser");
                Thread.sleep(1000);
            }
        }
        else if (MyBoard[shot] == 's')
        {
            MyBoard[shot] = 'X';
            UserSubmarineSunk++;
            if (UserSubmarineSunk == 3)
            {
                System.out.println("The AI has sunk your Submarine");
                Thread.sleep(1000);
            }
        }
        else if (MyBoard[shot] == 'd')
        {
            MyBoard[shot] = 'X';
            UserDestroyerSunk++;
            if (UserDestroyerSunk == 2)
            {
                System.out.println("The AI has sunk your Destroyer");
                Thread.sleep(1000);
            }
        }
        else //this is if the AI misses
        {
            MyBoard[shot] = 'O';
        }
        DrawUserField();
    }
}
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
each of the spaces is a spot f0r either an x or an o
 */
public class Battleship
    //tomorrow, I need to add a row below the top row with a bunch of dots for the "roof" of the boxes and need to add spaces between each number to create the "floors" for each box
    //try too make a character array that corisponds to each space and print each of those those characters in the space with a values of " ".
{
    public static void DrawField() //the field is a 10x10 and is A-J on the top and 1-10 on the left
    {
        String topRow = "  .A.B.C.D.E.F.G.H.I.J."; //top row. it is a string because I will use charAr to get values later
        System.out.println(topRow);
        //make an array for each of the values
        String[] row1 = {" ", " ", " ", " ", " ", " ", " ", " ", " ", " "," "}; //{"a1", "a2", "a3","a4", "a5", "a6","a7", "a8", "a9","a10"};
        //this may be unnecessary
//        String[] row2 = {" ", " ", " ", " ", " ", " ", " ", " ", " ", " "," "}; //{"b1", "b2", "b3","b4", "b5", "b6","b7", "b8", "b9","b10"};
//        String[] row3 = {" ", " ", " ", " ", " ", " ", " ", " ", " ", " "," "}; //{"c1", "c2", "c3","c4", "c5", "c6","c7", "c8", "c9","c10"};
//        String[] row4 = {" ", " ", " ", " ", " ", " ", " ", " ", " ", " "," "}; //{"d1", "d2", "d3","d4", "d5", "d6","d7", "d8", "d9","d10"};
//        String[] row5 = {" ", " ", " ", " ", " ", " ", " ", " ", " ", " "," "}; //{"e1", "e2", "e3","e4", "e5", "e6","e7", "e8", "e9","e10"};
//        String[] row6 = {" ", " ", " ", " ", " ", " ", " ", " ", " ", " "," "}; //{"f1", "f2", "f3","f4", "f5", "f6","f7", "f8", "f9","f10"};
//        String[] row7 = {" ", " ", " ", " ", " ", " ", " ", " ", " ", " "," "}; //{"g1", "g2", "g3","g4", "g5", "g6","g7", "g8", "g9","g10"};
//        String[] row8 = {" ", " ", " ", " ", " ", " ", " ", " ", " ", " "," "}; //{"h1", "h2", "h3","h4", "h5", "h6","h7", "h8", "h9","h10"};
//        String[] row9 = {" ", " ", " ", " ", " ", " ", " ", " ", " ", " "," "}; //{"i1", "i2", "i3","i4", "i5", "i6","i7", "i8", "i9","i10"};
//        String[] row10 = {" ", " ", " ", " ", " ", " ", " ", " ", " ", " "," "};//{"j1", "j2", "j3","j4", "j5", "j6","j7", "j8", "j9","j10"};
        for(int x = 1; x<10;x++)
        {
            DrawLine(x);
            for (int i = 0; i < 11; i++)
            {
                System.out.print(".");
                System.out.print(row1[i]);

            }
            System.out.print('\n');
        }


    }

    public static void DrawLine(int x) //x changes what number is printed per row
    {
        for (int i =0; i<23;i++)
        {
            System.out.print(".");
        }
        System.out.print("\n");
        System.out.print(x+" ");
    }

    public static void Line10()
    {

    }

}


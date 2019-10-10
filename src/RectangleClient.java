/*
Varun Sureka
10/4/19
Java Period 2
*/
import java.util.Scanner;
public class RectangleClient
{
    public static void main(String[] args)
    {
        /*
        All of the scanners at the beginning give the values for point one and 2 for the first and second rectangle.
        All the commented lines of code below that are mutator and assessor methods that work. You can use those to change or get the values of the points
        the compare method compares both areas and then prints the bigger rectangle and prints its area.
        */

        //Scanner stuff
        Scanner pointScan = new Scanner(System.in);
        System.out.println("Enter value for p1's x");
        int p1x = pointScan.nextInt();

        System.out.println("Enter value for p1's y");
        int p1y = pointScan.nextInt();

        System.out.println("Enter value for p2's x");
        int p2x = pointScan.nextInt();

        System.out.println("Enter value for p2's y");
        int p2y = pointScan.nextInt();

        Rectangle rec1 = new Rectangle (p1x, p1y, p2x, p2y); //Rectangle 1

        System.out.println("Enter value for rectangle 2's p1's x");
        p1x = pointScan.nextInt();

        System.out.println("Enter value for rectangle 2's p1's y");
        p1y = pointScan.nextInt();

        System.out.println("Enter value for rectangle 2's p2's x");
        p2x = pointScan.nextInt();

        System.out.println("Enter value for rectangle 2's p2's y");
        p2y = pointScan.nextInt();

        Rectangle rec2 = new Rectangle (p1x, p1y, p2x, p2y); //Rectangle 2

        //Mutator Methods
        //rec1.setp1(0,0);
        //rec1.setp2(5,5);

        //rec2.setp1(0,0);
        //rec2.setp2(10,10);


        //Assessor Methods
        //System.out.println(rec1.getp1x());
        //System.out.println(rec1.getp1y());
        //System.out.println(rec1.getp2x());
        //System.out.println(rec1.getp2y());

        //System.out.println(rec2.getp1x());
        //System.out.println(rec2.getp1y());
        //System.out.println(rec2.getp2x());
        //System.out.println(rec2.getp2y());

        //Draw methods for specific rectangles
        //rec1.DrawRect();
        //rec2.DrawRect();

        //Area methods for either rectangle
        //System.out.println("The area of the rectangle is "+ rec1.Area());
        //System.out.println("The area of the rectangle 2 is "+ rec2.Area());

        //Compare method for areas of rectangles
        rec1.Compare(rec1,rec2);
    }
}

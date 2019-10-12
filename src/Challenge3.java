/*
Varun Sureka
10/11/19
Java Period 2
*/

import java.util.Scanner;
public class Challenge3
{

    public static int x ;
    public static void main(String[] args)
    {
        Scanner scaleScanner = new Scanner(System.in);
        System.out.println("Enter a number to scale the figure: (4 is standard)");
        x= scaleScanner.nextInt();
        PlusLine();
        TopHalfTop();
        TopHalfBottom();
        PlusLine();
        TopHalfBottom();
        TopHalfTop();
        PlusLine();
    }

    public static void PlusLine()
    {
        System.out.print("+");
        for (int y =0; y<2*x+2; y++)
        {
            if (y == 2*x+1)
            {
                System.out.print("+");
            }
            else
            {
                System.out.print("-");
            }
        }
        System.out.print('\n');
    }

    public static void TopHalfTop()
    {
        for (int line = x; line>0;line--)
        {
            System.out.print("|");
            Spaces(line);
            Pyramid(line);
            Spaces(line);
            System.out.print("|");
            System.out.print('\n');
        }
    }

    public static void TopHalfBottom()
    {
        for(int line = x; line>0; line--)
        {
            System.out.print("|");
            SpaceDown(line);
            PyramidDown(line);
            SpaceDown(line);
            System.out.print("|");
            System.out.print('\n');
        }
    }

    public static void Spaces(int line)
    {
        for (int space = 0; space<(line); space++)
        {
            System.out.print(" ");
        }
    }

    public static void Pyramid(int line)
    {
        for (int slash = 0; slash<(x-line); slash++)
        {
            System.out.print("/");
        }
        System.out.print("*");
        for (int slash = 0; slash<(x-line); slash++)
        {
            System.out.print("\\");
        }
    }

    public static void SpaceDown(int line)
    {
        for (int space =0; space <((x+1)-line); space++)
        {
            System.out.print(" ");
        }
    }

    public static void PyramidDown(int line)
    {
        for (int slash = 1; slash<line; slash++)
        {
            System.out.print("\\");
        }
        System.out.print("*");
        for (int slash = 1; slash<line; slash++)
        {
            System.out.print("/");
        }
    }
}

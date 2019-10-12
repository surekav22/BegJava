/*
Varun Sureka
10/11/19
Java 1
 */

import java.util.Scanner;
public class SeattleTower
{
    public static int i;

    public static void main (String [] args)
    {
        Scanner scaleScanner = new Scanner(System.in);
        System.out.println("Enter a number to scale the figure: (4 is standard)");
        i= scaleScanner.nextInt();

        Tip();
        TopHalfTower();
        BottomHalfTower();
        Tip();
        Mid();
        TopHalfTower();
    }
    public static void Tip()
    {
        for (int tip = i; tip>0; tip--)
        {
            for (int space = 0; space<i*3; space++)
            {
                System.out.print(" ");
            }
            System.out.print("||");
            System.out.print('\n');
        }
    }

    public static void TopHalfTower()
    {
        for (int line = i*2; line > -i; line -=3)
        {
            SpaceTopHalf(line);
            TowerColonsPyramid(line);
            System.out.print('\n');
        }
        QuotationLine();
    }

    public static void BottomHalfTower()
    {
        for (int line = i+1; line >-2; line -=2)
        {
            Spaces(line);
            DownPyramid(line);
            System.out.print('\n');
        }
    }
    public static void Mid()
    {
        for (int x =0; x <(i*4); x++)
        {
            for (int space = 0; space<i*3-3; space++)
            {
                System.out.print(" ");
            }
            System.out.print("|%%||%%|");
            System.out.print('\n');
        }
    }

    public static void QuotationLine()
    {
        System.out.print("|");
        for (int x = 0; x<i*6; x++)
        {
            System.out.print("\"");
        }
        System.out.print("|");
        System.out.print('\n');
    }

    public static void SpaceTopHalf(int line)
    {
        for(int x =3; x<line+i; x++)
        {
            System.out.print(" ");
        }
        System.out.print("__/");
    }

    public static void Spaces(int line)
    {
        for (int x = -1; x<i-line; x++)
        {
            System.out.print(" ");
        }
        System.out.print("\\_");
    }

    public static void TowerColonsPyramid(int line)
    {
        for (int y =0; y<(i*2-line); y++)
        {
            System.out.print(":");
        }
        System.out.print("||");
        for (int y =0; y<(i*2-line); y++)
        {
            System.out.print(":");
        }
        System.out.print('\\'+"__");
    }

    public static void DownPyramid(int line)
    {
        for (int x = 0; x<i*2+line-2; x++)
        {
            System.out.print("/\\");
        }
        System.out.print("_/");
    }
}


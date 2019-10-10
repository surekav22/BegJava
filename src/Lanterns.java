/*
Varun Sureka
9/21/19
Lanterns Pattern Code for Test
 */

public class Lanterns
{
    public static void main(String[] args)
    {
        Top();
        System.out.print('\n');
        Top();
        Mid();
        System.out.print('\n');
        Top();
    }
    public static void Top()
    {
        for (int line = 3; line >0; line--)
        {
            for (int space = 1; space <line; space++)
            {
                System.out.print("  ");
            }
            for (int y = 0; y<(4-line); y++)
            {
                System.out.print("**");
            }
            System.out.print("*");
            for (int y = 0; y<(4-line); y++)
            {
                System.out.print("**");
            }
            System.out.print('\n');
        }
    }
    public static void Mid()
    {
        System.out.print("* ");
        for (int x =0; x<5; x++)
        {
            System.out.print("| ");
        }
        System.out.print("*");
        System.out.print('\n');
        for (int y =0; y<13; y++)
        {
            System.out.print("*");
        }
    }
}

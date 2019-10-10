/*
Varun Sureka
10/4/19
Java Period 2
*/

public class Challenge3 {
    public static void main(String[] args)
    {
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
        for (int x =9; x>0; x--)
        {
            System.out.print("-");
        }
        System.out.print("+");
        System.out.print('\n');
    }

    public static void TopHalfTop()
    {
        for (int line = 4; line>0;line--)
        {
            System.out.print("|");
            for (int space1 = 0; space1<(line); space1++)
            {
                System.out.print(" ");
            }
            for (int slash = 0; slash<(4-line); slash++)
            {
                System.out.print("/");
            }
            System.out.print("*");
            for (int slash = 0; slash<(4-line); slash++)
            {
                System.out.print("\\");
            }
            for (int space1 = 0; space1<(line); space1++)
            {
                System.out.print(" ");
            }
            System.out.print("|");
            System.out.print('\n');
        }
    }

    public static void TopHalfBottom()
    {
        for(int line = 4; line>0; line--)
        {
            System.out.print("|");
            for (int space = 0; space <(5-line); space++)
            {
                System.out.print(" ");
            }
            for (int slash = 1; slash<line; slash++)
            {
                System.out.print("\\");
            }
            System.out.print("*");
            for (int slash = 1; slash<line; slash++)
            {
                System.out.print("/");
            }
            for (int space = 0; space <(5-line); space++)
            {
                System.out.print(" ");
            }
            System.out.print("|");
            System.out.print('\n');
        }
    }
}

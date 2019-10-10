

public class HomeworkTester
{

    public static void main (String [] args)
    {

        int c = 0;
        for (int line = 7; line > 0; line --)
        {
            for (int x = 1; x<line; x++)
            {
                System.out.print("*");
            }
            for (int y = -1; y<(7-line); y++)
            {
                System.out.print(" ");
            }
            for (int z = 6; z>c; z--)
            {
                System.out.print("//");
            }
            for (int a = 0; a<(7-line); a++)
            {
                System.out.print("\\\\");
            }
            for (int b =-1; b<(7-line); b++)
            {
                System.out.print(" ");
            }
            for (int d =6; d>(7-line); d--)
            {
                System.out.print("*");
            }

            System.out.print('\n');
            c++;
        }





    }

}

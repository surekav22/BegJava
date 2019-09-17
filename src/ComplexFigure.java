public class ComplexFigure
{
    public static void main (String [] args)
    {
        Top();
        Bottom();

    }
    public static void Top()
    {
        for (int line =5; line >0; line-- )
        {
            for (int Hashtag = 5; Hashtag == line; Hashtag--)
            {
                System.out.print("#");
            }
            for (int EqualSign = 4; EqualSign < line; EqualSign++)
            {
                System.out.print("================");
            }
            for (int Hashtag = 5; Hashtag == line; Hashtag--)
            {
                System.out.print("#");
            }
            if (line <= 4)
            {
                System.out.print("|");
                for (int x = 1; x < line; x++)
                {
                    System.out.print("  ");
                }
                System.out.print("<>");
                for (int y = 0; y < (4 - line); y++)
                {
                    System.out.print("..");
                }
                for (int z =0; z<(4-line); z++)
                {
                    System.out.print("..");
                }
                System.out.print("<>");
                for (int x = 1; x < line; x++)
                {
                    System.out.print("  ");
                }
                System.out.print("|");
            }
            System.out.print("\n");
        }
    }
    public static void Bottom()
    {
        for (int line =4; line >0; line-- )
        {
                System.out.print("|");
            for (int x=1; x<(5-line); x++)
            {
                System.out.print("  ");
            }
            System.out.print("<>");
            for (int d =4; d>(5-line); d--)
            {
                System.out.print("..");
            }
            for (int x = 1; x<line; x++)
            {
                System.out.print("..");
            }
            System.out.print("<>");
            for (int y = 1; y<(5-line); y++)
            {
                System.out.print("  ");
            }
            System.out.print("|");
            System.out.print("\n");
        }
        System.out.print("#");
        for (int a=0; a<16; a++)
        {
            System.out.print("=");
        }
        System.out.print("#");
    }
}


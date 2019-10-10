

public class SeattleTower
{
    public static void main (String [] args)
    {
        Tip();
        TopHalfTower();
        BottomHalfTower();
        Tip();
        Mid();
        TopHalfTower();
    }
    public static void Tip()
    {
        for (int tip = 0; tip<4; tip++)
        {
            for (int space = 0; space<12; space++)
            {
                System.out.print(" ");
            }
            System.out.print("||");
            System.out.print('\n');
        }
    }
    public static void TopHalfTower()
    {
// 8 spaces on first line
//5 on second
// 2 on third
        System.out.print("         __/||" + '\\' +"__         ");
        System.out.print('\n');
        for (int line = 9; line > 0; line -=3)
        {
            for (int x = 3; x < line; x++)
            {
                System.out.print(" ");
            }
            System.out.print("__/");
            for (int y = -2; y<(10-line); y++)
            {
                System.out.print(":");
            }
            System.out.print("||");
            for (int y = -2; y<(10-line); y++)
            {
                System.out.print(":");
            }
            System.out.print('\\'+"__");
            for (int x = 3; x < line; x++)
            {
                System.out.print(" ");
            }
            System.out.print('\n');
        }
        System.out.print("|");
        for (int x=0; x<24; x++)
        {
            System.out.print("\"");
        }
        System.out.print("|");
        System.out.print('\n');
    }
    public static void BottomHalfTower()
    {
        for (int line = 4; line >0; line --)
        {
            for (int b =-1; b<(7-line*2); b++)
            {
                System.out.print(" ");
            }
            System.out.print('\\'+"_");
            for (int a =-2; a<(line)*2+1;a++)
            {
                System.out.print("/\\");
            }
            System.out.print("_/");
            System.out.print('\n');
        }
    }
    public static void Mid()
    {
        for (int x =0; x <16; x++)
        {
            for (int space = 0; space<9; space++)
            {
                System.out.print(" ");
            }
            System.out.print("|%%||%%|");
            System.out.print('\n');
        }
    }
}


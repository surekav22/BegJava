import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

public class SeattleTower
{
    public static void main (String [] args)
    {
        Tip();
        TopHalfTower();
        BottomHalfTower();
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
            for (int space = 0; space<12; space++)
            {
                System.out.print(" ");
            }
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
        System.out.print('\\'+"_");
        System.out.print('\n');
        for (int line = 6; line >0; line -=2)
        {
            for (int b =-1; b<(7-line); b++)
            {
                System.out.print(" ");
            }
            System.out.print('\\'+"_");
            System.out.print('\n');
        }
    }
}

/*
Varun Sureka
xx/xx/xx
Java Period 2
*/
import java.util.Scanner;
public class testStuff
{
    public static void main(String[] args)
    {
        Scanner charScan = new Scanner(System.in);
        String StringNum;
        System.out.println("Enter a single character");
        StringNum = charScan.next();
        char c = StringNum.charAt(0);

        if (Character.isAlphabetic(c))
        {
            System.out.print("true");
        }
        else
        {
            System.out.print("false");
        }
    }
}
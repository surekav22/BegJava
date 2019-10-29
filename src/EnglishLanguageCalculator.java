/*
Varun Sureka
10/28/19
Java Period 2
*/
import java.util.Scanner;
public class EnglishLanguageCalculator
{
    public static void main (String[] args)
    {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter the first number");
        int number1 = scan.nextInt();

        System.out.println("Enter the operator");
        String x = scan.next();
        char operator = x.charAt(0);

        System.out.println("Enter the second number");
        int number2 = scan.nextInt();

        String a = NumberSwitch(number1);
        String b = OperatorSwitch(operator);
        String c = NumberSwitch(number2);
        String d = MathThing(operator, number1, number2);

        System.out.println(a+b+c.toLowerCase()+"is "+ d);
//        System.out.println(b);
    }

    private static String NumberSwitch (int number)
    {
        switch (number)
        {
            case 0:
                String string = "Zero ";
                return string;
            case 1 :
                string = "One ";
                return string;
            case 2 :
                string = "Two ";
                return string;
            case 3:
                 string = "Three ";
                return string;
            case 4:
                 string = "Four ";
                return string;
            case 5 :
                string = "Five ";
                return string;
            case 6:
                string = "Six ";
                return string;
            case 7:
                 string = "Seven ";
                return string;
            case 8:
                string = "night ";
                return string;
            case 9:
                string = "Nine ";
                return string;
        }
        return null;
    }

    private static String OperatorSwitch (char x)
    {
        switch (x)
        {
            case '+':
                String string2 = "plus ";
                return string2;
            case '-':
                string2 = "minus ";
                return string2;
            case 'x':
                string2 = "multiplied by ";
                return string2;
            case '/':
                 string2 = "divided by ";
                 return string2;
            case '^':
                string2 = "to the power of ";
                return string2;
            default:
                return null;
        }
    }

    public static String MathThing (char x, int number1, int number2)
    {
        switch (x)
        {
            case '+':
                return Integer.toString(number1 + number2);
            case '-':
                return Integer.toString(Math.abs(number1 - number2));
            case 'x':
                return Integer.toString(number1 * number2);
            case '/':
                return Integer.toString(number1 / number2);
            case '^':
                double a = number1;
                double b = number2;
                double c = (Math.pow(a, b));
                return Double.toString(c);
            default:
                return null;
        }
    }

}

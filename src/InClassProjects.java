/*
Varun Sureka
10/2/19
Java Period 2
*/
import java.util.Scanner;
import java.util.Random;
import javax.swing.JOptionPane;
import java.text.DecimalFormat;

public class InClassProjects
{
    public static void main(String[] args)
    {
        FirstProblem();
        SecondProblem();
        ThirdProblem();

    }

    public static void FirstProblem()
    {
    // Page 147, Activity 2
    /*
    Ask for first name
    Print hello message
    Print number of chars in name
    Ask for birthday
    print age user will be this year
    print percentage of life that the user has lived (Avg. Life expectancy = 78.94)
    generate a random message and have the user guess three times
    */
        Scanner name = new Scanner(System.in);
        String FirstName;
        System.out.println("Enter your first name >"); //asks for name
        FirstName = name.next();
        System.out.println("Hello " + FirstName); //Prints hello message
        System.out.println("Your name has " + FirstName.length() + " characters"); //Number of characters in name

        System.out.print('\n');

        Scanner bDay = new Scanner(System.in); //Ask for Birthday
        System.out.println("In what year were you born");
        int bDayYear = bDay.nextInt();
        int age = 2019 - bDayYear;
        System.out.println("This year, you will be  " + age + " years old"); //Prints age
        double PercentLife = age/78.94 *100; //calculates percentage of lived life
        System.out.print("So far, you have lived ");
        System.out.printf("%.1f",PercentLife);
        System.out.print("% of your expected life span");

        System.out.print('\n');

        // Part 3
        Random random = new Random();
        System.out.println("I'm thinking of a number between 1 and 20 ");

        int randomNum = random.nextInt(20)+1;

        for (int x = 0; x<3; x++)
        {
            String guess = JOptionPane.showInputDialog( null, "Can you guess what number I'm thinking of?");
            int NumbGuess = Integer.parseInt(guess);
            if (NumbGuess != randomNum)
            {
                JOptionPane.showMessageDialog(null,"That's not the right answer!");
            }
            else if (NumbGuess == randomNum)
            {
                JOptionPane.showMessageDialog(null,"That's the right answer!");
            }
        }
        JOptionPane.showMessageDialog(null,"The correct number is " + randomNum);
    }

    public static void SecondProblem()
    /*
    Ask the user to input a sequence.
    Ask the User for a key onb how long the random stuff should be
    input that many random characters and then the first character of the sequence.
    repeat for the entire sequence using 2 for loops. One of them has to be the length of the string. the other is the length of the code.
    */
    {
        Random random = new Random();
        Scanner a = new Scanner(System.in); //Asks for the sequence
        System.out.println("Enter a string that you want to encrypt");
        String inputString = a.nextLine();

        System.out.println("enter a key"); //Asks for the key
        int key = a.nextInt();

        int LengthOfString = inputString.length();

        String printString = "";
        for (int x = 0; x < LengthOfString; x++) //For the characters of the inputted string
        {
            for (int y =0; y < key; y++) //For the encryption
            {
                int rand =random.nextInt(94)+33;
                char RandomChar = (char)rand;
                printString = printString + (RandomChar);
            }
            printString = printString + (inputString.charAt(x));
        }
        System.out.println(printString); //Prints the final string
    }

    public static void ThirdProblem()
    {
        /*
        Ask for the mortgage rate
        Ask for number of years
        Ask for mortgage amount from bank
        Calculate monthly payment using formulas
        Output the summary
        */
        Scanner mortgage = new Scanner(System.in);

        System.out.println("Enter a double for the annual interest rate ");
        double interestRate = mortgage.nextDouble();

        System.out.println("How long will the mortgage be held for?");
        int nOY = mortgage.nextInt();

        System.out.println("How much money did you loan from the bank?");
        int M = mortgage.nextInt();

        double mIR = interestRate/12; //Monthly interest rate

        double MonthlyPayment = (mIR*M) / (1 - (1 / Math.pow(1 + mIR, 12*nOY))); //Formula for monthly payment
        double TotalPayment = MonthlyPayment*12*nOY;

        DecimalFormat df = new DecimalFormat("##.##%"); //Annual interest rate in percent notation
        String formatInterestRate = df.format(interestRate);
        System.out.println("The annual interest rate is " + formatInterestRate);

        System.out.println("The mortgage amount is $" + M); //Mortgage amount

        //Monthly payment
        DecimalFormat af = new DecimalFormat("$##.##");
        String formatMonthlyPayment = af.format(MonthlyPayment);
        System.out.println("The monthly payment is " + formatMonthlyPayment);

        //total payment over the years
        String formatTotalPayment = af.format(TotalPayment);
        System.out.println("The total payment is " + formatTotalPayment);

        //Over Payment
        double OverPayment = TotalPayment-M;
        String formatOverPayment = af.format(OverPayment);
        System.out.println("The over payment is " + formatOverPayment);

        //Over Payment Percentage
        System.out.printf("The over payment as a percentage is %.2f", (OverPayment/M)*100);
        System.out.print("%");
    }
}
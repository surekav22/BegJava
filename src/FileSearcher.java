/*
Varun Sureka
xx/xx/xx
Java Period 2
*/

import java.io.File;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class FileSearcher
{
    public static void main(String[] args) throws IOException
    {
        File inputFile = new File("/Users/varun/IdeaProjects/BegJava/src/InputFile");
        Scanner fileScan = new Scanner(inputFile);

        int count = 0;
        int doubleCount = 0;
        int wordCount = 0;
        int floatCount = 0;
        while (fileScan.hasNext())
        {
            String lines = fileScan.nextLine();
            Scanner line = new Scanner(lines);

            while (line.hasNext())
            {
                if (line.hasNextInt())
                {
                    int word = line.nextInt();
                    count++;
                }
                else if (line.hasNextDouble())
                {
                    double word = line.nextDouble();
                    doubleCount++;
                }
                else if(line.hasNextFloat())
                {
                    float word = line.nextFloat();
                    floatCount++;
                }
                else if (line.hasNext())
                {
                    String word = line.next();
                    wordCount++;
                }
            }
        }
        System.out.println("There are " + count + " integers");
        System.out.println("There are " + doubleCount + " doubles");
        System.out.println("There are " + floatCount + " floats");
        System.out.println("There are " + wordCount + " words");
    }
}

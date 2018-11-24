/*
name: Woohyeon Baek
student number: 2017-15782
*/

import java.util.*;
import java.io.*;

public class Midterm3 {

    public static void main(String[] args) throws FileNotFoundException {

        Scanner input = new Scanner(new File(args[0]));
        PrintStream output = new PrintStream(new File(args[1]));

        Vector<String> Str = new Vector<String>();
        int Num = 0, Sum = 0, Above = 0;
        double Avg;

        while(input.hasNext()) {
            String Line = input.next();
            Line=Line.replace(',',' ');
            Line=Line.replace('.',' ');

            Scanner scan = new Scanner(Line);

            while(scan.hasNext()) {
                String t = scan.next();
                Num++;
                Sum += t.length();
                Str.add(t);
            }
        }

        Avg = (double)Sum / Num;

        for(int i = 0 ; i < Num ; i++) {
            int t = Str.elementAt(i).length();
            if(t > Avg)
                Above++;
        }

        output.println("Number of words = " + Num);
        output.printf("Average length of a word = %.2f\n",Avg);
        output.println("Number of words above the average length = " + Above);
    }
}

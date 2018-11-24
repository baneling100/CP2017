/*
name: Woohyeon Baek
student number: 2017-15782
*/

import java.util.*;
import java.io.*;

public class Midterm1 {

    public static void main(String[] args) throws FileNotFoundException {

        Scanner input = new Scanner(new File(args[0]));
        PrintStream output = new PrintStream(new File(args[1]));

        int N = input.nextInt();
        int[] X = new int[N + 1];
        int[] Y = new int[N + 1];
        for(int i = 1 ; i <= N ; i++) {
            X[i] = input.nextInt();
            Y[i] = input.nextInt();
        }
        int[][] Far = new int[N * N + 1][2];
        int[][] Close = new int[N * N + 1][2];
        int TopF = 0, TopC = 0, max = -1, min = 0x7fffffff;

        for(int i = 1 ; i <= N - 1 ; i++)
            for(int j = i + 1 ; j <= N ; j++) {
                int t = (X[i] - X[j]) * (X[i] - X[j]) + (Y[i] - Y[j]) * (Y[i] - Y[j]);
                if(max < t) {
                    max = t;
                    TopF = 1;
                    Far[1][0] = i;
                    Far[1][1] = j;
                }
                else if(max == t) {
                    TopF++;
                    Far[TopF][0] = i;
                    Far[TopF][1] = j;
                }
                if(min > t) {
                    min = t;
                    TopC = 1;
                    Close[1][0] = i;
                    Close[1][1] = j;
                }
                else if(min == t) {
                    TopC++;
                    Close[TopC][0] = i;
                    Close[TopC][1] = j;
                }
            }
        output.println("The farthest pair is:");
        for(int i = 1 ; i <= TopF ; i++)
            output.println("(" + X[Far[i][0]] + ", " + Y[Far[i][0]] + "), (" + X[Far[i][1]] + ", " + Y[Far[i][1]] + ")");
        output.println("The closest pairs are:");
        for(int i = 1 ; i <= TopC ; i++)
            output.println("(" + X[Close[i][0]] + ", " + Y[Close[i][0]] + "), (" + X[Close[i][1]] + ", " + Y[Close[i][1]] + ")");
    }
}

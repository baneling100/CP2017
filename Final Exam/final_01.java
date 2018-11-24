// name: Woohyeon Baek
// student number: 2017-15782

import java.io.*;
import java.util.*;

public class final_01 {

    private static int N;
    private static int[] arrSize;
    private static int[][] arr;

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(new File(args[0]));
        PrintStream print = new PrintStream(new File(args[1]));

        N = scan.nextInt();

        arrSize = new int[N];
        for(int i = 0; i < N; i++)
            arrSize[i] = scan.nextInt();

        int M = arrSize[0];
        for(int i = 1; i < N; i++)
            if(M < arrSize[i]) M = arrSize[i];

        arr = new int[N][2 * M];
        for(int i = 0; i < N; i++)
            for(int j = 0; j < arrSize[i]; j++)
                arr[i][j + arrSize[i]] = arr[i][j] = scan.nextInt();

        int cnt = 0;
        for(int i = 0; i < N - 1; i++)
            for(int j = i + 1; j < N; j++)
                if(isEqual(i,j)) cnt++;

        print.println(cnt);
    }

    private static boolean isEqual(int x, int y) {
        if(arrSize[x] != arrSize[y]) return false;
        for(int i = 0; i < arrSize[x]; i++) {
            int j;
            for(j = i; j < i + arrSize[x]; j++) {
                if(arr[x][j - i] != arr[y][j]) break;
            }
            if(j == i + arrSize[x]) return true;
        }
        return false;
    }
}

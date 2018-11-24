/*
Woohyeon Baek
2017-15782
 */

import java.util.Scanner;

public class Assignment1_1 {

    static int N;

    public static void main(String[] args) {

        int i, j, k, cnt;
        boolean first;

        Scanner scan = new Scanner(System.in);
        System.out.print("Input:");
        N = scan.nextInt();

        System.out.println("(i)");
        cnt = (N - 1) / 2;
        while(true) {
            for(i = 1 ; i <= cnt ; i++)
                System.out.print(' ');
            for(j = 1 ; j <= N - 2 * (i - 1) ; j++)
                System.out.print('*');
            System.out.println();
            if(cnt <= 0)
                break;
            cnt -= 2;
        }
        if((N + 6) / 9 == 0)
            cnt -= 2;
        first = true;
        for(i = 1 ; i <= (N + 6) / 9 || first ; i++) {
            cnt += 2;
            for(j = 1 ; j <= cnt ; j++)
                System.out.print(' ');
            for(k = 1 ; k <= N - 2 * (j - 1) ; k++)
                System.out.print('*');
            System.out.println();
            first = false;
        }
        cnt -= 2;
        if((N + 6) / 9 == 0)
            cnt += 2;
        for(i = 1 ; i < (N + 6) / 9 ; i++) {
            for(j = 1 ; j <= cnt ; j++)
                System.out.print(' ');
            for(k = 1 ; k <= N - 2 * (j - 1) ; k++)
                System.out.print('*');
            System.out.println();
            cnt -= 2;
        }
        while(true) {
            for(i = 1 ; i <= cnt ; i++)
                System.out.print(' ');
            for(j = 1 ; j <= N - 2 * (i - 1) ; j++)
                System.out.print('*');
            System.out.println();
            if(cnt == (N - 1) / 2)
                break;
            cnt += 2;
        }

        System.out.println("(ii)");
        cnt = (N - 1) / 2;
            while(true) {
            for(i = 1 ; i <= cnt ; i++)
                System.out.print(' ');
            System.out.print('*');
            if(N - 2 * (i - 1) >= 2) {
                for(j = 1 ; j <= N - 2 * i ; j++)
                    System.out.print(' ');
                System.out.print('*');
            }
            System.out.println();
            if(cnt <= 0)
                break;
            cnt -= 2;
        }
        if((N + 6) / 9 == 0)
            cnt -= 2;
        first = true;
        for(i = 1 ; i <= (N + 6) / 9 || first ; i++) {
            cnt += 2;
            for(j = 1 ; j <= cnt ; j++)
                System.out.print(' ');
            System.out.print('*');
            if(N - 2 * (j - 1) >= 2) {
                for(k = 1 ; k <= N - 2 * j ; k++)
                    System.out.print(' ');
                System.out.print('*');
            }
            System.out.println();
            first = false;
        }
        cnt -= 2;
        if((N + 6) / 9 == 0)
            cnt += 2;
        for(i = 1 ; i < (N + 6) / 9 ; i++) {
            for(j = 1 ; j <= cnt ; j++)
                System.out.print(' ');
            System.out.print('*');
            if(N - 2 * (j - 1) >= 2) {
                for(k = 1 ; k <= N - 2 * j ; k++)
                    System.out.print(' ');
                System.out.print('*');
            }
            System.out.println();
            cnt -= 2;
        }
        while(true) {
            for(i = 1 ; i <= cnt ; i++)
                System.out.print(' ');
            System.out.print('*');
            if(N - 2 * (i - 1) >= 2) {
                for(j = 1 ; j <= N - 2 * i ; j++)
                    System.out.print(' ');
                System.out.print('*');
            }
            System.out.println();
            if(cnt == (N - 1) / 2)
                break;
            cnt += 2;
        }
    }
}

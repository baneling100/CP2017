/*
Name: Woohyeon Baek
Student number: 2017-15782
*/

import java.util.Random;

public class Assignment2_2 {

    public static void main(String[] args) {

        Random rand = new Random();
        int[][] card = new int[5][11];
        boolean[] check = new boolean[52];
        String suit = "HDCS";
        String[] value = {"A ","2 ","3 ","4 ","5 ","6 ","7 ","8 ","9 ","10","J ","Q ","K "};
        int[] score = new int[5];

        // distribute
        for(int i = 1 ; i <= 10 ; i++)
            for(int j = 1 ; j <= 4 ; j++) {
                int k = rand.nextInt(52);
                while(check[k])
                    k = rand.nextInt(52);
                check[k] = true;
                card[j][i] = k;
            }

        // print players' cards
        for(int i = 1 ; i <= 4 ; i++) {
            System.out.print("Player " + i + " : ");
            for(int j = 1 ; j <= 10 ; j++)
                System.out.print(suit.charAt(card[i][j] / 13) + value[card[i][j] % 13] + ' ');
            System.out.println();
        }
        System.out.println();

        // calculate score
        card[4][0] = card[1][1] + 14;
        for(int i = 1 ; i <= 10 ; i++) {
            card[0][i] = card[4][i-1];
            for(int j = 1 ; j <= 4 ; j++) {
                System.out.print(suit.charAt(card[j][i] / 13) + value[card[j][i] % 13] + ' ');
                if(card[j][i] / 13 == card[j - 1][i] / 13)
                    score[j] += 4;
                if(card[j][i] % 13 == card[j - 1][i] % 13)
                    score[j] += 13;
            }
            System.out.println();
        }

        // print score
        for(int i = 1 ; i <= 4 ; i++)
            System.out.println("Player " + i + " score : " + score[i]);
    }
}

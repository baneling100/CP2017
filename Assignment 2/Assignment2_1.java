/*
Name: Woohyeon Baek
Student number: 2017-15782
*/

import java.util.Scanner;

public class Assignment2_1 {

    public static void main(String[] args) {

        // input
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter string : ");
        String text = scan.nextLine();
        System.out.print("Enter operation : ");
        char oper = scan.nextLine().charAt(0);
        System.out.print("Enter key value : ");
        int key = scan.nextInt();

        // range check
        for(int i = 0 ; i < text.length() ; i++) {
            char t = text.charAt(i);
            if(!(('a' <= t && t <= 'z') || ('A' <= t && t <= 'Z') || ('1' <= t && t <= '9'))) {
                System.out.println("Error, input value " + t + " is out of range");
                return;
            }
        }

        // output
        String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ123456789";
        for(int i = 0 ; i < text.length() ; i++) {
            char t = text.charAt(i);
            int k;
            if('a' <= t && t <= 'z')
                k = t - 'a';
            else if('A' <= t && t <= 'Z')
                k = t - 'A' + 26;
            else // '1' <= t && t <= '9'
                k = t - '1' + 52;
            if(oper == 'e')
                System.out.print(str.charAt((k + key + 122) % 61));
            else // oper == 'd'
                System.out.print(str.charAt((k - key + 122) % 61));
        }
    }
}

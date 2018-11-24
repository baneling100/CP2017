/*
name: Woohyeon Baek
student number: 2017-15782
*/

public class Midterm2 {

    public static void main(String[] args) {

        for(int i = args[0].length() ; i >= 1 ; i--)
            for(int j = 0 ; j <= args[0].length() - i ; j++)
                if(args[1].contains(args[0].substring(j,j + i))) {
                    System.out.println(args[0].substring(j,j + i));
                    return;
                }
    }
}

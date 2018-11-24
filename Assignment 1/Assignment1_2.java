/*
Woohyeon Baek
2017-15782
 */

import java.util.Scanner;

public class Assignment1_2 {

    static int H, M, S;
    static double Hdeg, Mdeg, Sdeg, SH, MS, HM;

    public static void main(String[] args) {

        System.out.print("Input time: ");
        Scanner scan = new Scanner(System.in);
        H = scan.nextInt();

        S = H % 100;
        H /= 100;
        M = H % 100;
        H /= 100;
        if(H >= 12) H -= 12;

        Hdeg = 30 * H + 0.5 * M + S / 120.0;
        Mdeg = 6 * M + 0.1 * S;
        Sdeg = 6 * S;

        SH = Sdeg - Hdeg;
        if(SH < 0) SH += 360;
        if(SH > 180) SH = 360 - SH;

        MS = Mdeg - Sdeg;
        if(MS < 0) MS += 360;
        if(MS > 180) MS = 360 - MS;

        HM = Hdeg - Mdeg;
        if(HM < 0) HM += 360;
        if(HM > 180) HM = 360 - HM;

        SH = Math.round(SH * 100) / 100.0;
        MS = Math.round(MS * 100) / 100.0;
        HM = Math.round(HM * 100) / 100.0;

        System.out.println("<Result>");
        if(HM >= MS && HM >= SH) {
            System.out.println("Hour-minute: " + HM + " degrees");
            if(MS >= SH) {
                System.out.println("Minute-second: " + MS + " degrees");
                System.out.println("Second-hour: " + SH + " degrees");
            }
            else {
                System.out.println("Second-hour: " + SH + " degrees");
                System.out.println("Minute-second: " + MS + " degrees");
            }
        }
        else if(MS >= HM && MS >= SH) {
            System.out.println("Minute-second: " + MS + " degrees");
            if(HM >= SH) {
                System.out.println("Hour-minute: " + HM + " degrees");
                System.out.println("Second-hour: " + SH + " degrees");
            }
            else {
                System.out.println("Second-hour: " + SH + " degrees");
                System.out.println("Hour-minute: " + HM + " degrees");
            }
        }
        else {
            System.out.println("Second-hour: " + SH + " degrees");
            if(HM >= MS) {
                System.out.println("Hour-minute: " + HM + " degrees");
                System.out.println("Minute-second: " + MS + " degrees");
            }
            else {
                System.out.println("Minute-second: " + MS + " degrees");
                System.out.println("Hour-minute: " + HM + " degrees");
            }
        }
    }
}

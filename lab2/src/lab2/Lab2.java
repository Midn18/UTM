package lab2;

import java.io.IOException;
import static java.lang.Math.sqrt;

public class Lab2 {

    public static double gama = 0.5;
    public static double eps = Math.pow(10, -6);
    public static double delta = 0.06;
    public static double a = 5;
    public static double b = 6;

    public static double funct;

    public static void main(String[] args) throws IOException {

        double lambda = 1;

        double x = a;
        double y = b;
        aMinim(a, b);

    }

    public static double functia(double x, double y) throws IOException {

        double funct;

        return funct = 5 * Math.pow(x, 2) + 3 * x * y + 6 * Math.pow(y, 2) - 5 * x - 6 * y;
    }

    public static double derivX(double x, double y) throws IOException {

        double derX;

        return derX = 10 * x + 3 * y - 5;
    }

    public static double derivXX() {

        return 10;
    }

    public static double derivXY() {

        return 3;
    }

    public static double derivY(double x, double y) throws IOException {

        double derY;

        return derY = 3 * x + 12 * y - 6;
    }

    public static double derivYX() {

        return 3;
    }

    public static double derivYY() {

        return 12;
    }

    public static double magnitude(double x, double y) throws IOException {

        double mag;

        return mag = sqrt(Math.pow(derivX(x, y), 2) + Math.pow(derivY(x, y), 2));
    }

    public static void aMinim(double n1, double n2) throws IOException {

        double x = n1;
        double y = n2;
        double alpha = 1;
        int k = 0;

        double fx = functia(x, y);

        double mag = magnitude(x, y);

        double devx = derivX(x, y);
        double devy = derivY(x, y);

        double dx = -devx;
        double dy = -devy;
        
        

        while (devx != 0 && devy != 0) {

            alpha = -((devx * dx + devy * dy)
                    / ((derivXX() * dx + derivXY() * dy) * dx
                    + ((derivYX() * dx + derivYY() * dy) * dy)));

            System.out.println("k = " + k + "\t x = " + x + " \t y = " + y + "\t alpha = " + alpha+"\t\t derivata x =  "+devx+"\t derivata y = "+devy+ "\t fx=" + fx);
            k++;

            x = x + alpha * dx;
            y = y + alpha * dy;

            fx = functia(x, y);
            devx = derivX(x, y);
            devy = derivY(x, y);
            
            
            dx = -devx + (Math.pow(magnitude(x, y), 2) / Math.pow(mag, 2)) * dx;
            dy = -devy + (Math.pow(magnitude(x, y), 2) / Math.pow(mag, 2)) * dy;

        }
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------"
                + "-----------------");
        System.out.println("k = " + k + "\t x = " + x + "  \t y = " + y + "\t alpha = " + alpha+"\t derivata x =  "+devx+" \tderivata y = "+devy+ "\t fx=" + fx);

    }

}

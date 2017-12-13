package calculator;

public class Arithmetic {
    public static int arrayMultiplication(int ar[]) {

        int mult = 1;
        for (int anAr : ar) {
            mult *= anAr;
        }
        return mult;
    }

    public static double power(int x, int y) {
        return Math.pow(x, y);
    }

    public static double division(int x, int y) {
        try {
            return (double)x / y;
        } catch (ArithmeticException e) {
            System.out.println("Ошибка! Деление на 0");
        }
        return 0;
    }

    public static double root(double x) {
        return Math.sqrt(x);
    }
}

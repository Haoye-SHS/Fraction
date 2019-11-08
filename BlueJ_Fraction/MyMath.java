/**
 * this is a math class whose sole purpose is to calculate the greatest common factor of two input integers
 *
 * @author Haoye
 * @version 1573186958
 */

public class MyMath {
    /**
     * @param a is the first integer input
     * @param b is teh second integer input
     * @return the gcf of input a and b
     */
    public static int gcf(int a, int b) {
        if (a == 0) return Math.abs(b);
        if (b == 0) return Math.abs(a);
        a = Math.abs(a);
        b = Math.abs(b);
        while (a != b) {
            if (a > b) {
                a = a - b;
            } else {
                b = b - a;
            }
        }
        return a;
    }
}

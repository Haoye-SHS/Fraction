/**
 * Represents a fraction
 *
 * @author Haoye
 * @version 1571854271
 */

public class Fraction {
    private int numerator;
    private int denominator;
    private Fraction result;

    public Fraction() {
        numerator = 0;
        denominator = 1;
    }

    public Fraction(int numeratorIn, int denominatorIn) {
        numerator = numeratorIn;
        denominator = denominatorIn;
        reduce();
    }

    public Fraction(Fraction fractionIn) {
        numerator = fractionIn.numerator;
        denominator = fractionIn.numerator;
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setNumerator(int newNumerator) {
        numerator = newNumerator;
        reduce();
    }

    public void setDenominator(int newDenominator) {
        denominator = newDenominator;
        reduce();
    }

    public Fraction add(int factor) {
        result = new Fraction(numerator + (factor * denominator), denominator);
        return result;
    }

    public Fraction add(Fraction fractionIn) {
        if (denominator == fractionIn.denominator) {
            result = new Fraction(numerator + fractionIn.numerator, denominator);
        } else {
            result = new Fraction(numerator * fractionIn.denominator + fractionIn.numerator * denominator, denominator * fractionIn.denominator);
        }
        return result;
    }

    public Fraction subtract(int factor) {
        result = new Fraction(numerator - (factor * denominator), denominator);
        return result;
    }

    public Fraction subtract(Fraction fractionIn) {
        if (denominator == fractionIn.denominator) {
            result = new Fraction(numerator - fractionIn.numerator, denominator);
        } else {
            result = new Fraction(numerator * fractionIn.denominator - fractionIn.numerator * denominator, denominator * fractionIn.denominator);
        }
        return result;
    }

    public Fraction multiply(int factor) {
        result = new Fraction(numerator * factor, denominator);
        return result;
    }

    public Fraction multiply(Fraction fractionIn) {
        result = new Fraction(numerator * fractionIn.numerator, denominator * fractionIn.denominator);
        return result;
    }

    public Fraction divide(int factor) {
        result = new Fraction(numerator, denominator * factor);
        return result;
    }

    public Fraction divide(Fraction fractionIn) {
        result = new Fraction(numerator * fractionIn.denominator, denominator * fractionIn.numerator);
        return result;
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }

    public double getValue() {
        return (double)numerator/denominator;
    }

    private void reduce() {
        int gcf = MyMath.gcf(numerator, denominator);
        numerator = numerator/gcf;
        denominator = denominator/gcf;
    }
}

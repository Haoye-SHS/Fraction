/**
 * Represents a fraction
 * Allow construction of Fraction type object consisting of a numerator and a denominator
 * Allow operation such as addition, subtraction, multiplication, and division to be performed upon fraction objects
 * Any fraction project will be reduced to the simplest form
 * Allow the conversion to String value to print out the fraction
 * Allow obtaining the decimal value of the fraction
 *
 * @author Haoye
 * @version 1573186958
 */

public class Fraction {
    private int numerator;
    private int denominator;

    /**
     * no parameter constructor of a fraction, initializes default 0/1 fraction
     */
    public Fraction() {
        numerator = 0;
        denominator = 1;
    }

    /**
     * two int input fraction constructor
     * @param numeratorIn is the numerator value for the new Fraction object
     * @param denominatorIn is the denominator value for the new Fraction object
     */
    public Fraction(int numeratorIn, int denominatorIn) {
        numerator = numeratorIn;
        denominator = denominatorIn;
        reduce();
    }

    /**
    fraction object cloner
    @param fractionIn is the fraction to clone
     */
    public Fraction(Fraction fractionIn) {
        numerator = fractionIn.numerator;
        denominator = fractionIn.denominator;
    }

    /**
     * returns the numerator of the fraction object
     * @return numerator of the fraction object
     */
    public int getNumerator() {
        return numerator;
    }

    /**
     * returns the denominator of the fraction object
     * @return denominator of the fraction object
     */
    public int getDenominator() {
        return denominator;
    }

    /**
     * set numerator of the fraction object
     * @param newNumerator is the new numerator to set for the fraction object
     */
    public void setNumerator(int newNumerator) {
        numerator = newNumerator;
        reduce();
    }

    /**
     * set denominator of the fraction object
     * @param newDenominator is the new numerator to set for the fraction object
     */
    public void setDenominator(int newDenominator) {
        denominator = newDenominator;
        reduce();
    }

    /**
     * method to add an integer to the fraction object, does not modify field values but returns a new Fraction object
     * @param factor is the integer to add
     * @return resulting fraction
     */
    public Fraction add(int factor) {
        Fraction result = new Fraction(numerator + (factor * denominator), denominator);
        return result;
    }

    /**
     * method to add another fraction to the fraction object, does not modify field values but returns a new Fraction object
     * @param fractionIn is the fraction to add
     * @return resulting fraction
     */
    public Fraction add(Fraction fractionIn) {
        Fraction result = new Fraction();
        if (denominator == fractionIn.denominator) {
            result = new Fraction(numerator + fractionIn.numerator, denominator);
        } else {
            result = new Fraction(numerator * fractionIn.denominator + fractionIn.numerator * denominator, denominator * fractionIn.denominator);
        }
        return result;
    }

    /**
     * method to subtract an integer from the fraction object, does not modify field values but returns a new Fraction object
     * @param factor is the integer to subtract
     * @return resulting fraction
     */
    public Fraction subtract(int factor) {
        Fraction result = new Fraction(numerator - (factor * denominator), denominator);
        return result;
    }

    /**
     * method to subtract another fraction from the fraction object, does not modify field values but returns a new Fraction object
     * @param fractionIn is the fraction to subtract
     * @return resulting fraction
     */
    public Fraction subtract(Fraction fractionIn) {
        Fraction result = new Fraction();
        if (denominator == fractionIn.denominator) {
            result = new Fraction(numerator - fractionIn.numerator, denominator);
        } else {
            result = new Fraction(numerator * fractionIn.denominator - fractionIn.numerator * denominator, denominator * fractionIn.denominator);
        }
        return result;
    }

    /**
     * method to multiply the fraction by an integer, does not modify field values but returns a new Fraction object
     * @param factor is the integer to multiply by
     * @return resulting fraction
     */
    public Fraction multiply(int factor) {
        Fraction result = new Fraction(numerator * factor, denominator);
        return result;
    }

    /**
     * method to multiply the fraction by another fraction, does not modify field values but returns a new Fraction object
     * @param fractionIn is the fraction to multiply by
     * @return resulting fraction
     */
    public Fraction multiply(Fraction fractionIn) {
        Fraction result = new Fraction(numerator * fractionIn.numerator, denominator * fractionIn.denominator);
        return result;
    }

    /**
     * method to divide the fraction by an integer, does not modify field values but returns a new Fraction object
     * @param factor is the integer to divide by
     * @return resulting fraction
     */
    public Fraction divide(int factor) {
        Fraction result = new Fraction(numerator, denominator * factor);
        return result;
    }

    /**
    method to divide the fraction by another fraction, does not modify field values but returns a new Fraction object
    @param fractionIn is the fraction to divide by
    @return resulting fraction
     */
    public Fraction divide(Fraction fractionIn) {
        Fraction result = new Fraction(numerator * fractionIn.denominator, denominator * fractionIn.numerator);
        return result;
    }

    /**
     * overridden toString method to convert fraction value into printable text
     * @return the printable String value of the fraction
     */
    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }

    /**
     * method to return decimal value of the fraction object
     * @return type double decimal value of fraction object
     */
    public double getValue() {
        return (double)numerator/denominator;
    }

    /**
     * method to simplify the fraction object
     * @return fraction in simplest form
     */
    private void reduce() {
        if (numerator != 0 && denominator != 0) {
            int gcf = MyMath.gcf(numerator, denominator);
            numerator = numerator / gcf;
            denominator = denominator / gcf;
        }
        if (numerator < 0 && denominator < 0) {
            numerator = 0 - numerator;
            denominator = 0 - denominator;
        }
    }
}

import java.util.Scanner;

public class UsesFraction {
    private static int numerator;
    private static int denominator;
    private static int number;
    private static char character;

    public static void main(String[] arg) {
        System.out.println("Hi, Soyboy!");

        System.out.println("Would you like to perform aliasFun()? (Y/N)");
        takeInput("char");
        if (character == 'y') {
            aliasFun();
            return;
        }

        takeInput("frac");
        Fraction f = new Fraction(numerator, denominator);

        System.out.println("Would you like to perform operations on your fraction? (Y/N)");
        takeInput("char");
        if (character == 'y') {
            System.out.println("Would you like to perform what operation? (Add/Subtract/Multiplication/Division)");
            takeInput("char");
            Fraction result = null;
            switch (character) {
                case 'a':
                    System.out.println("Would you like to add an integer or a fraction? (I/F)");
                    takeInput("char");
                    if (character == 'i') {
                        System.out.println("How much would you like to add?");
                        takeInput("int");
                        result = f.add(number);
                    } else {
                        takeInput("frac");
                        Fraction o = new Fraction(numerator, denominator);
                        result = f.add(o);
                    }
                    break;
                case 's':
                    System.out.println("Would you like to subtract an integer or a fraction? (I/F)");
                    takeInput("char");
                    if (character == 'i') {
                        System.out.println("How much would you like to subtract?");
                        takeInput("int");
                        result = f.subtract(number);
                    } else {
                        takeInput("frac");
                        Fraction o = new Fraction(numerator, denominator);
                        result = f.subtract(o);
                    }
                    break;
                case 'm':
                    System.out.println("Would you like to multiply by an integer or a fraction? (I/F)");
                    takeInput("char");
                    if (character == 'i') {
                        System.out.println("By what factor would you like to multiply?");
                        takeInput("int");
                        result = f.multiply(number);
                    } else {
                        takeInput("frac");
                        Fraction o = new Fraction(numerator, denominator);
                        result = f.multiply(o);
                    }
                    break;
                case 'd':
                    System.out.println("Would you like to divide by an integer or a fraction? (I/F)");
                    takeInput("char");
                    if (character == 'i') {
                        System.out.println("By what factor would you like to divide?");
                        takeInput("int");
                        result = f.divide(number);
                    } else {
                        takeInput("frac");
                        Fraction o = new Fraction(numerator, denominator);
                        result = f.divide(o);
                    }
                    break;
            }
            System.out.println("Your final fraction is " + result.toString());
            System.out.println("And its " + result.getValue() + " represented in decimal");
        } else {
            System.out.println("Your final fraction is " + f.toString());
            System.out.println("And its " + f.getValue() + " represented in decimal");
        }
    }

    public static void aliasFun () {
        Fraction f = new Fraction(2, 3);
        System.out.println(f.toString());
        Fraction result1 = f.multiply(7);
        Fraction result2 = new Fraction(result1);
        System.out.println(result1);
        System.out.println(result2);
        result1.setNumerator(11);
        System.out.println(result1);
        System.out.println(result2);
    }

    public static void takeInput(String type) {
        if (type == "frac") {
            Scanner numeratorToSet = new Scanner(System.in);
            Scanner denominatorToSet = new Scanner(System.in);

            System.out.print("Set your numerator: ");
            numerator = numeratorToSet.nextInt();
            System.out.print("Set your denominator: ");
            denominator = denominatorToSet.nextInt();
        }
        if (type == "int") {
            Scanner factorToSet = new Scanner(System.in);
            number = factorToSet.nextInt();
        }
        if (type == "char") {
            Scanner initialCap = new Scanner(System.in);
            character = initialCap.next().charAt(0);
        }
    }
}

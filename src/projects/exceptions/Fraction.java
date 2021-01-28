package projects.exceptions;
/**
 * Fraction class, including the ability to represent improper fractions
 * as mixed numbers.
 *
 * Activity - add exception handling.
 *
 * @author Wade Huber
 *
 */
public class Fraction {

    private int numerator;
    private int denominator;

    /**
     * Class constructor - default to 1
     */
    Fraction() {
        numerator = 1;
        denominator= 1;
    }

    /**
     * Class constructor specifying values for numerator & denominator
     *
     * @param numerator   numerator of fraction
     * @param denominator denominator of fraction
     */
    Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator= denominator;
    }

    /**
     * @return numerator the numerator of the fraction
     */
    public int getNumerator() {
        return numerator;
    }

    /**
     * @param numerator the numerator of the fraction
     */
    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    /**
     * @return denominator the denominator of the fraction
     */
    public int getDenominator() {
        return denominator;
    }

    /**
     * @param denominator the denominator of the fraction
     */
    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }

    /**
     * Generate a string representing the fraction in mixed number format.
     *
     * @return string representation of the fraction as a mixed number
     */
    public String toMixedNumber ()
    {
        String ret = "";
        int remainder = numerator %  denominator;

        ret += numerator /  denominator;
        ret += " ";
        if (remainder != 0) {
            ret += Math.abs(numerator %  denominator);
            ret += "/";
            ret += Math.abs(denominator);
        }

        return ret;
    }

    /**
     * @return string representation of the fraction as a mixed number
     */
    public String toString() {
        String ret = Integer.toString(numerator) + "/" + denominator;
        return ret;
    }
}



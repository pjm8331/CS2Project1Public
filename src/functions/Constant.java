package functions;

/**
 * Class for constant values
 * @author Peter Mastropaolo(pjm8331)
 */
public class Constant extends Function {
    public double value;

    /**
     * Constructor for the Constant class
     * @param value
     */
    public Constant(double value) {
        this.value = value;
    }

    /**
     * evaluates the value at x
     * @param x
     * @return the constant value as it is a constant
     */
    public double evaluate(double x) {
        return value;
    }

    /**
     * Checks if the value is constant
     * @return a boolean value
     */
    public boolean isConstant() {
        return true;
    }

    /**
     * returns the derivative of the constant
     * @return all derivatives of a constant are zero
     */
    public Constant derivative() {
        return new Constant(0);
    }

    /**
     * Simplify function for recursion
     * @return the given value
     */
    public Function simplify() {
        return new Constant(value);
    }

    /**
     * Returns the integral of the value
     * @param bound1 lower bound
     * @param bound2 upper bound
     * @param n amount of intervals for trapezoidal rule
     * @return the integral of the value
     */
    @Override
    public double integral(double bound1, double bound2, int n) {
        return (value * bound2) - (value * bound1);
    }

    /**
     * String form of the value
     * @return the value as a string
     */
    public String toString() {
        return Double.toString(value);
    }
}
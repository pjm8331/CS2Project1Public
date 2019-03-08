package functions;

/**
 * @author Peter Mastropaolo(pjm8331)
 */
public class Variable extends Function {
    public final static Variable X = new Variable();

    /**
     * Constructor for Variable class
     */
    private Variable(){
    }

    /**
     * Evaluates a function at the given value
     * @param x value to evaluate at
     * @return the evaluated function
     */
    public double evaluate(double x) {
        return x;
    }

    /**
     * If the variable is constant
     * @return a boolean value
     */
    public boolean isConstant() {
        return false;
    }

    /**
     * Gets the derivative of the function
     * @return the differentiation of the function
     */
    public Function derivative(){
        return new Constant(1);
    }

    /**
     * Simplify function for recursion
     * @return the variable
     */
    public Function simplify(){
        return Variable.X;
    }

    /**
     * Returns the integral of the variable
     * @param bound1 lower bound
     * @param bound2 upper bound
     * @param n amount of intervals for trapezoidal rule
     * @return the integral of the variable
     */
    @Override
    public double integral(double bound1, double bound2, int n) {
        return ((.5 * evaluate(bound2) * evaluate(bound2))-(.5 * evaluate(bound1) * evaluate(bound1)));
    }

    /**
     * A string form of the variable
     * @return the variable in string form
     */
    @Override
    public String toString() {
        return "x";
    }
}

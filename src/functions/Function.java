package functions;

/**
 * Function superclass for all function classes
 * @author Peter Mastropaolo(pjm8331)
 */
public abstract class Function {

    /**
     * evaluates the function at the value
     * @param x value to evaluate at
     * @return the value of the function when evaluated
     */
    public abstract double evaluate(double x);

    /**
     * A string form of the function
     * @return the string of the function
     */
    @Override
    public abstract String toString();

    /**
     * The derivative of the function
     * @return the derivative of the function
     */
    public abstract Function derivative();

    /**
     * Whether or not the function is constant
     * @return a boolean value
     */
    public abstract boolean isConstant();

    /**
     * Simplify function for recursion
     * @return simplified function
     */
    public abstract Function simplify();

    /**
     * Returns the integral of the function
     * @param bound1 lower bound
     * @param bound2 upper bound
     * @param n amount of intervals for trapezoidal rule
     * @return the integral of the function
     */
    public  double integral(double bound1, double bound2, int n){
        double total = 0;
        double avg = (bound2-bound1)/2*n;
        for(int i = 0; i<n; i++){
            total += evaluate(i);
        }
        return avg * total;
    }

}

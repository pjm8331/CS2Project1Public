package functions;

/**Class for Sine functions
 * @author Peter Mastropaolo(pjm8331)
 */
public class Sine extends Function{
    public Function function;

    /**
     * Constructor for sine function
     * @param function
     */
    public Sine(Function function){
        this.function = function;
    }

    /**
     * evaluates the cosine at the value x
     * @param x value to evaluate at
     * @return the resulting value from evaluation
     */
    public double evaluate(double x) {
        return Math.sin(function.evaluate(x));
    }

    /**
     * Whether or not the function is constant
     * @return a boolean value
     */
    public boolean isConstant() {
        return false;
    }

    /**
     * Gets the derivative of the Sine function
     * @return the derivative of the function
     */
    public Function derivative() {
        return new Product(new Cosine(function), function.derivative());
    }

    /**
     * Simplify function for recursion
     * @return the given function
     */
    public Function simplify(){
        return new Sine(function);
    }

    /**
     * The function in string form
     * @return a string of the function
     */
    @Override
    public String toString() {
        return "Sin(" + function.toString() + ")";
    }
}

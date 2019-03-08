package functions;

/**
 * Class for Cosine functions
 * @author Peter Mastropaolo(pjm8331)
 */
public class Cosine extends Function{
    public Function function;

    /**
     * Constructor for cosine function
     * @param function
     */
    public Cosine(Function function){
        this.function = function;
    }

    /**
     * evaluates the cosine at the value x
     * @param x value to evaluate at
     * @return the resulting value from evaluation
     */
    public double evaluate(double x) {
        return Math.cos(function.evaluate(x));
    }

    /**
     * Whether or not the function is constant
     * @return a boolean value
     */
    public boolean isConstant() {
        return false;
    }

    /**
     * Gets the derivative of the Cosine function
     * @return the derivative of the function
     */
    public Function derivative(){
        return new Product(new Constant(-1), new Sine(function), function.derivative());
    }

    /**
     * Simplify function for recursion
     * @return the given function
     */
    public Function simplify(){
        return new Cosine(function);
    }

    /**
     * The function in string form
     * @return a string of the function
     */
    @Override
    public String toString() {
        return "Cos(" + function.toString() + ")";
    }
}

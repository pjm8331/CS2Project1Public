package functions;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Product class for product functions
 * @author Peter Mastropaolo(pjm8331)
 */

public class Product extends Function {

    public Function[] things;
    private boolean constant = true;
    private boolean zero = false;

    /**
     * Constructor for product class
     * @param things
     */
    public Product(Function... things){
        this.things = things;

        for(Function i : things){
            if(constant && !i.isConstant()){
                constant = false;
            }
            if(i == new Constant(0) && !zero){
                zero = true;
            }
        }
    }

    /**
     * evaluates the function at the given value
     * @param x value to evaluate at
     * @return the function after it has been evaluated
     */
    public double evaluate(double x) {
        ArrayList<Double> compute = new ArrayList<>();

        for(int i = 0; i<things.length; i++){
            compute.add(things[i].evaluate(x));
        }

        double total = 1;

        for(int i = 0; i<compute.size(); i++){
            total = total * compute.get(i);
        }

        return total;
    }

    /**
     * Whether or not the function is constant
     * @return a boolean value
     */
    public boolean isConstant() {
        return this.constant;
    }

    /**
     * The product rule for 2 functions
     * @param f1 first function
     * @param f2 second function
     * @return the function after product rule
     */
    public Function productrule(Function f1, Function f2){

        Function p1 = new Product(f1.derivative(), f2);
        Function p2 = new Product(f1, f2.derivative());
        return new Sum(p1, p2);
    }

    /**
     * Simplify function for recursion
     * @return simplifies the product in certain cases
     */
    public Function simplify(){
        Function zero = new Constant(0);
        double totalconstant = 1;
        ArrayList<Function> newones = new ArrayList<>();
        for(int i = 0; i < things.length; i++){
            if(things[i] == zero){
                return zero;
            }
            else if(things[i].isConstant()){
                totalconstant = totalconstant * things[i].evaluate(0);
            }
            else{
                newones.add(things[i]);
            }
        }
        if(totalconstant == 1) {
            Function[] newproduct = new Function[newones.size()];
            for (int i = 0; i < newproduct.length; i++) {
                newproduct[i] = newones.get(i);
            }
            return new Product(newproduct);
        }
        else{
            Function[] newproduct = new Function[newones.size() + 1];
            newproduct[0] = new Constant(totalconstant);
            for(int i = 1; i < newproduct.length; i++){
                newproduct[i] = newones.get(i-1);
            }
            return new Product(newproduct);
        }
        /*
        if(things[1].simplify() == zero || things[0].simplify() == zero){
            return zero;
        }
        else if(things[0].simplify() == one){
            return things[1].simplify();
        }
        else if(things[1].simplify() == one){
            return things[0].simplify();
        }
        else{
            return new Product(things);
        }*/
    }

    /**
     * Gets the derivative of the function
     * @return the function after differentiation
     */
    public Function derivative() {
        if (isConstant()) {
            return new Constant(0);
        }

        else {
            if(things.length == 1){
                return things[0].derivative();
            }

            else if (things.length == 2) {
                return productrule(things[0], things[1]);

            }

            else{
                Function[] newArray = Arrays.copyOfRange(things, 1, things.length);
                return new Product(things[0], new Product(newArray).derivative());
            }
        }
    }

    /**
     * The string version of the function
     * @return the string of the function
     */
    @Override
    public String toString() {
        if(zero || isConstant()){
            return(Double.toString(evaluate(0)));
        }
        else{
            String string = "(";
            for(int i = 0; i<things.length; i++){

                if(i == things.length-1){
                    string += things[i].simplify().toString() + ")";
                }

                else{
                    string += (things[i].simplify().toString()) + "*";
                }
            }
            return string;
        }
    }
}
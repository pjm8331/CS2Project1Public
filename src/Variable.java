public class Variable extends Function {
    public final static Variable X = new Variable();
    private Variable(){
        //Create constructor stuff
    }

    public double evaluate(double x) {
        return x;
    }

    public boolean isConstant() {
        return false;
    }

    @Override
    public String toString() {
        return "x";
    }
}

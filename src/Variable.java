public class Variable extends Function {
    public final static Variable X = new Variable();
    private Variable(){
    }

    public double evaluate(double x) {
        return x;
    }

    public boolean isConstant() {
        return false;
    }

    public Function derivative(){
        return new Constant(1);
    }

    @Override
    public String toString() {
        return "x";
    }
}

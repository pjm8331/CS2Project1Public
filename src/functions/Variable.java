package functions;
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

    public Function simplify(){
        return Variable.X;
    }

    @Override
    public double integral(double bound1, double bound2, int n) {
        return ((.5 * evaluate(bound2) * evaluate(bound2))-(.5 * evaluate(bound1) * evaluate(bound1)));
    }

    @Override
    public String toString() {
        return "x";
    }
}

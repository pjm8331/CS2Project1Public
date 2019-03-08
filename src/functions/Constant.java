package functions;
public class Constant extends Function {
    public double value;

    public Constant(double value) {
        this.value = value;
    }

    public double evaluate(double x) {
        return value;
    }

    public boolean isConstant() {
        return true;
    }

    public Constant derivative() {
        return new Constant(0);
    }

    public Function simplify() {
        return new Constant(value);
    }

    @Override
    public double integral(double bound1, double bound2, int n) {
        return (value * bound2) - (value * bound1);
    }

    public String toString() {
        return Double.toString(value);
    }
}
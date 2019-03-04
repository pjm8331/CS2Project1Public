public class Sine extends Function{
    public Function function;
    public Sine(Function function){
        this.function = function;
    }

    public double evaluate(double x) {
        return Math.sin(function.evaluate(x));
    }

    public boolean isConstant() {
        return false;
    }

    @Override
    public String toString() {
        return "Sin(" + function.toString() + ")";
    }
}

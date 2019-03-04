public class Cosine extends Function{
    public Function function;
    public Cosine(Function function){
        this.function = function;
    }

    public double evaluate(double x) {
        return Math.cos(function.evaluate(x));
    }

    public boolean isConstant() {
        return false;
    }

    @Override
    public String toString() {
        return "Cos(" + function.toString() + ")";
    }
}

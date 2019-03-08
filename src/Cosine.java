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

    public Function derivative(){
        return new Product(new Constant(-1), new Sine(function), function.derivative());
    }

    public Function simplify(){
        return new Cosine(function);
    }

    @Override
    public String toString() {
        return "Cos(" + function.toString() + ")";
    }
}

public class Constant extends Function {
    public double value;
    public Constant(double value){
        this.value = value;
    }

    public double evaluate(double x) {
        return value;
    }

    public boolean isConstant() {
        return true;
    }

    public Constant derivative(){
        return new Constant(0);
    }

    public String toString() {
        return Double.toString(value);
    }
}

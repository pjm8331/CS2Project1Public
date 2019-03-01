public class Constant extends Function {
    public int value;
    public Constant(int value){
        this.value = value;
    }

    public double evaluate(double x) {
        return 0;
    }

    public boolean isConstant() {
        return true;
    }

    public String toString() {
        return Integer.toString(value);
    }
}

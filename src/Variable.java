public class Variable implements Function {
    private Variable(){

    }

    public double evaluate(double x) {
        return 0;
    }

    public boolean isConstant() {
        return false;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

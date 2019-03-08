public abstract class Function {

    public abstract double evaluate(double x);

    @Override
    public abstract String toString();

    public abstract Function derivative();

    public abstract boolean isConstant();

    public abstract Function simplify();

    public abstract Function integral();

}

public abstract class Function {

    public abstract double evaluate(double x);

    @Override
    public abstract String toString();

    public abstract Function derivative();

    public abstract boolean isConstant();

    public abstract Function simplify();

    public  Function integral(double bound1, double bound2, int n){
        double avg = (bound2-bound1)/n;
        return null;
    }

}

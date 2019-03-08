package functions;

/**
 * @author Peter Mastropaolo(pjm8331)
 */
public abstract class Function {

    public abstract double evaluate(double x);

    @Override
    public abstract String toString();

    public abstract Function derivative();

    public abstract boolean isConstant();

    public abstract Function simplify();

    public  double integral(double bound1, double bound2, int n){
        double total = 0;
        double avg = (bound2-bound1)/2*n;
        for(int i = 0; i<n; i++){
            total += evaluate(i);
        }
        return avg * total;
    }

}

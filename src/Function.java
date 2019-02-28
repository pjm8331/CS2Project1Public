public interface Function {
    double evaluate(double x);
    @Override
    String toString();
    boolean isConstant();

}

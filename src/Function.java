public abstract class Function {

    public double evaluate(double x){
        return 0.0;
    }

    @Override
    public String toString(){
        return "";
    }

    public boolean isConstant(){
        return false;
    }

}

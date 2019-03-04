import java.util.ArrayList;

public class Product extends Function {

    public Function[] things;
    private boolean constant = true;

    public Product(Function... things){
        this.things = things;

        for(Function i : things){
            if(constant && !i.isConstant()){
                constant = false;
            }
        }
    }

    public double evaluate(double x) {
        ArrayList<Double> compute = new ArrayList<>();
        for(int i = 0; i<things.length; i++){
            compute.add(things[i].evaluate(x));
        }
        double total = 0.0;
        for(int i = 0; i<compute.size(); i++){
            total = total * compute.get(i);
        }
        return total;
    }

    public boolean isConstant() {
        return this.constant;
    }

    @Override
    public String toString() {
        String string = "(";
        for(int i = 0; i<things.length; i++){
            if(i == things.length-1){
                string += things[i].toString() + ")";
            }
            else{
                string += (things[i].toString()) + "*";
            }
        }
        return string;
    }
}

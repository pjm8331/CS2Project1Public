import java.util.ArrayList;

public class Sum extends Function {
    public ArrayList<Function> things;
    private boolean constant = true;

    public Sum(Function ...things){
        for(Function i: things){
            this.things.add(i);

            if(constant && !i.isConstant()){
                constant = false;
            }
        }


    }

    public double evaluate(double x) {
        ArrayList<Double> compute = new ArrayList<>();
        for(int i = 0; i<things.size(); i++){
            compute.add(things.get(i).evaluate(x));
        }
        double total = 0.0;
        for(int i = 0; i<compute.size(); i++){
            System.out.println(total + "+" + compute.get(i)); //For testing purposes
            total += compute.get(i);
        }
        return total;
    }

    public boolean isConstant() {
        return constant;
    }

    @Override
    public String toString() {
        String string = "";
        for(int i = 0; i<things.size(); i++){
            string += (things.get(i).toString()) + " + ";
        }
        return string;
    }
}

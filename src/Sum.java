import java.util.ArrayList;

public class Sum extends Function {
    public Function[] things;
    private boolean constant = true;

    public Sum(Function ...things){
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
            total += compute.get(i);
        }
        return total;
    }

    public boolean isConstant() {
        return this.constant;
    }

    public Function derivative(){
        Function[] newthings = new Function[things.length];
        for(int i = 0; i<things.length; i++){
            newthings[i] = things[i].derivative();
        }
        Sum checks = new Sum(newthings);                    //If all constants, add together and return a constant
        if(checks.isConstant()){
            return new Constant(checks.evaluate(0));
        }
        else{                                               //If not complete constant function, add all constants to simplify
            double add = 0;
            ArrayList<Function> newerthings = new ArrayList<>();
            for(int i = 0; i<newthings.length; i++){
                if(newthings[i].isConstant()){
                    add += newthings[i].evaluate(0);
                }
                else{
                    newerthings.add(newthings[i]);
                }
            }
            newerthings.add(new Constant(add));
            Function[] newestthings = new Function[newerthings.size()];
            for(int i = 0; i<newerthings.size(); i++){
                newestthings[i] = newerthings.get(i);
            }
            return new Sum(newestthings);
        }
    }

    @Override
    public String toString() {
        String string = "(";
        for(int i = 0; i<things.length; i++){
            if(i == things.length-1){
                string += things[i].toString() + ")";
            }
            else{
                string += (things[i].toString()) + "+";
            }
        }
        return string;
    }
}

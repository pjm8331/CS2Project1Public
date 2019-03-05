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
        double total = 1;
        for(int i = 0; i<compute.size(); i++){
            total = total * compute.get(i);
        }
        return total;
    }

    public boolean isConstant() {
        return this.constant;
    }

    public Function productrule(){
        return null;
    }

    public Function powerrule(Constant in, int numbervar){
        Function[] news = new Function[numbervar + 1];
        double newin = in.evaluate(0)/numbervar;
        news[0] = new Constant(newin);
        for(int i = 1; i<numbervar-1; i++){
            news[i] = Variable.X;
        }
        return new Product(news);
    }

    public Function derivative(){
        int numbervar = 0;
        double totalconstant = 1;
        boolean id = false;
        for(int i = 0; i<things.length; i++){
            if(things[i] instanceof Variable){
                numbervar+=1;
            }
            if(things[i].isConstant()){
                totalconstant = totalconstant * things[i].evaluate(0);
            }
            if((things[i] instanceof Sine || things[i] instanceof Product || things[i] instanceof Cosine || things[i] instanceof Sum) && !id){
                id = true;
            }
        }
        if(isConstant()){
            return new Constant(0);
        }
        else if(!id){
            return powerrule(new Constant(totalconstant), numbervar);
        }
        else{
            return productrule();
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
                string += (things[i].toString()) + "*";
            }
        }
        return string;
    }
}

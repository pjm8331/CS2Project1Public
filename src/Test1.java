import functions.*;
public class Test1 {


    public static void main( String[] args ) {
        if (args.length != 0) {
            System.err.println("Test1 takes no command line arguments.");
            System.exit(1);
        }
        Variable var = Variable.X;
        System.out.println("Derivative Testing");
        System.out.println("Testing constants and variables...");
        Function f1 = new Product(new Constant(2), var, var);
        System.out.println("Function: " + f1);
        System.out.println("Derivative: " + f1.derivative());
        System.out.println("Testing nested functions...");
        Function f2 = new Product(new Product(new Constant(2), var, var), new Sum(new Product(new Constant(2), var), new Constant(5)));
        System.out.println("Function: " + f2);
        System.out.println("Derivative: " + f2.derivative());
    }

}

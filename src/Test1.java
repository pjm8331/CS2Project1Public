public class Test1 {


    public static void main( String[] args ) {
        if (args.length != 0) {
            System.err.println("Test1 takes no command line arguments.");
            System.exit(1);
        }
        Variable var = Variable.X;
        Function f1 = new Product(new Constant(2), var, var);
        System.out.println(f1.derivative());
    }

}

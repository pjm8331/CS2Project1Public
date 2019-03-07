public class Test1 {


    public static void main( String[] args ) {
        if (args.length != 0) {
            System.err.println("Test1 takes no command line arguments.");
            System.exit(1);
        }
        Variable var = Variable.X;
        System.out.println("Testing constants and variables...");
        Function f1 = new Product(new Constant(2), var, var);
        System.out.println(f1.derivative());
        Function f2 = new Product(new Product(new Constant(2), var, var), new Sum(new Product(new Constant(2), var), new Constant(5)));
        System.out.println(f2);
        System.out.println(f2.derivative());
    }

}

import functions.*;

/**
 * Test class 2 for product, sine, cosine, derivative, integral
 * @author Peter Mastropaolo(pjm8331)
 */
public class FunctionTest2 {
    public static void main( String[] args ) {
        if (args.length != 0) {
            System.err.println("Test1 takes no command line arguments.");
            System.exit(1);
        }
        Variable var = Variable.X;

        System.out.println("Testing Product...");

        System.out.println("Constants...");

        Function p1 = new Product(new Constant(8), new Constant(4));
        System.out.println("P1: " + p1);
        System.out.println("Evaluate: " + p1.evaluate(0));

        Function p2 = new Product(new Constant(6), new Constant(-3));
        System.out.println("P2: " + p2);
        System.out.println("Evaluate: " + p2.evaluate(0));

        System.out.println("Variables...");

        Function p3 = new Product(new Constant(7), var);
        System.out.println("P3: " + p3 + "  X = 6");
        System.out.println("Evaluate: " + p3.evaluate(6));

        Function p4 = new Product(var, var);
        System.out.println("P4: " + p4 + "  X = 20");
        System.out.println("Evaluate: " + p4.evaluate(20));

        Function p5 = new Product(p1, p2, p3, p4);
        System.out.println("Nested P5: " + p5 + "  X = 49");
        System.out.println("Evaluate: " + p5.evaluate(49));

        Function p6 = new Product(new Sum(new Constant(6), new Constant(-3)), new Sum(new Constant(-4), new Constant(9)));
        System.out.println("Nested P6: " + p6 + "  X = 12");
        System.out.println("Evaluate: " + p6.evaluate(12));

        Function p7 = new Product(new Sum(p1, p2), p4, p6);
        System.out.println("Nested P7: " + p7 + "  X = 36");
        System.out.println("Evaluate: " + p7.evaluate(36));

        System.out.println("Sine and Cosine...");

        Function s1 = new Sine(var);
        System.out.println("Sine: " + s1 + "    X = 4");
        System.out.println("Evaluate: " + s1.evaluate(4));

        Function cs1 = new Cosine(var);
        System.out.println("Cosine: " + cs1 + "    X = 4");
        System.out.println("Evaluate: " + s1.evaluate(4));

        System.out.println("Testing Derivative...");

        Function c1 = new Constant(8);
        System.out.println("Constant: "+ c1 + " Derivative: " + c1.derivative());

        System.out.println("Variable: "+ var + " Derivative: " + var.derivative());

        Function su1 = new Sum(var, new Constant(7));
        System.out.println("Sum: " + su1);
        System.out.println("Derivative: " + su1.derivative());

        Function p8 = new Product(su1, s1, cs1);
        System.out.println("Product: " + p8 + "    X = 62");
        System.out.println("Derivative: " + p8.derivative());
        System.out.println("Evaluated Derivative: " + p8.derivative().evaluate(62));

        Function p9 = new Product(p8, p7, p6);
        System.out.println("Product: " + p9 + "    X = 8");
        System.out.println("Derivative: " + p9.derivative());
        System.out.println("Evaluated Derivative: " + p9.derivative().evaluate(8));

        System.out.println("Testing Integrals...");

        System.out.println("Cosine: " + cs1 + "    X = 4");
        System.out.println("Evaluated Integral(): " + s1.integral(43, 82, 1000));

        System.out.println("Constant: "+ c1 + " Evaluated Integral(43, 82, 1000): " + c1.integral(43,82,1000));

        System.out.println("Variable: "+ var + " Evaluated Integral(43, 82, 1000): " + var.integral(43, 82, 1000));

        System.out.println("Sum: " + su1);
        System.out.println("Evaluated Integral(43, 82, 1000): " + su1.integral(43, 82, 1000));

        System.out.println("Product: " + p8 + "    X = 62");
        System.out.println("Evaluated Integral(43, 82, 1000): " + p8.integral(43, 82, 1000));

        System.out.println("Product: " + p9 + "    X = 8");
        System.out.println("Evaluated Integral(43, 82, 1000): " + p9.integral(43, 82, 1000));

        System.out.println("Finished!");
    }
}

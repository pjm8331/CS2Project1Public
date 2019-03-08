import functions.*;

import javax.xml.parsers.SAXParser;

/**
 * Test class 1 for sums, constants, and variables
 * @author Peter Mastropaolo(pjm8331)
 */
public class FunctionTest1 {


    public static void main( String[] args ) {
        if (args.length != 0) {
            System.err.println("Test1 takes no command line arguments.");
            System.exit(1);
        }
        Variable var = Variable.X;

        System.out.println("Testing Sums...");
        System.out.println("Constants...");
        Function s1 = new Sum(new Constant(4), new Constant(3));
        System.out.println("S1: " + s1);
        System.out.println("Evaluate: " + s1.evaluate(0));
        Function s2 = new Sum(new Constant(4), new Constant(-3));
        System.out.println("S2: " + s2);
        System.out.println("Evaluate: " + s2.evaluate(0));
        Function s3 = new Sum(new Constant(-4), new Constant(-3));
        System.out.println("S3: " + s3);
        System.out.println("Evaluate: " + s3.evaluate(0));
        Function s4 = new Sum(s3, s2, s1);
        System.out.println("Nested S4: " + s4);
        System.out.println("Evaluated: " + s4.evaluate(0));
        System.out.println("Variables...");
        Function s5 = new Sum(var, var);
        System.out.println("S5: " + s5 + "  X = 36");
        System.out.println("Evaluate: " + s5.evaluate(36));
        Function s6 = new Sum(new Constant(7), var, var);
        System.out.println("S6: " + s6 + "  X = 21");
        System.out.println("Evaluate: " + s6.evaluate(21));
        Function s7 = new Sum(s5, s6);
        System.out.println("Nested S7: " + s7 + "   X = 3");
        System.out.println("Evaluate: " + s7.evaluate(3));
        Function s8 = new Sum(s7, s4);
        System.out.println("Final Test...");
        System.out.println("Nested S8: " + s8 + "   X = 8");
        System.out.println("Evaluate: " + s8.evaluate(8));
    }

}

import org.junit.Test;

public class Main {

    public static void main(String[] args) {

        StackCalculator calc = new StackCalculator();

        //expect 2
        calc.calculate("( 70 / ( 5 * ( 4 + 3 ) ) )");
        //expect 35
        calc.calculate("( 5 * ( 4 + 3 ) )");
        //expect 0.714
        calc.calculate("( 5 / ( ( sqrt 16 ) + 3 ) )");
        //fail, three expressions in parentheses: expect 5, but get 0
        calc.calculate("( 5 + ( sqrt 4 ) - 2 )");

        //new operations - absolute value and factorial
        //expression with absolute value --> expect 7
        calc.calculate("( abs ( -3 ) + 4 )");
        //expression with factorial --> expect 2
        calc.calculate("( 12 / ( 3 ! ) )");
    }
}

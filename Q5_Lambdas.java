import java.util.function.*;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class Q5_Lambdas {

    // ── PREDICT: What does main() print for lines 1-3? ──
    // Also answer the inline questions.

    public static void main(String[] args) {
        int multiplier = 3;
        IntUnaryOperator triple = x -> x * multiplier;
        System.out.println("1: " + triple.applyAsInt(7));
        //Output: 1: 21
        // Q: if you uncomment the next line, does it compile? why?
        // multiplier = 4;
        // no, it does not compile becuase a varibale used inside lambda cannot be reassigned later so it must be final

        Runnable[] tasks = new Runnable[3];
        for (int i = 0; i < 3; i++) {
            final int idx = i;
            tasks[i] = () -> System.out.print(idx);
        }
        System.out.print("2: ");
        for (Runnable r : tasks) r.run();
        System.out.println();
        //Output: 2: 012
   
        // Q: what if you removed "final" from idx? does it still compile?
        //yes becuase idx is never reassigned

        List<String> motors = Arrays.asList("Falcon", "Neo", "Kraken", "Vortex");
        motors.sort((a, b) -> a.length() - b.length());
        System.out.println("3: " + motors);
        //Output: 3: [Neo, Falcon, Vortex, Kraken]

        // ── WRITE ──
        // 1) Write a method "applyToAll" that takes a List<Integer> and a
        //    UnaryOperator<Integer>, applies the operator to every element
        //    IN PLACE (mutates the list), and returns void.

        List<Integer> nums = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        applyToAll(nums, x -> x * x);
        assert nums.equals(Arrays.asList(1, 4, 9, 16, 25)) : "applyToAll failed: " + nums;
        System.out.println("applyToAll ok");

        // 2) Write a method "compose" that takes two IntUnaryOperators f and g
        //    and returns a new IntUnaryOperator that computes f(g(x)).
        //    Do NOT use .compose() or .andThen() — write the lambda yourself.

        IntUnaryOperator doubleIt = x -> x * 2;
        IntUnaryOperator addThree = x -> x + 3;
        IntUnaryOperator doubleThenAdd = compose(addThree, doubleIt);
        assert doubleThenAdd.applyAsInt(5) == 13 : "compose failed";  // addThree(doubleIt(5)) = 13
        System.out.println("compose ok");

        // 3) Using streams, write one expression that filters nums to only
        //    values > 5, then sums them. Store result in "total".

        int total = 0; // replace this
        assert total == 9 + 16 + 25 : "stream sum failed: " + total;
        System.out.println("stream ok");
    }

    // TODO
    static void applyToAll(List<Integer> list, UnaryOperator<Integer> op) {
        // your code here
    }

    // TODO
    static IntUnaryOperator compose(IntUnaryOperator f, IntUnaryOperator g) {
        // your code here
        return x -> x;
    }
}

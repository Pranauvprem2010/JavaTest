public class Q4_ControlFlow {

    // ── PREDICT: What does main() print for lines 1-5? ──

    static boolean log(String label) {
        System.out.println("  eval " + label);
        return true;
    }

    public static void main(String[] args) {
        // Q4a: which "eval" lines actually print?
        System.out.println("1:");
        if (false && log("A")) {}
        if (true || log("B")) {}
        if (false || log("C")) {}
        //Only eval C prints

        // Q4b: switch fallthrough
        System.out.println("2:");
        int val = 2;
        switch (val) {
            case 1: System.out.println("  one");
            case 2: System.out.println("  two");
            case 3: System.out.println("  three");
            default: System.out.println("  default");
        }
        //Output: two, three, default

        // Q4c: what's the final value of sum?
        int sum = 0;
        for (int i = 0; i < 10; i++) {
            if (i % 3 == 0) continue;
            if (i > 7) break;
            sum += i;
        }
        System.out.println("3: " + sum);
        //the final value of sum is 19

        // Q4d: post-increment in expression
        int n = 5;
        int result = n++ + ++n;
        System.out.println("4: " + result + " " + n);
        //Output: 4: 12 7

        // Q4e
        System.out.println("5: " + (true ? "yes" : "no") + (1 > 2 ? "!" : "?"));
        //Output: 5: yes?

        // ── WRITE ──
        // Implement fizzBuzz(int n) that returns:
        //   "FizzBuzz" if divisible by both 3 and 5
        //   "Fizz"     if divisible by 3 only
        //   "Buzz"     if divisible by 5 only
        //   the number as a String otherwise
        //
        // Use a SWITCH EXPRESSION (Java 14+), not if/else.
        // Hint: you can switch on a computed value.

        assert fizzBuzz(15).equals("FizzBuzz");
        assert fizzBuzz(9).equals("Fizz");
        assert fizzBuzz(10).equals("Buzz");
        assert fizzBuzz(7).equals("7");
        assert fizzBuzz(30).equals("FizzBuzz");
        assert fizzBuzz(1).equals("1");
        System.out.println("fizzBuzz ok");
    }

    // TODO: implement with a switch expression
    static String fizzBuzz(int n) {
        int remainder = n % 15;
        return switch (remainder) {
            case 0 -> "FizzBuzz";
            case 3, 6, 9, 12 -> "Fizz";
            case 5, 10 -> "Buzz";
            default -> "" + n;
        };
    }
}


import java.util.Arrays;

public class Q1_References {

    // ── PREDICT: What does main() print? Write your answers, then compile to check. ──

    static void addOne(int x) { x += 1; }
    static void addOne(int[] arr) { arr[0] += 1; }
    static void replace(int[] arr) { arr = new int[]{99}; }

    static void upperCase(String s) { s = s.toUpperCase(); }

    public static void main(String[] args) {
        int a = 5;
        addOne(a);
        System.out.println("1: " + a);
        //output: 1: 5

        int[] b = {5};
        addOne(b);
        System.out.println("2: " + b[0]);
        //output: 2: 6

        replace(b);
        System.out.println("3: " + b[0]);
        //output: 3: 6

        String s = "hello";
        upperCase(s);
        System.out.println("4: " + s);
        //output: 4: hello

        int[] c = {1, 2, 3};
        int[] d = c;
        d[1] = 99;
        System.out.println("5: " + Arrays.toString(c));
        //output: 5: [1, 99, 3]

        // ── WRITE ──
        // Implement swap() so the two assertions pass.
        // You may NOT change main or the method signature.
        // Hint: think about what Java actually passes.

        int[] pair = {10, 20};
        swap(pair);
        assert pair[0] == 20 && pair[1] == 10 : "swap failed";
        System.out.println("swap ok");

        // Now implement swapStrings() so that after calling it,
        // arr[0] is arr[1]'s old value and vice versa.
        String[] names = {"Falcon", "Kraken"};
        swapStrings(names);
        assert names[0].equals("Kraken") && names[1].equals("Falcon") : "swapStrings failed";
        System.out.println("swapStrings ok");
    }

    // TODO: implement
    static void swap(int[] pair) {
        int i = pair[0];
        pair[0] = pair[1];
        pair[1] = i;
    }

    // TODO: implement
    static void swapStrings(String[] arr) {
        String i = arr[0];
        arr[0] = arr[1];
        arr[1] = i;
    }
}

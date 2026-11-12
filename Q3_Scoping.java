public class Q3_Scoping {

    // ── PREDICT: What does main() print for lines 1-4? ──

    static int count = 0;
    int id;

    Q3_Scoping() { id = ++count; }
    static void reset() { count = 0; }

    public static void main(String[] args) {
        Q3_Scoping a = new Q3_Scoping();
        Q3_Scoping b = new Q3_Scoping();
        System.out.println("1: " + a.id + " " + b.id);
        //Output: 1: 1 2

        reset();
        Q3_Scoping c = new Q3_Scoping();
        System.out.println("2: " + c.id + " " + count);
        //Output: 2: 1 1

        int x = 10;
        for (int i = 0; i < 3; i++) {
            int x2 = x + i;
            x = x2;
        }
        System.out.println("3: " + x);
        //Output: 3: 13
        // Q: does "x2" exist here? (yes/no, and why)
        //No becuase x2 was declared inside the for loop and can no longer be accessed after the for loop executes

        int val = 5;
        System.out.println("4: " + val + " " + a.count);
        //Output: 4: 5 1
        // Q: why does a.count compile? is this good practice?
        //Because count is static, and belongs to the class rather than an object, but can still be accessed through an object, but this is not good practice

        // ── WRITE ──
        // Create a class Counter with:
        //   - a static int "total" tracking how many Counters have been created
        //   - an instance String "label"
        //   - a constructor Counter(String label)
        //   - a method String toString() that returns "label (#id)" where id
        //     is the 1-based creation order (first Counter is #1, second is #2, etc.)
        //
        // Uncomment when done:

        Counter c1 = new Counter("left");
        Counter c2 = new Counter("right");
        System.out.println("5: " + c1);   // left (#1)
        System.out.println("6: " + c2);   // right (#2)
        assert Counter.total == 2;
        System.out.println("Counter ok");
    }

    // TODO: write Counter here
    static class Counter {
        static int total = 0;

        String label;
        int id;

        Counter(String label) {
            this.label = label;
            total++;
            id = total;
        }

        public String toString() {
            return label + " (#" + id + ")";
        }
    }
}    

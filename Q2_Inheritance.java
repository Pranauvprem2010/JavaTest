public class Q2_Inheritance {

    // ── PREDICT: What does main() print for lines 1-4? ──

    static class Motor {
        String name() { return "Motor"; }
        void run() { System.out.println(name() + " spinning"); }
    }

    static class Falcon extends Motor {
        String name() { return "Falcon"; }
    }

    static class Kraken extends Falcon {
        void run() { System.out.println(name() + " go brrr"); }
    }

    public static void main(String[] args) {
        Motor m1 = new Falcon();
        System.out.print("1: "); m1.run();
        //Output: 1: Falcon spinning

        Motor m2 = new Kraken();
        System.out.print("2: "); m2.run();
        //Output: 2: Falcon go brrr

        Falcon m3 = new Kraken();
        System.out.println("3: " + m3.name());
        //Output: 3: Falcon

        Motor m4 = new Kraken();
        System.out.println("4: " + (m4 instanceof Falcon));
        //Output: 4: true

        // ── WRITE ──
        // Create a class "Neo" that extends Motor such that:
        //   - neo.name() returns "Neo"
        //   - neo.run() prints "Neo spinning at {rpm} RPM"
        //     where rpm is set via a constructor argument
        //   - neo.run() must call super.name() (not hardcode "Neo")
        //
        // Uncomment the test below when done.

        Neo n = new Neo(6000);
        System.out.print("5: "); n.run();  // should print: Neo spinning at 6000 RPM
        assert n.name().equals("Neo");
        assert n instanceof Motor;
        System.out.println("Neo ok");
    }

    // TODO: write the Neo class here
    static class Neo extends Motor {
        int rpm;

        Neo(int rpm) {
            this.rpm = rpm;
        }

        String name() {
            super.name();
            return "Neo";
        }

        void run() {
            System.out.println(name() + " spinning at " + rpm + " RPM");
        }
    }
}

package learn.ashish.algorithms.misc;

public class SpecialPythagoreanTriplet {
    /**
     * A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
     * a2 + b2 = c2
     * For example, 32 + 42 = 9 + 16 = 25 = 52.
     * <p>
     * There exists exactly one Pythagorean triplet for which a + b + c = 1000.
     * Find the product abc.
     *
     * @param args
     */
    public static void main(String[] args) {
        new SpecialPythagoreanTriplet().solve();
    }

    public void solve() {
        for (int a = 1; a < 1000; a++) {
            for (int b = a + 1; b < 1000; b++) {
                double aS = Math.pow(a, 2);
                double bS = Math.pow(b, 2);

                double c = Math.pow((aS + bS), 0.5);

                if (a + b + c == 1000) {
                    System.out.println(a * b * c);
                    break;
                }
            }
        }
    }
}

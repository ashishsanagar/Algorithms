package learn.ashish.algorithms.misc;

public class HammingDistance {

    /**
     * if x and y are numbers, hamming distance between them is number of positions between them where bits are different
     * <p>
     * x = 1 (bits: 0 0 0 1), y = 4 (0 1 0 0)
     * (1 ^ 0) + (0 ^ 0) + (0 ^ 1) + (0 ^ 0) = 2
     */
    public static void main(String[] args) {
        int x = 1;
        int y = 4;

        System.out.println(new HammingDistance().find(x, y));
    }

    public int find(int x, int y) {
        int result = 0;

        while (x > 0 || y > 0) {
            result += (x % 2) ^ (y % 2);
            x = x / 2;
            y = y / 2;
        }
        return result;
    }
}

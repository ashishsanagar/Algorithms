package learn.ashish.algorithms.misc;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
    /**
     * I can be placed before V (5) and X (10) to make 4 and 9.
     * X can be placed before L (50) and C (100) to make 40 and 90.
     * C can be placed before D (500) and M (1000) to make 400 and 900.
     *
     * @param args
     */
    public static void main(String[] args) {
        String roman = "XIV";
        System.out.println(new RomanToInteger().convert(roman));
    }

    public int convert(String s) {
        if (s == null || s.isEmpty()) return 0;

        Map<Character, Integer> data = new HashMap<>();
        data.put('I', 1);
        data.put('V', 5);
        data.put('X', 10);
        data.put('L', 50);
        data.put('C', 100);
        data.put('D', 500);
        data.put('M', 1000);

        int previous = 0;
        int sum = 0;

        // keep track of previous value, if previous value is less than next value, means we have hit minus conditions
        // as previous was added to sum, subtract it 2 times and add next value.
        for (int i = 0; i < s.length(); i++) {
            if (previous < data.get(s.charAt(i))) {
                sum = sum - previous - previous + data.get(s.charAt(i));
            } else {
                sum += data.get(s.charAt(i));
            }
            previous = data.get(s.charAt(i));

        }

        return sum;
    }

}



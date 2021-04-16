package learn.ashish.algorithms.strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Ashish Sanagar
 */
public class NthMostFrequentStringFromArray {

    public static void main(String[] args) {
        String[] array = {"ab", "bc", "bc", "ab", "bc", "as", "abc", "cd"};

        System.out.println(new NthMostFrequentStringFromArray().find(array, 2));
    }

    public String find(String[] array, int n) {
        if (array == null || n > array.length)
            throw new IllegalArgumentException();

        if (array.length == 0) return "";

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < array.length; i++) {
            Integer frequency = map.get(array[i]);

            if (frequency == null) frequency = 0;

            map.put(array[i], ++frequency);
        }

        List<Map.Entry> list = new ArrayList<>(map.entrySet());

        list.sort((x, y) -> (Integer) y.getValue() - (Integer) x.getValue());

        return (String) list.get(n - 1).getKey();
    }
}

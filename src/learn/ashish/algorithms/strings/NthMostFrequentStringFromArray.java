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
        if (array == null || n > array.length || array.length == 0)
            return "";

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < array.length; i++)
            map.put(array[i], map.getOrDefault(array[i], 0) + 1);

        List<Map.Entry> list = new ArrayList<>(map.entrySet());

        list.sort((x, y) -> (Integer) y.getValue() - (Integer) x.getValue());

        return (String) list.get(n - 1).getKey();
    }
}

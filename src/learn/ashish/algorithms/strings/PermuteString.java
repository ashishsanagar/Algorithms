package learn.ashish.algorithms.strings;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Ashish Sanagar
 */
public class PermuteString {

    public static void main(String[] args) {

        Set<String> result = new HashSet<>();
        new PermuteString().permutation("abc", "", result);
        result.stream().forEach(ele -> System.out.println(ele));
    }

    /**
     * recursion
     */
    public void permutation(String input, String chosen, Set<String> result) {
        if (input.isEmpty())
            result.add(chosen);
        else
            for (int i = 0; i < input.length(); i++)
                permutation(input.substring(0, i) + input.substring(i + 1), chosen + input.charAt(i), result);
    }
}

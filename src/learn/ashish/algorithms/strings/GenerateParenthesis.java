package learn.ashish.algorithms.strings;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {

    /**
     * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
     *
     * @param args
     */
    public static void main(String[] args) {
        new GenerateParenthesis().generateParenthesis(3).forEach(System.out::println);
    }

    public List<String> generateParenthesis(int n) {
        List<String> output = new ArrayList<>();

        generate(output, "", n, n);

        return output;
    }

    void generate(List<String> result, String curr, int open, int close) {
        if (open > close)
            return;

        if (open == 0 && close == 0) {
            result.add(curr);
            return;
        }

        if (open >= 0)
            generate(result, curr + "(", open - 1, close);

        if (close >= 0)
            generate(result, curr + ")", open, close - 1);
    }
}

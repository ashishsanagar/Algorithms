package learn.ashish.algorithms.misc;

import java.util.ArrayList;
import java.util.List;

public class PhoneLetterCombinations {

    /**
     * 2 -> abc, 3 -> def ... 9 -> wxyz
     * if input = 23, find all combination strings
     * output: ["ad","ae","af","bd","be","bf", "cd","ce","cf"]
     *
     * @param args
     */
    public static void main(String[] args) {
        String[] phone = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        String digits = "23";

        List<String> result = new PhoneLetterCombinations().find(phone, digits);

        for (String s : result)
            System.out.print(s + " ");
    }

    public List<String> find(String[] phone, String digits) {
        List<String> result = new ArrayList<>();

        if (digits == null || digits.length() < 1) return result;

        recursive(result, digits, phone, "", 0);

        return result;
    }

    private void recursive(List<String> result, String digits, String[] phone, String current, int index) {
        if (current.length() == digits.length()) {
            result.add(current);
            return;
        }

        String chars = phone[digits.charAt(index) - '0'];

        for (char c : chars.toCharArray()) {
            recursive(result, digits, phone, current + c, index + 1);
        }
    }
}


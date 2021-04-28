package learn.ashish.algorithms.stackqueue;

import java.util.Stack;

/**
 * @author asanagar
 */
public class BalancedParenthesisCheck {

    public static void main(String args[]) {
        String goodCode = "{}[]{}";

        BalancedParenthesisCheck obj = new BalancedParenthesisCheck();
        System.out.println(goodCode + ": " + obj.isbalanced(goodCode));

        String badCode = "{}[{]{}";
        System.out.println(badCode + ": " + obj.isbalanced(badCode));
    }

    public boolean isbalanced(String s) {
        if (s == null || s.isEmpty()) return true;

        Stack<Character> stack = new Stack<>();

        for (Character c : s.toCharArray()) {
            if (c == '[' || c == '{' || c == '(') stack.push(c);

            if ((c == ']' && (stack.isEmpty() || stack.pop() != '['))
                    || (c == '}' && (stack.isEmpty() || stack.pop() != '{'))
                    || (c == ')' && (stack.isEmpty() || stack.pop() != '(')))
                return false;

        }

        return stack.isEmpty();
    }
}

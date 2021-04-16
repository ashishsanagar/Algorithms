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

    public boolean isbalanced(String code) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < code.length(); i++) {
            char charValue = code.charAt(i);

            if (charValue == '[' || charValue == '(' || charValue == '{') {
                stack.push(new Character(charValue));
            } else if (charValue == ']') {
                if (stack.isEmpty() || stack.pop() != '[') {
                    return false;
                }
            } else if (charValue == ')') {
                if (stack.isEmpty() || stack.pop() != '(') {
                    return false;
                }
            } else if (charValue == '}') {
                if (stack.isEmpty() || stack.pop() != '{') {
                    return false;
                }
            }

        }
        return stack.isEmpty();
    }
}

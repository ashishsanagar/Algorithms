package learn.ashish.algorithms.stackqueue;

import java.util.Stack;


public class MakeStringParenthesisBalanced {

    /**
     * Given a string with alpha-numeric characters and parentheses, return a string with balanced parentheses by removing the fewest characters possible. You cannot add anything to the string.
     * <p>
     * balance("()")->"()"
     * balance("a(b)c)")->"a(b)c"
     * balance(")(")->""
     * <p>
     * balance("))(())")->"(())"
     * balance("")->""
     * balance("(((((")->""
     */
    public static void main(String[] args) {
        System.out.println(new MakeStringParenthesisBalanced().balance(")("));
        System.out.println(new MakeStringParenthesisBalanced().balance("))(())"));
        System.out.println(new MakeStringParenthesisBalanced().balance("(()()()a(b(c(("));
        System.out.println(new MakeStringParenthesisBalanced().balance("()"));
        System.out.println(new MakeStringParenthesisBalanced().balance("a(b)c)"));
    }

    private String deleteChar(String str, int index) {
        return new StringBuilder(str).deleteCharAt(index).toString();
    }

    public String balance(String str) {
        if (str == null || str.length() < 1)
            return str;

        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char nextChar = str.charAt(i);

            if (nextChar == '(')
                stack1.push(i);
            else if (nextChar == ')') {
                if (!stack1.isEmpty())
                    stack1.pop();
                else
                    stack2.push(i);
            }
        }

        while (!stack1.isEmpty())
            str = deleteChar(str, stack1.pop());

        while (!stack2.isEmpty())
            str = deleteChar(str, stack2.pop());

        return str;
    }
}

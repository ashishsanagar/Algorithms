package learn.ashish.algorithms.strings;

/**
 * @author Ashish Sanagar
 */
public class RemoveDuplicateChars {

    public static void main(String[] args) {
        RemoveDuplicateChars obj = new RemoveDuplicateChars();

        System.out.println(obj.remove("aaaa"));

        System.out.println(obj.remove("ashish"));

        System.out.println(obj.remove(null));
    }

    public String remove(String str) {
        if (str == null || str.length() < 2)
            return str;

        boolean[] visited = new boolean[256];
        StringBuilder sb = new StringBuilder();

        for (char c : str.toCharArray()) {
            if (visited[c])
                continue;
            else {
                visited[c] = true;
                sb.append(c);
            }
        }

        return sb.toString();
    }
}

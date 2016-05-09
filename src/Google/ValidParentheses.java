package Google;

import java.util.Deque;
import java.util.LinkedList;

public class ValidParentheses {
    public boolean isValid(String s) {
        if (s == null || s.length() % 2 != 0) {
            return false;
        }
        
        Deque<Character> stack = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c== '[' || c == '{') {
                stack.offerFirst(c);
            } else if (stack.isEmpty()) {
                return false;
               } else {
                char prev = stack.peek();
                if (c == ')' && prev == '(' ) {
                    stack.pollFirst();
                }  else if (c == ']' && prev == '[' ) {
                    stack.pollFirst();
                } else if (c == '}' && prev == '{' ) {
                    stack.pollFirst();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
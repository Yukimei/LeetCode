package Google;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;
//a faster method is go from beginning to the end
//1. use num  (to record the current number)
//2. use result ( to record current res before '(' )
//3. use sign to record the sign before a number
public class BasicCalculator {
	// a faster method is go from beginning to the end
    public int calculate(String s) {
        int num = 0;
        int res = 0;
        int sign = 1;
        Stack<Integer> stack= new Stack<>();
        int i = 0;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            } else if (c == '+') {
                res += sign * num;
                sign = 1;
                num = 0;
            } else if (c == '-') {
                res += sign * num;
                sign = -1;
                num = 0;
            } else if (c == '(') {
                stack.push(res);
                stack.push(sign);
                sign = 1;
                res = 0;
            } else if (c == ')') {
                res += sign * num;
                num = 0;
                res *= stack.pop();
                res += stack.pop();
            }
        }
        res += num * sign;
        return res;
    }
	public int calculate2(String s) {
		if (s == null) {
			return 0;
		}
		Deque<Integer> nums = new LinkedList<>();
		Deque<Character> signs = new LinkedList<>();

		for (int i = 0; i < s.length();) {
			if (s.charAt(i) == ' ') {
				i++;
				continue;
			}
			int start = i;
			while (i < s.length() && Character.isDigit(s.charAt(i))) {
				i++;
			}
			if (start != i) {
				int num = Integer.parseInt(s.substring(start, i));
				nums.offerFirst(num);
			} else {
				if (s.charAt(i) != ')') {
					signs.offerFirst(s.charAt(i));
				} else {
					int sum = 0;
					while (signs.peekFirst() != '(') {
						char sign = signs.pollFirst();
						if (sign == '+') {
							sum += nums.pollFirst();
						} else {
							sum -= nums.pollFirst();
						}
					}
					nums.offerFirst(sum + nums.pollFirst());
					signs.pollFirst();
				}
				i++;
			}
		}
		int sum = 0;
		while (!nums.isEmpty() && !signs.isEmpty()) {
			char sign = signs.pollFirst();
			if (sign == '+') {
				sum += nums.pollFirst();
			} else {
				sum -= nums.pollFirst();
			}
		}
		if (!nums.isEmpty()) {
			sum += nums.pollFirst();
		}
		return sum;
	}
	public static void main(String[] args) {
		BasicCalculator b = new BasicCalculator();
//		System.out.println(b.calculate("(1+(4+5+2)-3)+(6+8)"));
		System.out.println(b.calculate("5     "));
	}
}
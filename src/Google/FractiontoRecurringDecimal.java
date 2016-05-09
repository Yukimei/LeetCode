package Google;

import java.util.HashMap;
import java.util.Map;

public class FractiontoRecurringDecimal {
	public String fractionToDecimal(int numerator, int denominator) {
		if (numerator == 0) {
			return "0";
		}

		StringBuilder sb = new StringBuilder();
		// sign
		sb.append((numerator > 0) ^ (denominator > 0) ? "-" : "");
		long num = Math.abs((long) numerator); // the inside need to cast to
												// long, otherwise it may have
												// the overflow problem
		long den = Math.abs((long) denominator);
		// integral part
		sb.append(num / den);
		num %= den;
		if (num == 0) {
			return sb.toString();
		}

		// fraction
		sb.append(".");
		Map<Long, Integer> map = new HashMap<>();
		map.put(num, sb.length());
		while (num != 0) {
			num *= 10;
			sb.append(num / den);
			num %= den;
			if (map.containsKey(num)) { // if map contains, that means this is
										// the another starting of the previous
										// repeating, so add quote () and break
										// to exit;
				int index = map.get(num);
				sb.insert(index, "(");
				sb.append(")");
				break;
			} else {
				map.put(num, sb.length());
			}
		}
		return sb.toString();
	}
}
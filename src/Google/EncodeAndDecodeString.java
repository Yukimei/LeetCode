package Google;

import java.util.ArrayList;
import java.util.List;
// length +  SPILITTER + str
// it can make sure that it must start with number, then splitter. and move the index to the right place
// can use startsWith(SPLITTER)  to get the index location of the Length
public class EncodeAndDecodeString {
    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder res = new StringBuilder();
        for (String s : strs) {
            res.append(s.length()).append("#").append(s);
        }
        return res.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        int i = 0;
        List<String> res = new ArrayList<>();
        while (i < s.length()) {
            int digit = i;
            while (Character.isDigit(s.charAt(digit))) {
                digit++;
            }
            int len = Integer.parseInt(s.substring(i, digit));
            i = digit + 1 + len;
            res.add(s.substring(digit + 1, i));
        }
        return res;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));
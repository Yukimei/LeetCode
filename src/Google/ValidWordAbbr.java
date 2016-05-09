package Google;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
// key for this question is about communication
public class ValidWordAbbr {
    Map<String, Integer> map;
    Set<String> set;
    public ValidWordAbbr(String[] dictionary) {
        map = new HashMap<String, Integer>();
        if (dictionary == null || dictionary.length == 0) {
            return;
        }
        set = new HashSet<String>();
        for (String s : dictionary) {
            if (set.contains(s)) {
                continue;
            }
            set.add(s);
            String tmp = getAbbr(s);
            if (!map.containsKey(tmp)) {
                map.put(tmp, 1);
            } else {
                map.put(tmp, map.get(tmp) + 1);
            }
        }
    }

    public boolean isUnique(String word) {
        String tmp = getAbbr(word);
        return !map.containsKey(tmp) ? true : map.get(tmp) <= 1 && set.contains(word);
    }
    
    private String getAbbr(String s) {
            if (s.length() > 2) {
                StringBuilder sb = new StringBuilder();
                sb.append(s.charAt(0)).append(s.length() - 2).append(s.charAt(s.length() -1));
                return sb.toString();
            } else {
                return s;
            }
    }
    
}


// Your ValidWordAbbr object will be instantiated and called as such:
// ValidWordAbbr vwa = new ValidWordAbbr(dictionary);
// vwa.isUnique("Word");
// vwa.isUnique("anotherWord");
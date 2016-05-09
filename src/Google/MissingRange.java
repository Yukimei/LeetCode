package Google;

import java.util.ArrayList;
import java.util.List;

public class MissingRange {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<>();
        if (nums == null) {
            return res;
        }
        int start = lower - 1;
        for (int i = 0; i < nums.length; i++) {
            
            if (start < nums[i] - 2) {
                StringBuilder sb = new StringBuilder();
                sb.append(start + 1).append("->").append(nums[i] - 1);
                res.add(sb.toString());
            } else if (start == nums[i] - 2) {
                System.out.println(nums[i]);
                res.add(String.valueOf(start + 1));
            }
             start = nums[i];
        }
        if (start < upper - 1) {
            
            // res.add((start + 1) + "->" + upper);
            res.add(new StringBuilder().append(start + 1).append("->").append(upper).toString());
        } else if (start == upper - 1) {
            res.add(String.valueOf(upper));
        }
        return res;
    }
}
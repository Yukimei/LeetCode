package Google;
//binary search
// only care whether it is  /   or  \  , the peak must be the largest

public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int start = 0, end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] < nums[mid + 1]) {
                start = mid + 1;
            } else {
                end = mid;
            } 
        }
        return nums[start] > nums[end] ? start : end;
    }
} 
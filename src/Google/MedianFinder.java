package Google;

import java.util.PriorityQueue;

//notice that we keep that  maxHeap.size() == minHeap.size()   or maxHeap.size() = minHeap.size() + 1
class MedianFinder {
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(20, new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    });
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    
    // Adds a number into the data structure.
    public void addNum(int num) {
        if (maxHeap.isEmpty()) {
            maxHeap.offer(num);
            return;
        }
        if (num <= maxHeap.peek()) {
            maxHeap.offer(num);
        } else {
            minHeap.offer(num);
        }
        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.offer(maxHeap.poll());
        } else if (minHeap.size() > maxHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }

    // Returns the median of current data stream
    public double findMedian() {
        if (minHeap.isEmpty()) {
            return maxHeap.peek();
        }
        if (minHeap.size() == maxHeap.size()) {
            return (minHeap.peek() + maxHeap.peek()) / 2.0;
        }
        return maxHeap.peek();
    }
};

// Your MedianFinder object will be instantiated and called as such:
// MedianFinder mf = new MedianFinder();
// mf.addNum(1);
// mf.findMedian();
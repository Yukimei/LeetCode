package Google;

import java.util.Deque;
import java.util.LinkedList;

public class MinStack {
    Deque<Integer> stack = new LinkedList<Integer>();
    Integer min = null;
   
    /** initialize your data structure here. */
    public MinStack() {
        
    }
    
    public void push(int x) {
        if (min == null) {
            min = x;
        }
        stack.offerFirst(x - min);
        if (x < min) {
            min = x;
        }
    }
    
    public void pop() {
        if (stack.peekFirst() < 0) {
            min -= stack.pollFirst();
        } else {
            stack.pollFirst();
        }
    }
    
    public int top() {
        if (stack.peekFirst() < 0) {
            return min;
        } else {
            return stack.peekFirst();
        }
    }
    
    public int getMin() {
        return min;
    }
    public static void main(String[] args) {
    	 //   1, 2, 3, 0
        //   1, 1, 1
        //   min 1,  0  4,  5
        //   0, 1, 2, -1,  4, 5 
    	 MinStack obj = new MinStack();
    	  obj.push(1);
    	  System.out.println("*****");
    	  System.out.println("peek = " + obj.top());
    	  System.out.println(" min = " + obj.getMin());
    	  obj.push(2);
    	  System.out.println("*****");
    	  System.out.println("peek = " + obj.top());
    	  System.out.println(" min = " + obj.getMin());
    	  obj.push(3);
    	  System.out.println("*****");
    	  System.out.println("peek = " + obj.top());
    	  System.out.println(" min = " + obj.getMin());
    	  obj.push(0);
    	  System.out.println("*****");
    	  System.out.println("peek = " + obj.top());
    	  System.out.println(" min = " + obj.getMin());
    	  obj.push(4);
    	  System.out.println("*****");
    	  System.out.println("peek = " + obj.top());
    	  System.out.println(" min = " + obj.getMin());
    	  obj.push(5);
    	  System.out.println("*****");
    	  System.out.println("peek = " + obj.top());
    	  System.out.println(" min = " + obj.getMin());
    	  obj.pop();
    	  obj.pop();
    	  System.out.println("*****");
    	  System.out.println("peek = " + obj.top());
    	  System.out.println(" min = " + obj.getMin());
    	  obj.pop();
    	  System.out.println("*****");
    	  System.out.println("peek = " + obj.top());
    	  System.out.println(" min = " + obj.getMin());
    	  obj.pop();
    	  System.out.println("*****");
    	  System.out.println("peek = " + obj.top());
    	  System.out.println(" min = " + obj.getMin());
    	  obj.pop();
    	  System.out.println("*****");
    	  System.out.println("peek = " + obj.top());
    	  System.out.println(" min = " + obj.getMin());

    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
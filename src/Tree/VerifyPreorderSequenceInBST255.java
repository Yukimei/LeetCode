package Tree;
import java.util.Deque;
import java.util.LinkedList;

//stack stores all the left subtree node of current node
//use preorder[] as a stack
public class VerifyPreorderSequenceInBST255 {
	public boolean verifyPreorder(int[] preorder) {
		// use the preorder array to immitate a stack
		int i = -1;
		int low = Integer.MIN_VALUE;
		for (int p : preorder) {
			if (p < low) {
				return false;
			}
			while (i != -1 && p > preorder[i]) {
				// remember to update low
				low = preorder[i--];
			}
			preorder[++i] = p;
		}
		return true;
	}

	public boolean verifyPreorder2(int[] preorder) {
		// stack里存的一定是当前最小的
		Deque<Integer> stack = new LinkedList<>();
		int low = Integer.MIN_VALUE;
		for (int p : preorder) {
			if (p < low) {
				return false;
			}
			while (!stack.isEmpty() && p > stack.peekFirst()) {
				// remember to update low
				low = stack.pollFirst();
			}
			stack.offerFirst(p);
		}
		return true;
	}

}

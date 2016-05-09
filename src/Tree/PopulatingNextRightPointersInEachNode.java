package Tree;

import java.util.Deque;
import java.util.LinkedList;
// need to do in O(1) space
//the key here is to use cur, and cur.left to decide the level (tmp controls the current level)
//use next pointer to do the level traversal
public class PopulatingNextRightPointersInEachNode {
	class TreeLinkNode {
		int val;
		TreeLinkNode left, right, next;

		TreeLinkNode(int x) {
			val = x;
		}
	}
	
    //the key here is to use cur, and cur.left to decide the level (tmp controls the current level)
    //use next pointer to do the level traversal
    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        TreeLinkNode cur = root;
        while (cur.left != null) {
            TreeLinkNode tmp = cur;
            while (tmp!= null) {
                tmp.left.next = tmp.right;
                if (tmp.next != null) {
                    tmp.right.next = tmp.next.left;
                }
                tmp = tmp.next;
            }
            cur = cur.left;
        }
    }
    /**
        1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \  / \
    4->5->6->7 -> NULL
    */
    public void connect2(TreeLinkNode root) {
        TreeLinkNode cur = root;
        while(cur != null && cur.left != null) {
            cur.left.next = cur.right;
            TreeLinkNode temp = cur;
            while (temp.next != null) {
                temp.right.next = temp.next.left;
                temp = temp.next;
                temp.left.next = temp.right;
            }
            cur = cur.left;
        }
    }
	public void connect3(TreeLinkNode root) {
		if (root == null) {
			return;
		}
		// do bfs to add right pointer
		Deque<TreeLinkNode> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			TreeLinkNode pre;
			pre = queue.poll();
			enque(pre, queue);
			size--;
			for (int i = 0; i < size; i++) {
				TreeLinkNode cur = queue.poll();
				enque(cur, queue);
				pre.next = cur;
				pre = cur;
			}
			pre.next = null;
		}
	}

	private void enque(TreeLinkNode node, Deque<TreeLinkNode> queue) {
		if (node.left != null) {
			queue.offer(node.left);
		}
		if (node.right != null) {
			queue.offer(node.right);
		}
	}
}

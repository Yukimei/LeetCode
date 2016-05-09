package Tree;

import java.util.Deque;
import java.util.LinkedList;

import Tree.PopulatingNextRightPointersInEachNode.TreeLinkNode;
// key :
// do all next connections of the next level on the current level
// do level move with next pointer
// so need three pointers
// 1. head (next level's head)
// 2. pre  (next level's leading node)
// 3. cur  (this level's node)
public class PopulatingNextRightPointersInEachNodeII {
/**
    1 -> NULL
  /  \
 2 -> 3 -> NULL
/ \    \
4-> 5 -> 7 -> NULL
*/
    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        TreeLinkNode pre = null; // leading node on next level
        TreeLinkNode head = null;// head node on next level
        TreeLinkNode cur = root; // current node of current level
        while (cur != null) {
            while (cur != null) {
                // left child
                if (cur.left != null) {
                    if (pre == null) {
                        head = cur.left; // head of the next level
                    } else {
                        pre.next = cur.left;
                    }
                    pre = cur.left;
                }
                // right child
                if (cur.right != null) {
                    if (pre == null) {
                        head = cur.right;
                    } else {
                        pre.next = cur.right;
                    }
                    pre = cur.right;
                }
                //move to next node
                cur = cur.next;
            }
            // move to next level
            cur = head;
            pre = null;
            head = null;
        }
    }

    
	public void connect2(TreeLinkNode root) {
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

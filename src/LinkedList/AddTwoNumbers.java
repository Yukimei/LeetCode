package LinkedList;

public class AddTwoNumbers {
	//特别注意linkedlist最好都用dummy head （也就是每次都是处理dummy.next)
	//这样比较不容易遇到null pointer exception
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int carry = 0;
		ListNode dummy = new ListNode(-1);
		ListNode head = dummy;
		while (l1 != null && l2 != null) {
			dummy.next = new ListNode(l1.val + l2.val + carry);
			carry = 0;
			if (dummy.next.val > 9) {
				dummy.next.val -= 10;
				carry = 1;
			}
			dummy = dummy.next;
			l1 = l1.next;
			l2 = l2.next;
		}
		while (l1 != null) {
			dummy.next = new ListNode(l1.val + carry);
			carry = 0;
			if (dummy.next.val > 9) {
				dummy.next.val -= 10;
				carry = 1;

			}
			dummy = dummy.next;
			l1 = l1.next;
		}
		while (l2 != null) {
			dummy.next = new ListNode(l2.val + carry);
			carry = 0;
			if (dummy.next.val > 9) {
				dummy.next.val -= 10;
				carry = 1;

			}
			dummy = dummy.next;
			l2 = l2.next;
		}
		if (carry == 1) {
			dummy.next = new ListNode(1);
		}
		return head.next;
	}

	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public static void main(String[] args) {
		AddTwoNumbers a = new AddTwoNumbers();
		ListNode l1 = a.new ListNode(2);
		ListNode h1 = l1;
		ListNode l2 = a.new ListNode(5);
		ListNode h2 = l2;
		l2 = l2.next;
		l2 = a.new ListNode(0);
		System.out.println(h2.next.val);
	}
}
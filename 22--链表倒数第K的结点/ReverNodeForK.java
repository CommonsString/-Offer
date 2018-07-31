package jianzhiOffer;


/**
 * @author commonsstring@gmail.com
 * 题目：链表中倒数第K个结点
 */
class ListNodeS{
	int val;
	ListNodeS next = null;
	public ListNodeS(int val) {
		this.val = val;
	}
}
	
public class ReverNodeForK {

	
	public static void main(String[] args) {
		ListNodeS head = new ListNodeS(1);
		ListNodeS head2 = new ListNodeS(2);
		ListNodeS head3 = new ListNodeS(3);
		head.next = head2;
		head2.next = head3;
		ListNodeS node = FindKthToTail(head, 1);
//		ListNodeS ss = reverList(head);
//		System.out.println(ss.next.val);
		System.out.println(node.val);
//		System.out.println(getLength(head));
	}
	
	/**
	 * 反转链表
	 * @param head
	 * @return
	 */
	public static ListNodeS reverList(ListNodeS head){
		if(head == null) return null;
		ListNodeS next = null;
		ListNodeS previous = null;
		while(head != null){
			next = head.next;
			head.next = previous;
			previous = head;
			head = next;
		}
		return previous; 
	}
	/**
	 * 获取长度
	 * @param head
	 * @return
	 */
	public static int getLength(ListNodeS head){
		if(head == null) return -1;
		ListNodeS current = head;
		int count = 0;
		while(current != null){
			count++;
			current = current.next;
		}
		return count;
	}
	/**
	 * 方法一：反转链表, 正数第K个
	 * @param head
	 * @param K
	 * @return
	 */
	public static ListNodeS FindKthToTail(ListNodeS head, int K){
		//参数检查
		if(head == null) return null;
		if(K > getLength(head) || K < 0){
			throw new RuntimeException("链表长度小于K！");
		}
		int count = 0;
		ListNodeS current = reverList(head);
		ListNodeS parent = current;
		while(current != null && count < K){
			parent = current;
			current = current.next;
			count++;
		}
		return parent;
	}
	
	
}

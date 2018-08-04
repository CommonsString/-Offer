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
		ListNodeS head4 = new ListNodeS(4);
		ListNodeS head5 = new ListNodeS(5);
		head.next = head2;
		head2.next = head3;
		head3.next = head4;
		head4.next = head5;
		ListNodeS node = reverListSecond(head, 1);
//		ListNodeS ss = reverList(head);
//		System.out.println(ss.next.val);
		System.out.println(node.val);
//		System.out.println(getLength(head));
	}
	
	
	/**
	 * 方法二：指针法, 限制只能遍历一次链表
	 * 声明指针：M = K - 1, 下标从1开始
	 *        N = 1, 指向头
	 * 之后两指针同时向前移动，直到M到达尾部       	  
	 * 返回N
	 */
	public static ListNodeS reverListSecond(ListNodeS head, int K){
		//参数检查
		if(head == null || K == 0) return null;
		int len = getLength(head);
		if(K > len){
			return null;
		}
		//定位
		ListNodeS c_p1 = head;
		ListNodeS c_p2 = null;
		//定位到K - 1位置
		for(int i = 0; i < K - 1; i++){
			if(c_p1.next != null){
				c_p1 = c_p1.next;
			}else{
				return null;
			}
		}
		c_p2 = head;
		//next不等于空
		while(c_p1.next != null){
			c_p1 = c_p1.next;
			c_p2 = c_p2.next;
		}
		return c_p2;
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

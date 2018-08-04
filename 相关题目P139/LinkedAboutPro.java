package jianzhiOffer;


/**
 * @author commonsstring@gmail.com
 * 
 * 相关题目P138 : 求链表的中间点, 奇数直接返回中点, 偶数返回中间两个任意一个
 */

public class LinkedAboutPro {
	
	
	public static void main(String[] args) {
		ListNodeS head = new ListNodeS(1);
		ListNodeS head2 = new ListNodeS(2);
		ListNodeS head3 = new ListNodeS(3);
//		ListNodeS head4 = new ListNodeS(4);
//		ListNodeS head5 = new ListNodeS(5);
		head.next = head2;
		head2.next = head3;
//		head3.next = head4;
//		head4.next = head5;
		ListNodeS node = getMiddleNode(head);
		System.out.println(node.val);
	}
	
	/**
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
	 * 方法二：两个指针法, 同时从头结点出发
	 */
	public static ListNodeS getMiddleNodeSecond(ListNodeS head){
		//参数检查
		if(head == null) return null;
		//一次一步
		ListNodeS c_p1 = head;
		//一次两步
		ListNodeS c_p2 = head;
		while(c_p2.next != null){
			c_p1 = c_p1.next;
			c_p2 = c_p2.next.next;
		}
		return c_p1;
	}
	
	/**
	 * 方法一：常规法
	 * @param head
	 * @return
	 */
	public static ListNodeS getMiddleNode(ListNodeS head){
		//参数检查
		if(head == null) return null;
		int len = getLength(head);
		if(len < 1){
			return null;
		}
		int isJO = len & 1;
		//中点
		int mid = len >> 1;
		//奇数
		ListNodeS current = head;
		if(isJO != 0){
			for(int i = 0; i < mid; i++){
				if(current != null){
					current = current.next;
				}
			}
		}else{ //偶数
			for(int i = 0; i < mid; i++){
				if(current != null){
					current = current.next;
				}
			}
		}
		return current;			
	}
	
}

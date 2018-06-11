package jianzhiOffer;

import java.util.Stack;

/**
 * @author commonsstring@gmail.com
 * 
 * 题目 : 从尾到头打印链表
 */

class ListNode{
	int value;
	ListNode next;
}

public class LinkedListRerver {

	/**
	 * 测试用例
	 */
	public static void main(String[] args) {
		ListNode head = new ListNode();
		ListNode node1 = new ListNode();
		ListNode node2 = new ListNode();
		head.value = 1;
		head.next = node1;
		node1.value = 2;
		node1.next = node2;		
		node2.value = 3;
		node2.next = null;
//		showLinkedSecond(head);
		showLinkedThree(head);
		
	}
	
	
	/**
	 * 方法一：栈+链表遍历
	 * 时间复杂度：O(N)
	 * 空间复杂度：O(N)
	 * 思路：
	 *  遍历链表, 将每一个数压入栈, 然后依次栈弹出。
	 */
	public static void showLinkedFirst(ListNode node){
		//参数检查
		if(node == null) return ;
		//只有头结点
		if(node.next == null){
			System.out.print(node.value);
			return;
		}
		Stack<ListNode> myStack = new Stack<ListNode>();
		ListNode pNode = node;
		while(pNode != null){
			myStack.push(pNode);
			pNode = pNode.next;
		}
		while(!myStack.isEmpty()){
			ListNode temp = myStack.pop();
			System.out.print(temp.value + " ");
		}
	}
	
	
	/**
	 * 方法二：递归
	 * 思路：
	 *  讲道理, 能用栈的地方, 一般能用递归实现。
	 *  所以, 尝试着用递归
	 */
	public static void showLinkedSecond(ListNode node){
		if(node == null) return;
		if(node.next != null){
			showLinkedSecond(node.next);
		}
		System.out.print(node.value + " ");
		
/*		if(node != null){
			if(node.next != null){
				showLinkedSecond(node.next);
			}
			System.out.println(node.value + " ");
		}
*/
	}
	
	/**
	 * 方法三：修改数组结构, 即反转链表
	 * 思路：
	 *  将链表的指针, 全部调转方向。
	 *  遍历输出
	 */
	//反转链表 https://blog.csdn.net/xyh269/article/details/70238501
	public static ListNode LinkedRever(ListNode head){
		ListNode preNode = null;
		ListNode nextNode = null;
		while(head != null){
			nextNode = head.next;
			head.next = preNode;	
			preNode = head;
			head = nextNode;
		}
		return preNode;
		
	}
	public static void showLinkedThree(ListNode node){
		//参数检查
		if(node == null) return ;
		//反转链表
		ListNode head = LinkedRever(node);
		while(head != null){
			System.out.println(head.value);
			head = head.next;
		}
	}
	
}

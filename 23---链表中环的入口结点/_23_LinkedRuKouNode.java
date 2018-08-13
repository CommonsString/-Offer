package jianzhiOffer;

/**
 * 链表的入口结点
 * 前置： 需要判断链表是否包含环
 * @author Administrator
 *
 */
class ListNodeC{
    int val;
    ListNodeC next = null;
	public ListNodeC(int val) {
		this.val = val;
	}
}	
public class _23_LinkedRuKouNode {
	
	public static void main(String[] args) {
		ListNodeC head = new ListNodeC(1);
		ListNodeC node2 = new ListNodeC(2);
		ListNodeC node3 = new ListNodeC(3);
		ListNodeC node4 = new ListNodeC(4);
		ListNodeC node5 = new ListNodeC(5);
		ListNodeC node6 = new ListNodeC(6);
//		head.next = node2;
//		node2.next = node3;
//		node3.next = node4;
//		node4.next = node5;
//		node5.next = node6;
//		node6.next = node4;
		System.out.println(EntryNodeOfLoop(head));
	}
	
	
	
	/**
	 * 思路：获取相遇结点, 即可求成环的结点个数
	 * 
	 */
	public static ListNodeC EntryNodeOfLoop(ListNodeC pHead){
		//参数检查
		if(pHead == null) return pHead;
		//相遇结点
		ListNodeC meetNode = isQun(pHead);
		if(meetNode == null) return null;
		ListNodeC current = meetNode;
		int count = 1;
		while(current.next != meetNode){
			current = current.next;
			count++;
		}
		//移动逻辑
		ListNodeC p1 = pHead;
		ListNodeC p2 = pHead;
		//p2向前移动cout步
		int step = 0;
		while(step++ < count){
			p2 = p2.next;
		}
		while(p1 != p2){
			p1 = p1.next;
			p2 = p2.next;
		}
		return p1;
	}
	
	
	/**
	 * 判断是否有环
	 * @return
	 */
	public static ListNodeC isQun(ListNodeC head){
		if(head == null) return null;
		ListNodeC p1 = head;
		ListNodeC p2 = head;
		//只有头结点
		if(head.next == null) return null;
		while(p2 != null && p1 != null){
			//走一步
			p1 = p1.next;
			if(p2.next.next == null){
				return null;
			}
			//走两步
			p2 = p2.next.next;
			if(p1 == p2){
				return p1;
			}
		}
		return head;
	}
	
	
}

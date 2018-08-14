package jianzhiOffer;



/**
 * 合并两个排序的链表
 * 递归合并的过程
 */
public class _25_BathTwoLinkedList {
	
	public static void main(String[] args) {
		ListNodeC l1 = new ListNodeC(1);
		ListNodeC l3 = new ListNodeC(3);
		ListNodeC l5 = new ListNodeC(5);
//		ListNodeC l7 = new ListNodeC(7);
		l1.next = l3;
		l3.next = l5;
//		l5.next = l7;
		
		ListNodeC l2 = new ListNodeC(1);
		ListNodeC l4 = new ListNodeC(3);
		ListNodeC l6 = new ListNodeC(5);
//		ListNodeC l8 = new ListNodeC(8);
		l2.next = l4;
		l4.next = l6;
//		l6.next = l8;	
		
		ListNodeC c = Merge(l1, l2);
		while(c != null){
			System.out.print(c.val + " ");
			c = c.next;
		}
	}
	
	/**
	 * 方法一： 
	 * @return
	 */
	public static ListNodeC Merge(ListNodeC list1, ListNodeC list2){
		//list1为空, 合并后为list2
		if(list1 == null) return list2;
		if(list2 == null) return list1;
		
		//合并后的新头结点
		ListNodeC currentNode = null;
		if(list1.val < list2.val){
			currentNode = list1;
			currentNode.next = Merge(list1.next, list2);
		}else{
			currentNode = list2;
			currentNode.next = Merge(list1, list2.next);
		}
		return currentNode;
	}
	
} 

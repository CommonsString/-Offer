package jianzhiOffer;

import java.util.ArrayList;

/**
 * @author commonsstring@gmail.com
 * 
 * 题目 : 删除链表中的重复结点 
 */

class ListNodeDel{
	int val;
	ListNodeDel next = null;
	ListNodeDel(int val){
		this.val = val;
	}
}

public class DeleteDuptpleLinkedList {
	

	public static void main(String[] args) {
		ListNodeDel head = new ListNodeDel(1);
		ListNodeDel node2 = new ListNodeDel(2);
		ListNodeDel node3 = new ListNodeDel(3);
		ListNodeDel node4 = new ListNodeDel(3);
		ListNodeDel node5 = new ListNodeDel(4);
		ListNodeDel node6 = new ListNodeDel(4);
		ListNodeDel node7 = new ListNodeDel(7);
		head.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		node6.next = node7;
		show(head);
		ListNodeDel sh = deleteDuplicationV2(head);
		System.out.println();
		show(sh);
		
	}
	
	/**
	 * 方法三：递归思想
	 * https://www.jianshu.com/p/7627d3c665d5
	 * @param head
	 */
	public static ListNodeDel deleteDuplicationV2(ListNodeDel head){
		//递归结束条件, 当前是0/1个结点
		if(head == null || head.next == null){
			return head;
		}
		ListNodeDel current = head;
		//当前结点与下一个结点重复
		if(current.val == current.next.val){
			ListNodeDel next = current.next;
			//跳过与当前结点重复的所有结点，寻找下一个不重复的结点
			while(current != null && current.val == next.val){
				current = current.next;
			}
			//从第一个与当前结点不同的结点，开始递归
			return deleteDuplicationV2(current);
		}else{
			//当前结点不是重复结点, 保留当前结点，从下一个结点开始递归
			current.next = deleteDuplicationV2(current.next);
			return current;
		}
	}
	
	
	
	
	
	
	/**
	 * 方法二：标准思想
	 * 	思路：
	 * 	每次判断当前结点的值与下一结点的值是否重复
	 * 	如果重复就循环寻找下一个不重复的结点
	 * @param head
	 */
	public static ListNodeDel deleteDuplication(ListNodeDel head){
		//参数检查
		if(head == null) return head;
		ListNodeDel perious = null;
		ListNodeDel current = head;
		while(current != null){
			//下一个结点
			ListNodeDel next = current.next;
			boolean isDel = false;
			if(next != null && current.val == next.val){
				isDel = true;
			}
			if(!isDel){
				perious = current;
				current = current.next;
			}else{
				int val = current.val;
				//待删除节点
				ListNodeDel delNode = current;
				while(delNode != null && delNode.val == val){
					//移动
					next = delNode.next;
					delNode = null;
					delNode = next;
				}
				if(perious == null){
					head = next;
				}else{
					//删除重复结点后，将perious指向不重复的最后一个结点
					perious.next = next;
				}
				current = next;
			}
		}
		return head;
	}
	
	
	
	public static void show(ListNodeDel head){
		ListNodeDel current = head;
		while(current != null){
			System.out.print(current.val + " ");
			current = current.next;
		}
	}
	public static void delNode(ListNodeDel head, int val){
		//参数检查
		if(head == null) return ;
		//删除头结点
		if(head.val == val){
			@SuppressWarnings("unused")
			ListNodeDel temp = head;
			head = head.next;
			temp = null;
		}else{
			ListNodeDel current = head;
			ListNodeDel perious = head;
			while(current.val != val){
				perious = current;
				current = current.next;
			}
			perious.next = current.next;
			current = null;
		}
	}
	/**
	 * 方法一：蛮力法(错误思想)
	 * 
	 * @param head
	 * @return
	 */
	public static ListNodeDel deleteCoupleLinked(ListNodeDel head){
		//参数检查
		if(head == null) return head;
		ListNodeDel current = head;
		//辅助容器
		ArrayList<Integer> set = new ArrayList<>();
		while(current != null){
			set.add(current.val);
			current = current.next;
		}
		ListNodeDel iteraNode = head;
		//删除
		while(iteraNode != null){
			int val = iteraNode.val;
			iteraNode = iteraNode.next;
			//存在删除
			if(set.contains(val)){
				delNode(head, val);
			}
		}
 		return head;
	}
	
}

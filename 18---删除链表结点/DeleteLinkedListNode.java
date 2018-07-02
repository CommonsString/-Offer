package jianzhiOffer;

/**
 * 
 * @author commonsstring@gmail.com
 * 
 * 题目 : 删除链表的结点
 *
 */
class LinkedNode{
	 int data;
	 LinkedNode next;
	public LinkedNode(int data) {
		this.data = data;
	}
	 
}
public class DeleteLinkedListNode {
	
	public static void main(String[] args) {
		
		LinkedNode head = new LinkedNode(1);
		LinkedNode node2 = new LinkedNode(2);
		LinkedNode node3 = new LinkedNode(3);
		head.next = node2;
		node2.next = node3;
		show(head);
		deleteNodeB(head, node3);
		System.out.println();
		show(head);
	}
	
	public static void show(LinkedNode head){
		if(head == null) return ;
		LinkedNode tempNode = head;
		while(tempNode != null){
			System.out.print(tempNode.data + " ");
			tempNode = tempNode.next;
		}
	}
	
	
	/**
	 * 方法一: 常规遍历法
	 * 时间复杂度O(N)
	 * 遍历, 寻找删除结点的前一个结点。
	 * @param head
	 * @param delNode
	 */
	@SuppressWarnings("unused")
	public static void deleteNode(LinkedNode head, LinkedNode delNode){
		//参数检查
		if(head == null || delNode == null) return ;
		//删除表头
		if(head == delNode){
			LinkedNode temp = head;
			head = head.next;
			temp = null;
		}else{//删除中间或者尾部
			LinkedNode tempHead = head;
			LinkedNode perious = head;
			while(tempHead != null){
				if(tempHead.data == delNode.data) break;
				perious = tempHead;
				tempHead = tempHead.next;
			}
			perious.next = tempHead.next;
			tempHead = null;
		}
	}
	
	/**
	 * 方法二：结点覆盖法
	 * 思路：
	 * 	删除节点M, M的下一个结点N
	 * 	当要删除的时候, 将N的内容赋值给M, 删除N
	 * 	缺陷：该方法基于一个假设, 待删除的结点的确在链表中
	 * 		如果结点不在链表中, 则需要O(N)的时间来遍历。
	 */
	public static void deleteNodeB(LinkedNode head, LinkedNode delNode){
		if(head == null || delNode == null) return ;
		//删除的结点, 不是尾结点
		if(delNode.next != null){
			LinkedNode nextNode = delNode.next;
			delNode.data = nextNode.data;
			delNode.next = nextNode.next;
			nextNode = null;
		}else if(head == delNode){ //链表只有一个节点, 删除头结点
			head = null;
			delNode = null;
		}else{ //尾结点, 遍历删除
			LinkedNode tempHead = head;
			LinkedNode perious = head;
			while(tempHead != null){
				if(tempHead.data == delNode.data) break;
				perious = tempHead;
				tempHead = tempHead.next;
			}
			perious.next = tempHead.next;
			tempHead = null;
		}
	}
}

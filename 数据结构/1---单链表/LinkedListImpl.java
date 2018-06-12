package jianzhiOffer;



/**
 * @author commonsstring@gmail.com
 * 
 * 数据结构
 * 实现链表
 * 单链表
 */

//单链表
class SignalListNode{
	private int value;
	private SignalListNode next;
	
	public SignalListNode(int value) {
		this.value = value;
	}
	
	//返回长度
	public static int getLength(SignalListNode head){
		int len = 0;
		SignalListNode currentNode = head;
		while(currentNode != null){
			len++;
			currentNode = currentNode.getNext();
		}
		return len;
	}
	
	//删除单向链表
	public static void clearAll(SignalListNode head){
		if(head == null) return ;
		SignalListNode tempNode, iterator = head;
		while(iterator != null){
			tempNode = iterator.getNext();
			iterator = null;
			iterator = tempNode;
		}
	}
	
	//打印链表
	public static void showListNode(SignalListNode head){
		if(head == null) return ;
		SignalListNode currentNode = head;
		while(currentNode != null){
			System.out.print(currentNode.getValue() + " ");
			currentNode = currentNode.getNext();
		}
	}
	
	//单链表的插入
	public static SignalListNode insertListNode(SignalListNode head, SignalListNode newNode, int position){
		//参数检查
		if(head == null) return newNode;
		//链表长度
		int size = getLength(head);
		//违法边界检查
		if(position > (size + 1) || position < 1){
			System.out.println("违法操作, 插入范围有误！");
			return head;
		}
		//插入链表, 在表头插入, 在表尾插入, 在表中间插入
		//表头插入
		if(position == 1){
			newNode.setNext(head);
			return newNode;
		}else{ //表中间或者表尾插入
			int count = 1;
			//获取position - 1 位置的结点
			SignalListNode preNode = head;
			while(count < position - 1){
				preNode = preNode.getNext();
				count++;
			}
			SignalListNode currentNode = preNode.getNext();
			newNode.setNext(currentNode);
			preNode.setNext(newNode);
		}
		return head;
	}
	
	//链表的删除
	public static SignalListNode deleteNode(SignalListNode head, int position){
		//参数检查
		if(head == null) return head;
		//链表长度
		int size = getLength(head);
		//插入范围检查
		if(position > size || position < 1){
			System.out.println("删除失败, 该位置的元素无法删除或不存在！");
			return head;
		}
		//头结点删除
		if(position == 1){
			SignalListNode nextNode = head.getNext();
			head = null;
			return nextNode;
		}else{ //中间或者尾部删除
			int count = 1;
			SignalListNode preNode = head;
			while(count < position - 1){
				preNode = preNode.getNext();
				count++;
			}
			SignalListNode currentNode = preNode.getNext();
			preNode.setNext(currentNode.getNext());
			currentNode = null;
		}
		return head;
	}
	
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public SignalListNode getNext() {
		return next;
	}
	public void setNext(SignalListNode next) {
		this.next = next;
	}
}

public class LinkedListImpl {
	
	
	public static void main(String[] args) {
		SignalListNode head = new SignalListNode(1);
		SignalListNode.insertListNode(head, new SignalListNode(2), 2);
		SignalListNode.insertListNode(head, new SignalListNode(3), 3);
		SignalListNode.showListNode(SignalListNode.deleteNode(head, 1));
	}
}

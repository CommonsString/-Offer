package strcut;


/**
 * @author commonsstring@gmail.com
 * 
 * 循环链表的实现
 * 在循环链表中, next指针不存在nul值
 */
class CycleLinked{
	private int val;
	private CycleLinked next;
	
	//获取长度
	public static int getLength(CycleLinked head){
		int count = 0;
		CycleLinked currentNode = head; 
		while(currentNode != null){
			count++;
			currentNode = currentNode.getNext();
			//回到头结点
			if(currentNode == head) break;
		}
		return count;
	}
	
	//输出内容
	public static void showLinked(CycleLinked head){
		if(head == null) {
			System.out.println("空链表");
		}
		CycleLinked currentNode = head;
		while(currentNode != null){
			System.out.print(currentNode.getVal() + " ");
			currentNode = currentNode.getNext();
			if(currentNode == head) break;
		}
	}
	
	//在表尾插入结点
	public static CycleLinked insettAtTail(CycleLinked head, CycleLinked newNode){
		//寻找表头的前驱结点
		CycleLinked currentNode = head;
		CycleLinked periousNode = head;
		while(currentNode!= null){
			periousNode = currentNode;
			currentNode = currentNode.getNext();
			if(currentNode == head) break;
		}
		//新节点指向本身
		newNode.setNext(newNode);
		if(head == null){
			head = newNode; 
		}else{ //在表头的前驱结点之后插入新节点
			newNode.setNext(head);
			periousNode.setNext(newNode);
		}
		return head;
	}
	
	//在表头位置插入
	public static CycleLinked insetAtHead(CycleLinked head, CycleLinked newNode){
		CycleLinked currentNode = head;
		CycleLinked periousNode = head;
		while(currentNode!= null){
			periousNode = currentNode;
			currentNode = currentNode.getNext();
			if(currentNode == head) break;
		}
		//新节点指向本身
		newNode.setNext(newNode);
		if(head == null){
			head = newNode;
		}else{ 
			newNode.setNext(head);
			periousNode.setNext(newNode);
			head = newNode;
		}
		return head;
	}
	
	//删除最后一个节点
	public static CycleLinked DeleteAtTailNode(CycleLinked head){
		CycleLinked temp = head;
		CycleLinked currentNode = head;
		if(head == null){
			System.out.println("空链表！");
			return head;
		}
		while(currentNode.getNext() != null){
			//暂存上一个节点
			temp = currentNode;
			currentNode = currentNode.getNext();
			if(currentNode == head) break;
		}
		temp.setNext(head);
		currentNode = null;
		return head;
	}
	
	//删除表头节点
	public static CycleLinked DeleteAtHeadNode(CycleLinked head){
		CycleLinked temp = head;
		CycleLinked currentNode = head;
		if(head == null){
			System.out.println("空链表！");
			return head;
		}
		while(currentNode.getNext() != null){
			//暂存上一个节点
			temp = currentNode;
			currentNode = currentNode.getNext();
			if(currentNode == head) break;
		}		 
		CycleLinked nextNode = head.getNext();
		temp.setNext(nextNode);
		head = null;
		return nextNode;
	}
	
	public CycleLinked(int val) {
		this.val = val;
	}
	public int getVal() {
		return val;
	}
	public void setVal(int val) {
		this.val = val;
	}
	public CycleLinked getNext() {
		return next;
	}
	public void setNext(CycleLinked next) {
		this.next = next;
	}	
}
public class CycleLinkedList {
	public static void main(String[] args) {
		CycleLinked head = new CycleLinked(1);
		CycleLinked node2 = new CycleLinked(2);
		CycleLinked node3 = new CycleLinked(3);
		head.setNext(node2);
		node2.setNext(node3);
		node3.setNext(head);
//		CycleLinked.showLinked(head);
//		System.out.println();
//		CycleLinked head2 = CycleLinked.insetAtHead(head, new CycleLinked(5));
//		CycleLinked head3 = CycleLinked.insetAtHead(head2, new CycleLinked(4));
//		CycleLinked.showLinked(head2);
//		System.out.println();
//		CycleLinked.showLinked(head3);
		CycleLinked head4 = CycleLinked.insettAtTail(head, new CycleLinked(4));
		CycleLinked head5 = CycleLinked.insettAtTail(head4, new CycleLinked(5));
		CycleLinked.showLinked(head5);
	}
}

package strcut;

/**
 * @author commonsstring@gmail.com
 * 
 * 双向链表实现
 */
class DoubleList{
	private int val;
	private DoubleList next = null; //后继
	private DoubleList previous = null; //前驱
	
	//链表的长度
	public static int getLength(DoubleList head){
		int count = 0;
		DoubleList current = head;
		while(current != null){
			count++;
			current = current.getNext();
		}
		return count;
	}
	
	//打印链表
	public static void showListNode(DoubleList head){
		if(head == null) return ;
		DoubleList currentNode = head;
		while(currentNode != null){
			System.out.print(currentNode.getVal() + " ");
			currentNode = currentNode.getNext();
		}
	}
	
	//链表的插入
	public static DoubleList insert(DoubleList head, DoubleList newNode, int position){
		if(head == null) return head;
		//链表长度
		int len = getLength(head);
		//参数范围检查
		if(position > len + 1 || position < 1){ 
			System.out.println("参数插入" + position + "位置违法！");
			return null;
		}
		//在表头插入
		if(position == 1){
			newNode.setNext(head);
			head.setPrevious(newNode);
			return newNode;
		}else{ //在表中间或结尾插入
			int count = 1;
			DoubleList currentNode = head;
			while(count < position - 1){
				count++;
				currentNode = currentNode.getNext();
			}
			newNode.setNext(currentNode.getNext());
			newNode.setPrevious(currentNode);
			currentNode.setNext(newNode);
			currentNode.getNext().setPrevious(newNode);
		}
		return head;
	}
	
	//链表的删除
	public static DoubleList delete(DoubleList head, int position){
		//参数检查
		if(head == null) return head;
		int len = getLength(head);
		//范围检查
		if(position > len || position < 1){
			System.out.println("删除位置" + position + "违法！");
			return head;
		}
		//删除表头
		if(position == 1){
			DoubleList currentNode = head.getNext();
			head = null;
			currentNode.setPrevious(null);
			return currentNode;
		}else{ //在中间或表尾删除
			int count = 0;
			DoubleList periousNode = head;
			while(count < position - 1){
				count++;
				periousNode = periousNode.getNext();
			}
			DoubleList currentNode  = periousNode.getNext();
			DoubleList laterNode = currentNode.getNext();
			periousNode.setNext(laterNode);
			if(laterNode != null){
				laterNode.setPrevious(periousNode);
			}
			currentNode = null;
		}
		return head;
	}
	
	public DoubleList(int val) {
		this.val = val;
	}
	public int getVal() {
		return val;
	}
	public void setVal(int val) {
		this.val = val;
	}
	public DoubleList getNext() {
		return next;
	}
	public void setNext(DoubleList next) {
		this.next = next;
	}
	public DoubleList getPrevious() {
		return previous;
	}
	public void setPrevious(DoubleList previous) {
		this.previous = previous;
	}
}

public class DoubleLinkedListImpl {

	public static void main(String[] args) {
		DoubleList head = new DoubleList(1);
		DoubleList node2 = new DoubleList(2);
		DoubleList node3 = new DoubleList(3);
		head.setPrevious(null);
		head.setNext(node2);
		node2.setPrevious(head);
		node2.setNext(node3);
		node3.setPrevious(node2);
		node3.setNext(null);
		DoubleList.showListNode(head);
		System.out.println();
		DoubleList head2 = DoubleList.delete(head, 1);
		DoubleList.showListNode(head2);
		
	}
	
	
}

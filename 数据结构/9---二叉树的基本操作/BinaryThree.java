package strcut;



/**
 * @author commonsstring@gmail.com
 * 
 * 二叉树查找/搜索树的基本操作
 * 性质：左子树, 小于根, 右子树大于根
 * 插入操作: 二叉查找树中, 一个元素只能出现一次, 即存在就不插入。
 * 删除操作：
 *   第一种情况, 删除叶子结点, 直接删除
 *   第二种情况, 仅存在左子树, 将当前结点的父节点的右指针, 指向当前结点的左孩子
 *   	                 仅存在右子树, 类似
 *   	                 注意根节点的情况
 *   第三种情况, 左右孩子都存在
 *            方法一: 在当前结点的左孩子中寻找最小值, 替换当前结点, 并删除最小值
 *            方法二：  在当前结点的右孩子中寻找最大值, 途欢当前结点, 并删除最大值
 * URL: https://www.cnblogs.com/MrListening/p/5782752.html
 *      https://www.2cto.com/kf/201608/534473.html
 */
public class BinaryThree {
	//值域
	private int data;
	//左孩子
	private BinaryThree left = null;
	//右孩子
	private BinaryThree right = null;
	
	public BinaryThree(int value) {
		this.data = value;
	}
	
	//查找一个元素
	public static BinaryThree find(BinaryThree head, int value){
		//头结点
		BinaryThree tempHead = head;
		while(tempHead != null){
			//头结点
			if(tempHead.getData() == value){
				return tempHead;
			}else{
				//当前结点 > 查找值
				if(tempHead.getData() > value){
					tempHead = tempHead.getLeft();
				}else{
					tempHead = tempHead.getRight();
				}
			}
		}
		return tempHead;
	}
	
	
	//向树中插入一个元素
	public static boolean insert(BinaryThree head, int value){
		//头结点
		BinaryThree tempHead = head;
		int flag = 0; // 1 表示左子树, -1 表示右子树
		//根为空, 直接插入
		if(head == null){
			head = new BinaryThree(value);
			return true;
		}
		BinaryThree target = find(head, value);
		//如果存在, 不插入, 不存在, 在合适的位置插入.
		if(target != null) return false;
		BinaryThree perious = null;
		while(tempHead != null){
			if(tempHead.getData() > value){
				perious = tempHead;
				tempHead = tempHead.getLeft();
				flag = -1;
			}else{
				perious = tempHead;
				tempHead = tempHead.getRight();
				flag = 1;
			}
		}
		//新节点
		BinaryThree newNode = new BinaryThree(value);
		//左子树
		if(flag == -1){
			perious.setLeft(newNode);
		}else{
			perious.setRight(newNode);
		}
		return true;
	}
	
	//删除一个元素
	@SuppressWarnings("unused")
	public static boolean delete(BinaryThree head, int value){
		//当前结点
		BinaryThree tempHead = head;
		//父节点
		BinaryThree parent = null;
		while(tempHead != null && tempHead.getData() != value){
			if(tempHead.getData() > value){
				parent = tempHead;
				tempHead = tempHead.getLeft();
			}else{
				parent = tempHead;
				tempHead = tempHead.getRight();
			}
		}
		if(tempHead == null) return false;
		//只有左孩子
		if(tempHead.getRight() == null && tempHead.getLeft() != null){
			//根节点
			if(tempHead == head){
				head = tempHead.getLeft();
			}else{
				//将父节点的右指针, 指向当前结点的左孩子
				parent.setRight(tempHead.getLeft());
			}
			tempHead = null;
		}else if(tempHead.getLeft() == null && tempHead.getRight() != null){
			//根节点
			if(tempHead == head){
				head = tempHead.getRight();
			}else{
				//只有右孩子, 将父节点的左指针, 指向当前结点的右孩子
				parent.setLeft(tempHead.getRight());
			}
			tempHead = null;
		}else{ //存在左右结点
			//查找当前结点右子树中的最左结点, 也就是查找当前结点右子树的最小结点
			BinaryThree currentLeft = tempHead.getRight();
			parent = tempHead;
			while(currentLeft.getLeft() != null){
				parent = currentLeft;
				currentLeft = currentLeft.getLeft();
			}
			BinaryThree del = currentLeft;
			//交换结点的值
			tempHead.setData(currentLeft.getData());
			//删除currentLeft, 
			if(parent.getLeft() == currentLeft){
				//左孩子, 指向删除节点的右孩子
				parent.setLeft(currentLeft.getRight());
			}else{
				//右孩子, 指向删除节点的左孩子
				parent.setRight(currentLeft.getRight());
			}
			del = null;
		}
		return true;
	}
	
	public static void main(String[] args) {
		BinaryThree head = new BinaryThree(5);
		BinaryThree node1 = new BinaryThree(1);
		BinaryThree node2 = new BinaryThree(2);
		BinaryThree node3 = new BinaryThree(3);
		BinaryThree node4 = new BinaryThree(4);
		
		BinaryThree node6 = new BinaryThree(6);
		BinaryThree node7 = new BinaryThree(7);
		BinaryThree node8 = new BinaryThree(8);
		BinaryThree node9 = new BinaryThree(9);
		head.setLeft(node4);
		head.setRight(node6);
		node4.setLeft(node2);
		node2.setLeft(node1);
		node2.setRight(node3);
		node6.setRight(node8);
		node8.setLeft(node7);
		node8.setRight(node9);
		System.out.println(BinaryThree.delete(head, 5));
		System.out.println(BinaryThree.find(head, 5));
		System.out.println(node6.getRight().getData());
	}
	
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public BinaryThree getLeft() {
		return left;
	}
	public void setLeft(BinaryThree left) {
		this.left = left;
	}
	public BinaryThree getRight() {
		return right;
	}
	public void setRight(BinaryThree right) {
		this.right = right;
	}
}

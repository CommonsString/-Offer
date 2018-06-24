package strcut;

import java.util.Stack;

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
	
	//后序遍历, 结点是否第一次处于栈顶
	private boolean isFlag = false;
	
	public BinaryThree(int value) {
		this.data = value;
	}
	
	
	//二叉树的高度, 分别求左右子树的高度, 然后取较长的子树作为数的高度
	public static int getHeight(BinaryThree head){
		//根为空, 高度为0
		if(head == null) return 0;
		int height = 0;
		int leftHeight = getHeight(head.getLeft());
		int rightHeight = getHeight(head.getRight());
		height = leftHeight > rightHeight ? leftHeight + 1 : rightHeight + 1;
		return height;
	}
	
	//遍历操作, 递归前序遍历
	public static void recursivePreorderShow(BinaryThree head){
		if(head == null){
			return ;
		}
		System.out.print(head.getData() + " ");
		recursivePreorderShow(head.getLeft());
		recursivePreorderShow(head.getRight());
	}
	
	//非递归前序遍历
	//https://www.cnblogs.com/hapjin/p/5679482.html
	public static void PreorderShow(BinaryThree head){
		if(head == null) return ;
		//辅助栈
		Stack<BinaryThree> myStack = new Stack<BinaryThree>();
		BinaryThree current = head;
		BinaryThree tempNode = null;
		while(true){
			//根节点, 一直访问左结点
			while(current != null){
				System.out.print(current.getData() + " ");
				myStack.push(current);
				current = current.getLeft();
			}
			//访问右结点
			if(myStack.isEmpty()) break;
			tempNode = myStack.pop();
			current = tempNode.getRight();
		}
	}
	
	//递归中序遍历
	public static void recursiveMiddleOrder(BinaryThree head){
		if(head == null) return ;
		recursiveMiddleOrder(head.getLeft());
		System.out.print(head.getData() + " ");
		recursiveMiddleOrder(head.getRight());
	}
	
	
	//非递归, 中序遍历
	public static void MiddleOrder(BinaryThree head){
		if(head == null) return ;
		//辅助栈
		Stack<BinaryThree> myStack = new Stack<BinaryThree>();
		BinaryThree current = head;
		BinaryThree tempNode = null;
		while(current != null || !myStack.isEmpty()){
			//从根节点一直走到最左下的结点
			while(current != null){
				myStack.push(current);
				current = current.getLeft();
			}
			//出栈, 并打印
			if(!myStack.isEmpty()){
				tempNode = myStack.pop();
				System.out.print(tempNode.getData() + " ");
				//当前弹出的右结点
				current = tempNode.getRight();
			}
		}
	}
	
	//递归后序遍历
	public static void recursiveLastOrder(BinaryThree head){
		if(head == null) return ;
		recursiveLastOrder(head.getLeft());
		recursiveLastOrder(head.getRight());
		System.out.print(head.getData() + " ");
	}
	
	/**
	 * 非递归后序遍历(书上的代码, 待修改)
	 * 后序遍历, 每个结点需要访问两次, 即在遍历完左子树后需要访问当前结点, 之后遍历完右子树之后还需要访问当前结点
	 * 但是, 只有在第二次访问时才处理当前结点
	 * 如何区分, 是遍历完左子树后的返回, 还是遍历完右子树后的返回？
	 * 解决方案：
	 * 		当从栈中出栈一个元素, 检查这个元素与栈顶元素的右结点是否相同。
	 * 		相同, 说明已经完成左右子树的遍历, 此时只需要再将栈顶元素出栈一次, 并输出该节点是数据即可。
	 */
	public static void lastOrder(BinaryThree head){
		if(head == null) return ;
		Stack<BinaryThree> myStack = new Stack<BinaryThree>();
		BinaryThree current = head;
		while(true){
			//遍历左子树
			if(current != null){
				myStack.push(current);
				current = current.getLeft();
			}else{
				if(myStack.isEmpty()){
					System.out.println("Stack is empty!");
					return ;
				}else{
					//栈顶元素的右孩子
					if(myStack.peek().getRight() == null){
						//出栈一个元素
						BinaryThree temp = myStack.pop();
						//出栈元素(结点)与当前栈顶元素的右结点是否相等
						System.out.print(temp.getData() + " ");
						if(temp == myStack.peek().getRight()){
							//相等, 说明左右子树已经遍历完毕, 栈顶元素出栈处理
							System.out.print(myStack.peek().getData() + " ");
							myStack.pop();
						}
					}
				}
				if(!myStack.isEmpty()){
					current = myStack.peek().getRight();
				}else{
					current = null;
				}
			}
		}
	}

	/**
	 * 非递归后序遍历
	 * 后序遍历, 需要把左右子树访问完成之后, 才能处理访问根结点。
	 * 所以, 根结点出现在栈顶不能立马去访问它, 还需要确定它的左右子树是否被访问。
	 * 设置一个变量, 记录当前栈顶结点是否可以被访问, 可以弹出处理, 不可以需要把左右子树分别入栈。 
	 */
	public static void lastOrderSecond(BinaryThree head){
		if(head == null) return;
		Stack<BinaryThree> myStack = new Stack<BinaryThree>();
		BinaryThree current = head;
		BinaryThree temp = null;
		while(true){
			//入栈左结点
			while(current != null){
				myStack.push(current);
				current = current.getLeft();
			}
			if(myStack.isEmpty()) break;
			//获取栈顶
			temp = myStack.peek();
			//从左子树返回, 需要判断右子树是否已经被访问
			if(temp.isFlag == false){
				temp.isFlag = true;
				current = temp.getRight();
			}else{
				//左右已经遍历, 处理当前结点
				temp = myStack.pop();
				System.out.print(temp.getData() + " ");
			}
		}
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
		
		recursiveLastOrder(head);
		System.out.println();
		lastOrderSecond(head);
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

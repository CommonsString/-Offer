package strcut;

/**
 * @author commonsstring@gmail.com
 * 平衡二叉树(平衡二叉搜索树):
 * 性质：一颗空格树, 或者它的左右两个子树的高度差不超过1, 并且左右两个子树都是一颗平衡二叉树。
 * 常用实现方法：红黑树, AVL, 替罪羊树, 伸展树
 * 最小平衡二叉树的结点公式, 即填充一颗平衡二叉树的最小结点数：
 * 		F(n) = F(n - 1) + F(n - 2) + 1;
 * 		F(n - 1) ：左子树的结点数量
 * 		F(n - 2) ：右子树的结点数量
 * 		1 : 表示根节点, 即当前结点
 * 平衡二叉树结点调整：http://www.cnblogs.com/huangxincheng/archive/2012/07/22/2603956.html
 */

/**
 * 平衡二叉树的实现之AVL树
 * 	AVL树(高度平衡树), 概念：
 * 		在该树中, 任何结点的两个子树的最大高度差别为1。
 * 		查找、新增、删除平均和最坏情况都是O(logN)
 *  结点的平衡因子：当前的结点的左子树减去右子树的高度, 即 0, 1, -1认为是平衡的, -2, 2认为是不平衡的。
 *  旋转算法:
 *  	借助于两个功能的辅助, 一个是求树的高度, 一个是求两个高度的最大值
 *  https://www.jianshu.com/p/51f26db28a67
 */
public class BalancingBinaryThree {

	public static void main(String[] args) {
		int[] data = {20, 35, 40, 15, 30, 25, 38};
		AVLBinaryTree head = new AVLBinaryTree(20);
		AVLBinaryTree newHead = AVLBinaryTree.insert(head, 35);
		AVLBinaryTree newHead2 = AVLBinaryTree.insert(newHead, 40);
		AVLBinaryTree newHead3 =  AVLBinaryTree.insert(newHead2, 15);
		AVLBinaryTree newHead4 =  AVLBinaryTree.insert(newHead3, 30);
		AVLBinaryTree.preShow(newHead4);
		
	}
	
}

class AVLBinaryTree{
	
	//值
	public int key;
	//高度信息, 平衡因子
	public int height;
	//左右结点
	public AVLBinaryTree left = null;
	public AVLBinaryTree right = null;
	
	public AVLBinaryTree(int key) {
		this.key = key;
	}
	
	//获取高度
	public static int getHeight(AVLBinaryTree head){
		return head == null ? -1 : head.height;
	}
	
	//查找, BST相同
	public static AVLBinaryTree find(AVLBinaryTree head, int value){
		if(head == null){
			return head;
		}
		return null;
	}
	
	//前序遍历
	public static void preShow(AVLBinaryTree head){
		if(head == null){
			return ;
			
		}
		System.out.print(head.key + " ");
		preShow(head.left);
		preShow(head.right);
	}
	
	//插入
	public static AVLBinaryTree insert(AVLBinaryTree head, int data){
		//头尾空,创建结点
		AVLBinaryTree current = head;
		if(current == null){
			current = new AVLBinaryTree(data);
			current.height = 0;
		}else{
			//插入结点大于父节点, 插入右子树
			if(data > current.key){
				current.right = insert(current.right, data);
				//查看是否平衡
				if((getHeight(current.right) - getHeight(current.left)) == 2){
					if(data < current.key){
						//RL旋转
						current = RL_Rotate(current);
					}else{
						//RR旋转
						current = RR_Rotate(current);
					}
				}
			}else if(data < current.key){ //插入左子树
				current.left = insert(current.left, data);
				//查看是否平衡
				if((getHeight(current.left) - getHeight(current.right)) == 2){
					if(data > current.key){
						//LR旋转
						current = LR_Rotate(current);
					}else{
						//LL旋转
						current = LL_Rotate(current);
					}
				}		
			}else{
				System.out.println("数据已经存在, 无法插入！");
			}
		}
		//更新结点高度
		current.height = Math.max(getHeight(current.left), getHeight(current.right)) + 1;
		return current;
	}
	
	//删除
	public static boolean delete(AVLBinaryTree head, AVLBinaryTree delNode){
		
		return false;
	}
	
	/**
	 * LL型旋转(单旋转)
	 * 插入结点是在失衡结点A的左子树的左子树下
	 * 
	 * @param currentNode 失衡结点
	 * @return
	 */
	public static AVLBinaryTree LL_Rotate(AVLBinaryTree currentNode){
		//失衡结点的左孩子
		AVLBinaryTree top = currentNode.left;
		//截断联系
		currentNode.left = top.right;
		top.right = currentNode;
		//更新结点的高度, + 1
		currentNode.height = Math.max(getHeight(currentNode.left), 
				getHeight(currentNode.right)) + 1;
		top.height =  Math.max(getHeight(top.left), getHeight(top.right)) + 1;
		return top;
	}
	
	/**
	 * RR型旋转(单旋转)
	 * @param currentNode 不满足AVL性质的根节点
	 * @return
	 */
	public static AVLBinaryTree RR_Rotate(AVLBinaryTree currentNode){
		AVLBinaryTree top = currentNode.right;
		currentNode.right = top.left;
		top.left = currentNode;
		currentNode.height = Math.max(getHeight(currentNode.left), 
				getHeight(currentNode.right)) + 1;
		top.height = Math.max(getHeight(top.left), getHeight(top.right)) + 1;
		return top;
	}
	
	
	/**
	 * LR型旋转(双旋转)
	 * @return
	 */
	public static AVLBinaryTree LR_Rotate(AVLBinaryTree currentNode){
		//失衡结点的左子树, 左左旋转
		AVLBinaryTree left = currentNode.left;
		//RR旋转
		currentNode.left = RR_Rotate(left);
		//LL旋转
		return LL_Rotate(currentNode);
	}
	
	/**
	 * RL型旋转(双旋转)
	 * @return
	 */
	public static AVLBinaryTree RL_Rotate(AVLBinaryTree currentNode){
		//失衡结点的右子树, 右右旋转
		AVLBinaryTree right = currentNode.right;
		//LL旋转0
		currentNode.right = LL_Rotate(right);
		//当前结点RR旋转
		return RR_Rotate(currentNode);
	}
	
	
	
}

